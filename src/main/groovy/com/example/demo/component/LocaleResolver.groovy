package com.example.demo.component

import org.springframework.stereotype.Component
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver

import javax.servlet.http.HttpServletRequest

/**
 * Created by ksb on 2017. 12. 20..
 */
@Component
class LocaleResolver extends AcceptHeaderLocaleResolver {

    private static final Locale korea = new Locale('ko')
    private static final Locale english = new Locale('en')
    private static final Locale spanish = new Locale('es')
    private static final List<Locale> LOCALES = [korea, english, spanish]

    @Override
    Locale resolveLocale(HttpServletRequest request) {
        if (!request.getHeader('Accept-Language')) {
            return english
        }
        List<Locale.LanguageRange> list = Locale.LanguageRange.parse(request.getHeader('Accept-Language'))
        Locale locale = Locale.lookup(list, LOCALES)
        locale ?: english
    }

}