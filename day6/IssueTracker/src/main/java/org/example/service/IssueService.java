package org.example.service;

import org.example.model.Issue;

public class IssueService {

    //Class-level variable (instance variable)
    private String serviceName;

    //Static class-level variable
    private static boolean serviceActive = true;

    //Constructor
    public IssueService(String serviceName) {
        this.serviceName = serviceName;
    }

    //lets write a method to process the issue
    public void processIssue(Issue issue) {

        //Method level variable (local variable)
        String issueId = issue.getId();

        //This variable is only accessible within the method
        System.out.println("Processing issue with ID: " + issueId);

        //Block scope example
        if(issue.getSeverity().equals("High Priority")
             || issue.getStatus().equals("Critical")) {
            //This variable only exists within this if block
            String alertMessage = "High priority issue with ID: " + issueId + " detected";
            System.out.println(alertMessage);

            //we can access the method level variables here
            System.out.println("Issue ID: " + issueId);
        }
        //alertMessage is not accessible here(out of scope)

        //Loop scope example
        for(int i = 0; i < 3; i++) {
            System.out.println("Processing Step: "+ i+ " for issue with ID: " + issueId);
        }

    }
    //lets write a method to display service information
    public void displayServiceInfo() {
        System.out.println("Service Name: " + serviceName);
        System.out.println("Service Active: " + serviceActive);

        //local variable
        int localVar = 10;
        System.out.println("Local Variable: " + localVar);
    }
}
