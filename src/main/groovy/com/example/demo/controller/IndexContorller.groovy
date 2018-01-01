package com.example.demo.controller

import com.example.demo.entity.Board
import com.example.demo.entity.Post
import com.example.demo.entity.Reply
import com.example.demo.exception.PostNotFoundException
import com.example.demo.service.BoardService
import com.example.demo.service.PostService
import com.example.demo.service.ReplyService
import com.example.demo.validator.PostValidator
import com.example.demo.validator.ReplyValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

import javax.validation.Valid

/**
 * Created by ksb on 2017. 12. 22..
 */
@Controller
class IndexContorller {

    @Autowired
    BoardService boardServiceImpl

    @Autowired
    PostService postServiceImpl

    @Autowired
    ReplyService replyServiceImpl

    @Autowired
    PostValidator postValidator

    @Autowired
    ReplyValidator replyValidator

    @InitBinder('post')
    private void initBinderByPost(WebDataBinder binder) {
        binder.addValidators(postValidator)
    }

    @InitBinder('reply')
    private void initBinderByReply(WebDataBinder binder) {
        binder.addValidators(replyValidator)
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView index(@RequestParam (value="activeBoardId", required=false) Long activeBoardId,
                      @RequestParam (value="searchWord", defaultValue = "") String searchWord,
                      @PageableDefault(value = 4, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView('index')
        List<Board> boardList = boardServiceImpl.getAll()
        activeBoardId = activeBoardId == null ? boardList.get(0).getId() : activeBoardId
        Page<Post> postPage = postServiceImpl.getAll(pageable, activeBoardId, searchWord)

        modelAndView.addObject('boardList', boardList)
        modelAndView.addObject('activeBoardId', activeBoardId)
        modelAndView.addObject('searchWord', searchWord)
        modelAndView.addObject('postPage', postPage)
        modelAndView
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    ModelAndView detail(@RequestParam (value="activeBoardId", required=false) Long activeBoardId,
                        @RequestParam (value="postId", required=true) long postId) {
        ModelAndView modelAndView = new ModelAndView('detail')
        List<Board> boardList = boardServiceImpl.getAll()
        activeBoardId = activeBoardId == null ? boardList.get(0).getId() : activeBoardId
        Post post = postServiceImpl.get(postId)
        List<Reply> replyList = replyServiceImpl.getAll(postId)

        if(post == null) throw new PostNotFoundException()

        modelAndView.addObject('boardList', boardList)
        modelAndView.addObject('activeBoardId', activeBoardId)
        modelAndView.addObject('post', post)
        modelAndView.addObject('replyList', replyList)
        modelAndView
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    ModelAndView form(@RequestParam (value="activeBoardId", required=true) Long activeBoardId,
                      @RequestParam (value="postId", required=false) Long postId) {
        ModelAndView modelAndView = new ModelAndView('form')
        List<Board> boardList = boardServiceImpl.getAll()
        activeBoardId = activeBoardId == null ? boardList.get(0).getId() : activeBoardId

        modelAndView.addObject('boardList', boardList)
        modelAndView.addObject('activeBoardId', activeBoardId)

        if(postId!=null) {
            Post post = postServiceImpl.get(postId)
            if(post == null) throw new PostNotFoundException()
            modelAndView.addObject('post', post)
        }

        modelAndView
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String save(@RequestParam (value="activeBoardId", required=true) Long activeBoardId,
                @Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/form?activeBoardId=${activeBoardId}"
        }

        if(post.getId() == null) {
            post.setId(postServiceImpl.create(post))
        } else {
            postServiceImpl.update(post)
        }

        "redirect:/detail?activeBoardId=${activeBoardId}&postId=${post.id}"
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    String deletePost(@RequestParam (value="activeBoardId", required=true) Long activeBoardId,
                      @RequestParam (value="postId", required=true) Long postId) {
        postServiceImpl.delete(postId)
        "redirect:/?activeBoardId=${activeBoardId}"
    }

    @RequestMapping(value = "/saveReply", method = RequestMethod.POST)
    String saveReply(@RequestParam (value="activeBoardId", required=true) Long activeBoardId,
                     @RequestParam (value="postId", required=true) Long postId,
                     @Valid Reply reply, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/detail?activeBoardId=${activeBoardId}&postId=${postId}"
        }

        if(reply.getId() == null) {
            reply.setId(replyServiceImpl.create(reply))
        } else {
            replyServiceImpl.update(reply)
        }

        "redirect:/detail?activeBoardId=${activeBoardId}&postId=${postId}"
    }

    @RequestMapping(value = "/deleteReply", method = RequestMethod.POST)
    String deleteReply(@RequestParam (value="activeBoardId", required=true) Long activeBoardId,
                             @RequestParam (value="postId", required=true) Long postId,
                             @RequestParam (value="replyId", required=true) Long replyId) {
        replyServiceImpl.delete(replyId)
        "redirect:/detail?activeBoardId=${activeBoardId}&postId=${postId}"
    }

}
