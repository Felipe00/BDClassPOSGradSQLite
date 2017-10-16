package br.com.mainpc.bdclassposgradsqlite.models;

import java.io.Serializable;

/**
 * Created by javab0y on 16/09/17.
 */

public class User implements Serializable {

    private Integer id;
    private String name;
    private Double height;

    public User(String name, Double height) {
        this.name = name;
        this.height = height;
    }

    public User(int id, String name, Double height) {
        this.id = id;
        this.name = name;
        this.height = height;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

}
