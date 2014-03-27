/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 *
 * @author Zhuk
 */
@Entity
@Table(name = "answer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discr", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("A")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "answ_num")
    private Integer answNum;
    @Column(name = "discr", insertable = false, updatable = false)
    private String discr;
    @Column(name = "answerList_ORDER")
    private Integer answerListORDER;
    @JoinColumn(name = "subq_id", referencedColumnName = "id")
    @ManyToOne
    private Subq subqId;
    @JoinColumn(name = "quest_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Quest questId;

    public Answer() {
    }

    public Answer(Integer id) {
        this.id = id;
    }

    public Answer(Integer id, String name, int answNum) {
        this.id = id;
        this.name = name;
        this.answNum = answNum;
    }

    public String getDiscr() {
        return discr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAnswNum() {
        return answNum;
    }

    public void setAnswNum(Integer answNum) {
        this.answNum = answNum;
    }  

    public Integer getAnswerListORDER() {
        return answerListORDER;
    }

    public void setAnswerListORDER(Integer answerListORDER) {
        this.answerListORDER = answerListORDER;
    }

    public Subq getSubqId() {
        return subqId;
    }

    public void setSubqId(Subq subqId) {
        this.subqId = subqId;
    }

    public Quest getQuestId() {
        return questId;
    }

    public void setQuestId(Quest questId) {
        this.questId = questId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Answer[ id=" + id + " ]";
    }

}
