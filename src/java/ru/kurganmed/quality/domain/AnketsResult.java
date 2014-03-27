/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Zhuk
 */
@Entity
@Table(name = "ankets_result")
public class AnketsResult implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "events_id", nullable = false)
    private Events events;
    @Column(name = "anketNum", nullable = false)
    private Integer anketNum;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ins_date", nullable = false, length = 19)
    private Date insDate;
    @Column(name = "ipaddr", length = 15)
    private String ipaddr;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "anketsResult", cascade = CascadeType.ALL)
    private List<QuestResult> questResults;

    public AnketsResult() {
    }

    public AnketsResult(Events events) {
        this.events = events;          
    }

    public AnketsResult(Events events, int anketNum, Date insDate, String ipaddr, List<QuestResult> questResults) {
        this.events = events;
        this.anketNum = anketNum;
        this.insDate = insDate;
        this.ipaddr = ipaddr;
        this.questResults = questResults;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public Integer getAnketNum() {
        return anketNum;
    }

    public void setAnketNum(Integer anketNum) {
        this.anketNum = anketNum;
    }   

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public List<QuestResult> getQuestResults() {
        return questResults;
    }

    public void setQuestResults(List<QuestResult> questResults) {
        this.questResults = questResults;
    }

}
