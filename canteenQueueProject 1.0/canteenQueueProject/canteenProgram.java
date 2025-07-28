import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Write a description of class canteenProgram here.
 *
 * Joseph
 * Version 1.0
 */
public class canteenProgram
{
    /**
     * Constructor for objects of class canteenProgram
     */
    public canteenProgram()
    {
        loadData();
        Queue studentsQueue = new Queue();
        Queue teachersQueue = new Queue();
        //Node a = new Node(1);
        ///students.enqueue(a);
        ///Node b = new Node(2);
        ///students.enqueue(b);
        //System.out.println(students.queueEmpty());
        //System.out.println(students.dequeue());
        //System.out.println(students.queueEmpty());
        //System.out.println(students.dequeue());
        //System.out.println(students.queueEmpty());
    }
    
    /**
     * 
     */
    public void loadData() 
    {
        File myFile = new File("arrivals.csv");
        try {
            Scanner myReader = new Scanner(myFile);
            myReader.nextLine();
                while (myReader.hasNextLine()) {
                String[] parts = myReader.nextLine().split(",");
                int time = Integer.parseInt(parts[0]);
                int students = Integer.parseInt(parts[1]);
                // create parts[1] new nodes with a time of time and a type of student, then add them to the student queue
                for (int i = 0; i < students; i++) {
                    Node studentNodes = new Node("Student",time);
                    studentsQueue.enqueue(studentNodes);
                }
                int teachers = Integer.parseInt(parts[2]);
                // as above for teachers
                int served = Integer.parseInt(parts[3]);
                // dequeue parts[3] items from the teacher queue. If there are still more nodes to dequeue remove them from students
                if (parts.length != 4){
                    System.out.println("Error reading file. There are more or less fields than expected. Please try again.");
                }
                System.out.println(time);
                System.out.println(students);
                System.out.println(teachers);
                System.out.println(served);
            }
        } catch(IOException e) {
            System.out.println("ERROR. PLEASE TRY AGAIN.");
        }
    }
    
    
}
