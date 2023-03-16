public class Instructor
{
    private String firstName = "?";     //Class Attributes
    private String lastName = "?";
    private String officeNum = "?";

    public Instructor(String first, String last, String office)
    {
        firstName = first;  //Initialize variables
        lastName = last;
        officeNum = office;
    }    
        
        public String getFirstName()    //Accessor Method
            {
                return firstName;
            }

            public String getLastName() //Accessor Method
            {
                return lastName;
            }

            public String getOfficeNum()    //Accessor Method
            {
                return officeNum;
            }

            public void setFirstName(String someFirstName)  //Mutator Method
            {
                this.firstName = someFirstName;
            }

            public void setLastName(String someLastName)    //Mutator Method
            {
                this.lastName = someLastName;
            }

            public void setOfficeNum(String someOffice)     //Mutator Method
            {
                this.officeNum = someOffice;
            }

            public String toString()       //ToString Method  
            {
                return ("\nLast Name:\t" + lastName +
                "\nFirst Name:\t" + firstName +
                "\nOffice Number:\t" + officeNum + "\n");
                
            }
    
}