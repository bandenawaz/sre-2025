package com.example.sre;

public class Main {

    public static void main(String[] args) {
        //Lets welcome people
        System.out.println("Welcome to Java SRE Debugging");
        //lets create the ticket object
        Ticket ticket = new Ticket();
        ticket.ticketId = 101;
        ticket.issue = "Memory Leak";
        ticket.status = "Open";

        Ticket ticket2 = new Ticket();
        ticket2.ticketId = 102;
        ticket2.issue = "server error";
        ticket2.status = "In Progress";

        //lets display the details
        ticket.showDetails();
        ticket2.showDetails();
    }
}
