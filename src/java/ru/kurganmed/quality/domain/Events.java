/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Zhuk
 */
@Entity
@Table(name = "events")
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_b")
    @Temporal(TemporalType.DATE)
    private Date dateB;
    @Column(name = "date_e")
    @Temporal(TemporalType.DATE)
    private Date dateE;
    @Basic(optional = false)
    @Column(name = "opened")
    private boolean opened;
    @JoinColumn(name = "lpu_id", referencedColumnName = "oid")
    @ManyToOne(optional = false)
    private Lpu lpuId;
    @JoinColumn(name = "anket_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ankets anketId;
    @Column(name = "plan")
    private Integer plan;

    public Events() {
    }

    public Events(Integer id) {
        this.id = id;
    }

    public Events(Integer id, boolean opened) {
        this.id = id;
        this.opened = opened;
    }

    
    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateB() {
        return dateB;
    }

    public void setDateB(Date dateB) {
        this.dateB = dateB;
    }

    public Date getDateE() {
        return dateE;
    }

    public void setDateE(Date dateE) {
        this.dateE = dateE;
    }

    public boolean getOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public Lpu getLpuId() {
        return lpuId;
    }

    public void setLpuId(Lpu lpuId) {
        this.lpuId = lpuId;
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
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Events[ id=" + id + " ]";
    }

       
    

}
