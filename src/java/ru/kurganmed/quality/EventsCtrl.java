/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import ru.kurganmed.quality.domain.Events;

/**
 *
 * @author Zhuk
 */
@Named(value = "evnt")
@Scope("session")
public class EventsCtrl implements Serializable {

    @Autowired
    private QtyDAO qtyDAO;

    private List<Events> events;        //список событий

    private Integer currentEventsID = 0;  //ID текущего, выбранного пользователем событие
    private Events currentEvent;        //выбранное пользователем событие

    @PostConstruct
    public void init() {
        events = qtyDAO.getEvents(); //получение списка событий
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public EventsCtrl() {
    }

    public Integer getCurrentEventsID() {
        return currentEventsID;
    }

    public void setCurrentEventsID(Integer currentEventsID) {
        this.currentEventsID = currentEventsID;       
        
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId() == this.currentEventsID) {
                this.currentEvent = events.get(i);
                break;
            }
        }
    }

    public Events getCurrentEvent() {
        return currentEvent;
    }

    public void setCurrentEvent(Events currentEvent) {
        this.currentEvent = currentEvent;
    }

}
