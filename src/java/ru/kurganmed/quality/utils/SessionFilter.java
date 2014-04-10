/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Zhuk
 */
/*
 фильтр отслеживает наличие сессии пользователя, 
 если сесси нет то отправляет на главную страницу
 */
public class SessionFilter implements Filter {

    private final String[] homePageArrays = {"/quality/index.xhtml", "/quality", "/quality/"};
    private final String HOME_PAGE = "/quality/index.xhtml";

    private final Logger logger = Logger.getLogger(SessionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //метод возвращает true если запрос идет к главной странице
    private boolean requestInHomePage(String url) {
        for (String s : homePageArrays) {
            if (url.endsWith(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        //logger.debug("Test request "+httpRequest.getRequestURL()+" "+requestInHomePage(httpRequest.getRequestURL().toString()));
       
        //если сессии нет и запрос направлен не на главную страницу, то
        //перенаправляем на главную
        if ((session == null) && (!requestInHomePage(httpRequest.getRequestURL().toString()))) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(HOME_PAGE);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
