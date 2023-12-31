package es.ufv.dis.extraordinaria.practica;

import com.fasterxml.jackson.annotation.JsonProperty;

public class People {
    @JsonProperty
    private String name;
    @JsonProperty
    private String height;
    @JsonProperty
    private String mass;

    public People(String name, String height, String mass) {
        this.name = name;
        this.height = height;
        this.mass = mass;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                '}';
    }
}
