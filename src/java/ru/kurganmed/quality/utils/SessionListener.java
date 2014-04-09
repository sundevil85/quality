/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.kurganmed.quality.utils;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.log4j.Logger;

/**
 *
 * @author Zhuk
 */
public class SessionListener implements HttpSessionListener {
    
    private final String SESS_FLAG = "SessionCreated";
    private final Logger logger = Logger.getLogger(SessionListener.class);

    /*
    при создании сессии создаем флаг
    */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
//       HttpSession session = se.getSession();
//       session.setAttribute(SESS_FLAG,true); 
        logger.debug("Session created! in "+System.currentTimeMillis());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
//        HttpSession session = se.getSession();
//        session.removeAttribute(SESS_FLAG);
    }
    
}
