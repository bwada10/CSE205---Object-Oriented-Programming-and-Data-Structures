import java.lang.Object;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.io.*;
import java.text.*;

public class StudentParser
{
    public static Student parseStringToStudent(String lineToParse)  //Constructor
    {
        // Scanner scan = new Scanner(lineToParse);
        // String stud = scan.next();
        // System.out.println(stud);
        // return "";

        
        // ArrayList <OnlineStudent> arry1 = new ArrayList<OnlineStudent>();
        // arry1 = lineToParse.split("/");
        // for(String list : arry1)
        // {
        //     arry1[i]= 
        // }
        // OnlineStudent online= new OnlineStudent(arry1);
            //Make a code to check boolean resident == resident then convert to either "true" or "false" before the constructor is called upon.
        Student newStudent = null;      //Intialize Empty object
        String stud[] = new String[8];  //Create our String Array

        stud = lineToParse.split("/");  //ignores all "/"
        if(stud[0].equalsIgnoreCase("Online"))    //Creates new Online Student
        {
            newStudent= new OnlineStudent(stud[1], stud[2], stud[3], Integer.parseInt(stud[4]), Double.parseDouble(stud[5]), Double.parseDouble(stud[6]));
        }        

        if(stud[0].equalsIgnoreCase("OnCampus"))    //Creates new on Campus Student
        {
            if(stud[6].equalsIgnoreCase("resident"))     //My attempt on making boolean into string for OnCampusStudent
            {
                //String.parseString(stud[6]);
                //stud[6]="true";
                newStudent = new OnCampusStudent(stud[1], stud[2], stud[3], Integer.parseInt(stud[4]), Double.parseDouble(stud[5]), true, Double.parseDouble(stud[7]));
            }
            else
            {
                //String.parseString(stud[6]);
                //stud[6]="false";
                newStudent = new OnCampusStudent(stud[1], stud[2], stud[3], Integer.parseInt(stud[4]), Double.parseDouble(stud[5]), false, Double.parseDouble(stud[7]));
            }
            //newStudent = new OnCampusStudent(stud[1], stud[2], stud[3], Integer.parseInt(stud[4]), Double.parseDouble(stud[5]), true, Double.parseDouble(stud[7]));
           
        }

        return newStudent;    //returns all the variables required for a new Student

    }
}