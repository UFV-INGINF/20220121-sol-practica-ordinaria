package es.ufv.dis.extraordinaria.practica;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Params {
    @JsonProperty
    private String entity;
    @JsonProperty
    private int id;


    public Params() {
    }

    public Params(String entity, int id) {
        this.entity = entity;
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Params{" +
                "entity='" + entity + '\'' +
                ", id=" + id +
                '}';
    }
}
