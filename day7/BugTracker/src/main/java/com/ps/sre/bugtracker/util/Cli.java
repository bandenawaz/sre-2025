package com.ps.sre.bugtracker.util;

import com.ps.sre.bugtracker.model.Bug;
import com.ps.sre.bugtracker.service.BugService;
import com.ps.sre.bugtracker.service.impl.BugServiceImpl;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Cli {
    private final BugServiceImpl bugServiceImpl;
    private final Scanner scanner;

    private static final Logger logger = Logger.getLogger(Cli.class.getName());

    public Cli(){
        this.bugServiceImpl = new BugServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    //lets start the execution of our app
    public void start(){
        boolean exit = false;

        while (!exit) {
            System.out.println("\n*=*=**== Bug Tracker System ==***=*=*\n");

            System.out.println("1. Report a bug");
            System.out.println("2. View All Bugs");
            System.out.println("3. Search a Bug by ID");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice){
                case 1:
                    System.out.println("Enter bug title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter bug description: ");
                    String description = scanner.nextLine();

                    bugServiceImpl.reportBug( title, description);
                    //System.out.println("Bug reported Successfully");
                    break;
                case 2:
                    List<Bug> bugs = bugServiceImpl.getAllBugs();
                    if(bugs.isEmpty()){
                        logger.info("No bugs found");

                    }else {
                        System.out.println("\n ==*==* List of Reported Bugs ==*==*\n");
                        for (Bug bug : bugs) {
                            System.out.println(bug);
                        }
                    }

                    break;

                case 3:
                    //bugServiceImpl.searchBugById(scanner);
                    break;

                case 4:
                    System.out.println("Exiting Bug Tracker System");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
