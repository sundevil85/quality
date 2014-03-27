/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Zhuk
 */
@Entity
@Table(name = "quest")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discr", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("A")
public class Quest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "quest_num")
    private Short questNum;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @Column(name = "discr")
    private String discr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questId")
    private Set<Subq> subqSet = new HashSet<Subq>(0);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questId")
    private Set<Answer> answerSet = new HashSet<Answer>(0);
    @JoinColumn(name = "anket_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ankets anketId;
    @Column(name = "layout")
    private String layout;

    @Transient
    private List<Answer> answerList;//дубль answerSet в интерфейсе List - для того чтобы можно было обращаться из JSF страниц

    @Transient
    private List<Subq> subqList;//тоже самое

    public Quest() {
    }

    public Quest(Integer id) {
        this.id = id;
    }

    public Quest(Integer id, Short questNum, String value) {
        this.id = id;
        this.questNum = questNum;
        this.value = value;
    }

    public String getLayout() {
        if (this.layout.equals("H")) {
            return "lineDirection";
        } else {
            return "pageDirection";
        }
    }

    public String getDiscr() {
        return discr;
    }

    public List<Subq> getSubqList() {
        subqList = new ArrayList<>(this.subqSet);
        return subqList;
    }

    public void setSubqList(List<Subq> subqList) {
        this.subqList = subqList;
    }

    public List<Answer> getAnswerList() {
        answerList = new ArrayList<>(this.answerSet);//получаем список вариантов
        Collections.sort(answerList, new Comparator<Answer>() { //проводим его сортировку по номеру вопроса
            @Override
            public int compare(Answer o1, Answer o2) {
                return o1.getAnswNum().compareTo(o2.getAnswNum());
            }
        });
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getQuestNum() {
        return questNum;
    }

    public void setQuestNum(Short questNum) {
        this.questNum = questNum;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<Subq> getSubqSet() {
        return subqSet;
    }

    public void setSubqSet(Set<Subq> subqSet) {
        this.subqSet = subqSet;
    }

    public Set<Answer> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
        this.answerSet = answerSet;
    }

    public Ankets getAnketId() {
        return anketId;
    }

    public void setAnketId(Ankets anketId) {
        this.anketId = anketId;
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
        if (!(object instanceof Quest)) {
            return false;
        }
        Quest other = (Quest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Quest[ id=" + id + " ]";
    }

}
