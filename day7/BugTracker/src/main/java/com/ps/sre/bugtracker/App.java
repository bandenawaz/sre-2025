package com.ps.sre.bugtracker;

import com.ps.sre.bugtracker.model.Bug;
import com.ps.sre.bugtracker.util.Cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        //System.out.println( "Welcome to Bug Tracker App" );

        Cli cli = new Cli();
        cli.start();

    }


}
