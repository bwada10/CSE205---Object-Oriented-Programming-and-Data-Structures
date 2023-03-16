import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.*;
import java.util.Locale;

public class OnlineStudent extends Student
{
    private double computingFee; //intialize instance variables

    public OnlineStudent(String fName, String lName, String id, int credits, double rate, double compFee)   //constructor
    {
        super(fName, lName, id, credits, rate); //SubClass calls for Super Class
        this.computingFee = compFee;
    }

    public void computeTuition()    //Mutator Method
    {
        tuition = (rate + computingFee) * creditNum;    //Calculates total tuition costs
    }

    public String toString()
    {
        //NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        //DecimalFormat myFormat = new DecimalFormat("$#,###.00");
        NumberFormat myFormat = new DecimalFormat ("$#,##0.00");
        String output1 = ("\nOnline Student:"+"\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + creditNum + "\nRate:\t\t\t" + myFormat.format(rate) + "\nTuition:\t\t" + myFormat.format(tuition) + "\nComputing Fee:\t\t" + myFormat.format(computingFee) + "\n\n");
        return output1;
    }
}