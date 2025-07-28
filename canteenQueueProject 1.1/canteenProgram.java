import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * The main program.
 *
 * Joseph
 * Version 1.1
 */
public class canteenProgram
{
    /**
     * Constructor for objects of class canteenProgram
     */
    public canteenProgram()
    {
        runProgram();
    }
    
    /**
     * 
     */
    public void runProgram() 
    {
        File myFile = new File("arrivals.csv");
        Queue studentsQueue = new Queue();
        Queue teachersQueue = new Queue();
        try {
            Scanner myReader = new Scanner(myFile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String[] parts = myReader.nextLine().split(",");
                if (parts.length != 4){
                   System.out.println("Error reading file. There are more or less fields than expected. Please try again.");
                   System.exit(0);
                }
                int time = Integer.parseInt(parts[0]);
                int students = Integer.parseInt(parts[1]);
                // create parts[1] new nodes with a time of time and a type of student, then add them to the student queue
                for (int i = 0; i < students; i++) {
                    Node studentNodes = new Node("Student",time);
                    studentsQueue.enqueue(studentNodes);
                }
                int teachers = Integer.parseInt(parts[2]);
                // as above for teachers
                for(int i = 0; i < teachers; i++) {
                Node teacherNodes = new Node("Teacher",time);
                teachersQueue.enqueue(teacherNodes);
                }
                int served = Integer.parseInt(parts[3]);
                // dequeue parts[3] items from the teacher queue. If there are still more nodes to dequeue remove them from students
                for(int i= 0; i < served; i++) {
                    if(!teachersQueue.queueEmpty()) { 
                        System.out.println("Teacher Jointime: " + teachersQueue.dequeue());
                    } else {
                        
                        System.out.println("Student Jointime: " + studentsQueue.dequeue());
                    }
                }
            }
        } catch(IOException e) {
            System.out.println("ERROR RUNNING PROGRAM. PLEASE TRY AGAIN.");
        }
    }
    
    
}
