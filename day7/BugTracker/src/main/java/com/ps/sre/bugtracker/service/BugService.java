package com.ps.sre.bugtracker.service;

import com.ps.sre.bugtracker.model.Bug;

import java.util.List;
import java.util.Scanner;

public interface BugService {
    void reportBug(String title, String description);
    List<Bug> getAllBugs();
    void searchBugById(int id);
    public boolean updateBugStatus(int id, String status);
}
