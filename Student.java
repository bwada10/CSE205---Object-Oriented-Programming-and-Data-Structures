import java.text.*;
import java.io.*;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Locale;

public abstract class Student
{
    protected String firstName;
    protected String lastName;
    protected String studentID;
    protected int creditNum;
    protected double rate;
    protected double tuition =0.0;    //initializing protected attributes

    public Student(String fName, String lName, String id, int credits, double rate) //Contructor
    {
        this.firstName = fName;
        this.lastName = lName;
        this.studentID = id;
        this.creditNum = credits;
        this.rate = rate;
    }

    public int getCreditNum()   //Accessor Method
    {
        return creditNum;
    }

    public abstract void computeTuition();

    public String toString()
    {
        //NumberFormat num = new DecimalFormat ("#0.00");
        //NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        //DecimalFormat myFormat = new DecimalFormat("$#,###.00");
        NumberFormat myFormat = new DecimalFormat ("$#,##0.00");
        String output = ("\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + creditNum + "\nRate:\t\t\t" + myFormat.format(rate) + "\nTuition:\t\t" + myFormat.format(tuition) + "\n");
        return output;
    }
    
}