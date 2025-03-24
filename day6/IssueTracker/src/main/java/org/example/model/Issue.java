package org.example.model;

public class Issue {
    //Properties
    private String id;
    private String description;
    private String status;
    private String severity;

    //Static variable - shared by all Issue objects
    private static int issueCount = 0;

    //Static Constant
    public static final String DEFAULT_STATUS = "New";

    //lets create a default constructo
//    public Issue() {
//        status = "New";
//        severity = "Low";
//    }

    public Issue(String id, String description){
        this.id = id;
        this.description = description;
        this.status = DEFAULT_STATUS;
        this.severity = "Medium";

        //lets increment the issue count
        issueCount++;
    }

    //lets write a method to get the issue count
    public static int getIssueCount(){
        return issueCount;
    }

    //Adding a static utility method
    public static boolean isValidStatus(String status){
        return (status.equals("New") || status.equals("Open")
        || status.equals("In Progress") || status.equals("Resolved")
                || status.equals("Closed"));

    }

    //fully parameterized constructor
//    public Issue(String id, String description, String status, String severity) {
//        this.id = id;
//        this.description = description;
//        this.status = status;
//        this.severity = severity;
//        //lets increment the issue count
//        issueCount++;
//    }

   public String getId() {
       return id;
   }
    public void setId(String newId) {
       //we can add validation here
        if (newId != null && !newId.isEmpty()) {

            this.id = newId;
        }else {
            System.out.println("Error: Issue ID cannot be null or empty");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    //Method to display issue details
    public void displayIssueDetails() {
        System.out.println("Issue ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("Severity: " + severity);
    }
}
