package com.ps.sre.bugtracker.service.impl;

import com.ps.sre.bugtracker.config.DatabaseConfig;
import com.ps.sre.bugtracker.model.Bug;
import com.ps.sre.bugtracker.service.BugService;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BugServiceImpl implements BugService {

    private  static final Logger logger = Logger.getLogger(BugServiceImpl.class);
    private final Connection connection;

    public BugServiceImpl() {
        this.connection = DatabaseConfig.getConnection();
    }

    @Override
    public void reportBug(String title, String description) {

        String sql = "INSERT INTO bugs (title, description) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                logger.info("Bug with id: " + id + " reported successfully");
                System.out.println("Bug reported successfully!");
            }

        }catch (SQLException e){
            logger.error("Error while reporting bug", e);
        }

    }

    @Override
    public List<Bug> getAllBugs() {
        List<Bug> bugs = new ArrayList<>();
        String sql = "SELECT * FROM bugs";
        try(Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Bug bug = new Bug(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status")
                );
                bugs.add(bug);
                //logger.info("Retrieved bug: " + bug);
            }

        }catch (SQLException e){
            logger.error("Error while retrieving bugs", e);
        }

        return bugs;

    }

    @Override
    public boolean updateBugStatus(int id, String status) {
        return false;
    }

    @Override
    public void searchBugById(int id) {
//        System.out.println("Enter bug ID: ");
//        int bugId = scanner.nextInt();
//        scanner.nextLine();
//
//        for (Bug bug : bugs) {
//            if (bug.getId() == bugId) {
//                System.out.println(bug);
//                return;
//            }
//        }
//
//        System.out.println("Bug with ID " + bugId + " not found.");
    }
}
