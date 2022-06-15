package com.epam.bookstore.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageFilter implements Filter {
    private String languageName;
    private Integer langId;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        languageName = filterConfig.getInitParameter("langNameDefault");
        langId = Integer.valueOf(filterConfig.getInitParameter("langIdDefault"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();

        String language = (String) session.getAttribute("language");

        if (language == null) {
            session.setAttribute("language", languageName);
            session.setAttribute("languageId", langId);
        } else if (language.equals("ru")) {
            session.setAttribute("language", "ru");
            session.setAttribute("languageId", 2);
        } else if (language.equals("en")) {
            session.setAttribute("language", "en");
            session.setAttribute("languageId", 1);
        }

        servletResponse.setContentType("text/html;charset=UTF-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
