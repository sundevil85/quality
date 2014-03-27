/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.kurganmed.quality.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Zhuk
 */
@Entity
@Table(name = "subq")
public class Subq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "subq_num")
    private int subqNum;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "subqList_ORDER")
    private Integer subqListORDER;
    @JoinColumn(name = "quest_id", referencedColumnName = "id")
    @ManyToOne(optional = false)    
    private Quest questId;
    @OneToMany(mappedBy = "subqId")
    private List<Answer> answerList;

    public Subq() {
    }

    public Subq(Integer id) {
        this.id = id;
    }

    public Subq(Integer id, int subqNum, String name) {
        this.id = id;
        this.subqNum = subqNum;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSubqNum() {
        return subqNum;
    }

    public void setSubqNum(int subqNum) {
        this.subqNum = subqNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSubqListORDER() {
        return subqListORDER;
    }

    public void setSubqListORDER(Integer subqListORDER) {
        this.subqListORDER = subqListORDER;
    }

    public Quest getQuestId() {
        return questId;
    }

    public void setQuestId(Quest questId) {
        this.questId = questId;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
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
        if (!(object instanceof Subq)) {
            return false;
        }
        Subq other = (Subq) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Subq[ id=" + id + " ]";
    }
    
}
