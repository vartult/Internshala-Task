package com.example.vartu.internshala;

public class workshop {
    private int id;
    private String workshop;
    private String description;

    public workshop() {
    }

    public workshop(int id, String workshop, String description) {
        this.id = id;
        this.workshop = workshop;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
