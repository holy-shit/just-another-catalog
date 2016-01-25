package com.olegchir.jac.entities;

import javax.persistence.*;

/**
 * Created by olegchir on 25/01/16.
 */

@Entity
public class Simple {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Basic
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
