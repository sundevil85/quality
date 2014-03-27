/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import ru.kurganmed.quality.domain.Ankets;
import ru.kurganmed.quality.domain.Events;

/**
 *
 * @author Zhuk
 */
@Named(value="mbean")
@Scope("session")
public class Mbean implements Serializable {

    @Autowired
    private QtyDAO qtyDAO;

    private String myStr = "Empty";

    public void init() {

       List<Events> ankets = qtyDAO.getEvents();
          myStr="Ankets count "+Integer.toString(ankets.size());
    }

    public String getMyStr() {
        return myStr;
    }

    public void setMyStr(String myStr) {
        this.myStr = myStr;
    }

    public QtyDAO getQtyDAO() {
        return qtyDAO;
    }

    public void setQtyDAO(QtyDAO qtyDAO) {
        this.qtyDAO = qtyDAO;
    }
   

    public Mbean() {
    }

}
