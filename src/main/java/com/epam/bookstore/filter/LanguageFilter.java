package com.epam.bookstore.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageFilter implements Filter {
    private String languageName;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        languageName = filterConfig.getInitParameter("langName");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpSession session = httpServletRequest.getSession();
//
//        String language = (String) session.getAttribute("language");
//
//        if (language == null) {
//            session.setAttribute("language", languageName);
//        } else if (language.equals("ru")) {
//            session.setAttribute("language", "ru");
//        } else if (language.equals("en")) {
//            session.setAttribute("language", "en");
//        }

//        servletResponse.getWriter().write("after");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
