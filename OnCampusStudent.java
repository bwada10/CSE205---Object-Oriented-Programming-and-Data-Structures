import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.*;
import java.util.Locale;

public class OnCampusStudent extends Student
{
    private boolean resident;
    private int creditUpperBound;
    private double studentProgramFee;   //initialize private variables

    public OnCampusStudent(String fName, String lName, String id, int credits, double rate, boolean resident, double programFee)    //Constructor
    {
        super(fName, lName, id, credits, rate);   //Sub Class calls for Super Class
        this.resident = resident;
        // if(this.resident.equalsIgnoreCase("resident"))//idk if this even works because 
        // {
        //     resident = true;
        // }
        // else
        // {
        //     resident = false;
        // }
        this.creditUpperBound = 0;
        this.studentProgramFee = programFee;

    }



    public void computeTuition()        //Calculates Tuition costs depending on creditNum and creditUpperBound
    {
        if(resident == true)         //Sets creditUpperBound depending wheter student is resident or non-resident
        {
            this.creditUpperBound = 7;
        }
        else
        {
            this.creditUpperBound = 12;
        }

            if(this.creditNum >= this.creditUpperBound)
            {
                tuition = rate * creditUpperBound + studentProgramFee;
            }
            else
            {
                tuition = rate * creditNum + studentProgramFee;
            }
    }

    public String toString()
    {
        NumberFormat myFormat = new DecimalFormat ("$#,##0.00");
        //NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        //DecimalFormat myFormat = new DecimalFormat("$#,###.00");
        //if(this.creditUpperBound==7)
        if(resident==true)
        {
            String residentOutput = ("\nOnCampus Student:"+"\nResident Status\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID+ "\nCredits:\t\t" + creditNum + "\nRate:\t\t\t" + myFormat.format(rate) + "\nTuition:\t\t" + myFormat.format(tuition) + "\nStudent Program Fee:\t" + myFormat.format(studentProgramFee) + "\n\n");
            return residentOutput;
        }
        else
        {
            String nonResidentOutput = ("\nOnCampus Student:"+"\nNonResident Status\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID+ "\nCredits:\t\t" + creditNum + "\nRate:\t\t\t" + myFormat.format(rate) + "\nTuition:\t\t" + myFormat.format(tuition) + "\nStudent Program Fee:\t" + myFormat.format(studentProgramFee) + "\n\n");
            return nonResidentOutput;
        }

    }
}