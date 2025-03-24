package com.example.sre;

public class Ticket {
    //Properties(State)
    int ticketId;
    String issue;
    String status;

    //Methods(Behavior)
    void showDetails(){
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Issue: " + issue);
        System.out.println("Status: " + status);
    }
}
