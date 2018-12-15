package com.example.vartu.internshala;

public class taken {
    String user;
    String Workshop;

    public taken() {
    }

    public String getUser() {

        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getWorkshop() {
        return Workshop;
    }

    public void setWorkshop(String workshop) {
        Workshop = workshop;
    }

    public taken(String user, String workshop) {
        this.user = user;
        Workshop = workshop;
    }

}
