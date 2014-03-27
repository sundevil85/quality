/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Zhuk
 */
@Entity
@Table(name = "quest_result")
public class QuestResult implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anketsresult_id", nullable = false)
    private AnketsResult anketsResult;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subq_id")
    private Subq subq;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quest_id", nullable = false)
    private Quest quest;
    @Column(name = "answNum")
    private Integer answNum;
    @Column(name = "value")
    private String value;

    public QuestResult() {
    }

    public QuestResult(AnketsResult anketsResult, Quest quest, Subq subq) {
        this.anketsResult = anketsResult;
        this.quest = quest;
        this.subq = subq;
    }

    public QuestResult(AnketsResult anketsResult, Subq subq, Quest quest, Integer answNum, String value) {
        this.anketsResult = anketsResult;
        this.subq = subq;
        this.quest = quest;
        this.answNum = answNum;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AnketsResult getAnketsResult() {
        return anketsResult;
    }

    public void setAnketsResult(AnketsResult anketsResult) {
        this.anketsResult = anketsResult;
    }

    public Subq getSubq() {
        return subq;
    }

    public void setSubq(Subq subq) {
        this.subq = subq;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Integer getAnswNum() {
        return answNum;
    }

    public void setAnswNum(Integer answNum) {
        this.answNum = answNum;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "QuestResult{" + "id=" + id + ", anketsResult=" + anketsResult + ", subq=" + subq + ", quest=" + quest + ", answNum=" + answNum + ", value=" + value + '}';
    }
    
    

}
