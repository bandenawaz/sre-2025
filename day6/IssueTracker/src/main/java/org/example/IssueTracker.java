package org.example;

import org.example.model.Issue;

import java.util.Scanner;

public class IssueTracker {
    public static void main(String[] args) {
        System.out.println("Web Application Issue Tracker");
        System.out.println("Version 1.0");

//        System.out.println("Default status for new issue is : " + Issue.DEFAULT_STATUS);
//
//        Issue serverIssue = new Issue("IS-123", "Server is down");
//
//        Issue networkIssue = new Issue("IS-456", "Network is down");
//        Issue databaseIssue = new Issue("IS-789", "Database is down");
//        Issue securityIssue = new Issue("IS-101", "Security issue");
//
//        //Using static method to get the issue count
//        System.out.println("Total number of issues: " + Issue.getIssueCount());
//
//        //Using the static utility method
//        System.out.println("Enter the Status of the issue");
//        Scanner scanner = new Scanner(System.in);
//        String status = scanner.nextLine();
//        if (Issue.isValidStatus(status)){
//            System.out.println(status + " is a valid status");
//        }else {
//            System.out.println(status + " is not a valid status");
//        }
//        //Using getter methods
//        System.out.println("Server Issue Tracker");
//        serverIssue.displayIssueDetails();
//
//        System.out.println("\nNetwork Issue Tracker");
//        networkIssue.displayIssueDetails();
//
//        System.out.println("\nDatabase Issue Tracker");
//        databaseIssue.displayIssueDetails();
//
//        System.out.println("\nSecurity Issue Tracker");
//        securityIssue.displayIssueDetails();

        //Create an ssue object and store it refernce to the issue variable
        Issue serverIssue = new Issue("IS-101", "Server crash");

        //lets print the details of server issue
        System.out.println("Server Issue:");
        serverIssue.displayIssueDetails();

        //lets update the status of server issue
        markAsResolved(serverIssue);
    }
    //Method that takes an Issue refeence and modifies the object
    public static void markAsResolved(Issue issue){
        issue.setStatus("Resolved");
    }
}