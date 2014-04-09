/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Zhuk
 */
public class Util {

    public static String getIPAddr() {
        return ((HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().getRequest()).getRemoteAddr();

    }

}
