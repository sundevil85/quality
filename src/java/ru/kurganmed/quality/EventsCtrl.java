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

    private List<Events> events;          //список событий

    private Integer currentEventsID = 0;  //ID текущего, выбранного пользователем событие
    private Events currentEvent;         //выбранное пользователем событие

    private Integer fact;               //фактическое число анкет по текущему событию
    private Double percent;             //процент от плана 

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

    public Integer getFact() {
        fact = qtyDAO.getAnketsResultCount(currentEvent).intValue();
        return fact;
    }

    public void setFact(Integer fact) {
        this.fact = fact;
    }

    public Double getPercent() {
        if (currentEvent.getPlan().intValue() > 0) {
            return fact * 100 / currentEvent.getPlan().doubleValue();
        } else {
            return 0D;
        }
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Events getCurrentEvent() {
        return currentEvent;
    }

    public void setCurrentEvent(Events currentEvent) {
        this.currentEvent = currentEvent;
    }

}
