package org.example.service;

public class IssueValidator {

    public boolean validateIssue(
            String id, String description){
        boolean isValid = true;
        String errorMessage = "";

        if(id == null || id.isEmpty()){
            isValid = false;
            errorMessage =   "Id cannot be null or empty";
        }
        System.out.println(errorMessage);
        return isValid;
    }
}
