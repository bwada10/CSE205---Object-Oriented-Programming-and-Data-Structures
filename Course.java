public class Course
{
    private String courseName = "?";    //Class Attributes
    private Instructor instructor;
    private String university = "?";

    public Course(String name, Instructor instr, String univer)
    {
        courseName = name;      //Initialize variables
        instructor = instr;     
        university = univer;
    }
        public String getName()     //Accessor Method
        {
            return courseName;
        }

        public Instructor getInstructor()   //Accessor Method
        {
            return instructor;
        }

        public String getUniversity()   //Accessor Method
        {
            return university;
        }

        public void setName(String someName)        //Mutator Method
        {
            courseName = someName;
        }

        public void setUniversity(String someUniversity)    //Mutator Method
        {
            university = someUniversity;
        }

        public void setInstructor(String firstName, String lastName, String office)     //Mutator Method
        {
            Instructor instr = new Instructor(firstName, lastName, office);
        }

        public String toString()    //ToString Method
        {
            return ("Course name:\t" + courseName + " at " + university + "\nInstructor Information:" + instructor);
        }
}