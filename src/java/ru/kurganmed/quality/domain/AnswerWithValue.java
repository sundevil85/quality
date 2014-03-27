/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.kurganmed.quality.domain;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Zhuk
 */
@Entity
@DiscriminatorValue("B")
public class AnswerWithValue extends Answer implements Serializable {

    public AnswerWithValue() {
    }    
    
}
