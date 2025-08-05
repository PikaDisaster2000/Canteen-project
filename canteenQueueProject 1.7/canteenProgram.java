import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * The main program.
 *
 * Joseph
 * Version 1.7
 */
public class canteenProgram {
    Scanner kb = new Scanner(System.in);
    /**
     * Constructor for objects of class canteenProgram
     */
    public canteenProgram()
    {
        System.out.println("Welcome to the WHS canteen queue simulation. To get started, type Y.");
        System.out.println("Please note: If the program does not operate, please check that the CSV files have the right numbers to write a successful simulation.");
        System.out.println("Please also note that the file has to be a CSV file.");
        String choice = kb.nextLine().toUpperCase();
        switch (choice) {
            case "Y" :   runProgram();
                break;
            case "N" : System.out.println("Closing program..");
                       System.exit(0);
                break;
            default: System.out.println("Invalid input. The program has been closed. Please try again.");
        }
    }
    
    /**
     * 
     */
    public void runProgram() 
    {
        File myFile = new File("arrivals.csv");
        Queue studentsQueue = new Queue();
        Queue teachersQueue = new Queue();
        int joinTime;
        int waitTime;
        float totalStudentWaitTime = 0;
        float totalStudentsSeen = 0;
        float totalTeacherWaitTime =0;
        float totalTeachersSeen = 0;
        int studentsLeftOut = 0;
        int teachersLeftOut = 0;
        float studentsAverageTime = 0;
        float teachersAverageTime = 0;
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
                      joinTime = teachersQueue.dequeue();
                      waitTime = time - joinTime;
                      totalTeacherWaitTime += waitTime;
                      totalTeachersSeen += 1.0;
                    } else if (!studentsQueue.queueEmpty()) {
                      joinTime = studentsQueue.dequeue();
                      waitTime = time - joinTime; 
                      totalStudentWaitTime += waitTime;
                      totalStudentsSeen+= 1.0;
                    } else {
                        System.out.println("No one was served.");
                    }
                   }
                 try
                {
                    System.out.println(teachers +" Teachers joined the queue, " + students + " Students joined the queue, and " + served + " people (teachers and students) were served." + " (current time: " + time + ".)");
                    System.out.println("-----------------");
                    Thread.sleep(500);
                }
                catch (InterruptedException ie)
                {
                   System.out.println("ERROR: Something went wrong from our end. Please restart the simulation.");
                }
            }
            System.out.println("Simulation completed.");
            System.out.println("==========================================================================================================================================================");
            studentsAverageTime = totalStudentWaitTime/totalStudentsSeen;  
            teachersAverageTime = totalTeacherWaitTime/totalTeachersSeen; 
            while(!studentsQueue.queueEmpty()) {
                studentsQueue.dequeue();
                studentsLeftOut++;
            }
            while(!teachersQueue.queueEmpty()) {
                teachersQueue.dequeue();
                teachersLeftOut++;
            }
            try
                {
                    System.out.println("Teacher Calculations:");
                    System.out.println("------------------------");
                    Thread.sleep(1000);
                    System.out.println("Total teachers that missed out: " + teachersLeftOut); 
                    Thread.sleep(1000);
                    System.out.println("Total teachers seen: (excludes teachers that missed out) " + totalTeachersSeen);
                    Thread.sleep(1000);
                    System.out.println("Total teacher wait time (accumulated based on preset values from the CSV file.)  " + totalTeacherWaitTime);
                    Thread.sleep(1000);
                    System.out.println("Teachers average: " + teachersAverageTime);
                    System.out.println("================================================================================================================");
                    System.out.println("Student Calculations:");
                     System.out.println("------------------------");
                    Thread.sleep(1000);
                    System.out.println("Total students that missed out: " + studentsLeftOut); 
                    Thread.sleep(1000);
                    System.out.println("Total students seen: (excludes students that missed out) " + totalStudentsSeen);
                    Thread.sleep(1000);
                    System.out.println("Total student wait time (accumulated based on preset values from the CSV file.)  " + totalStudentWaitTime);
                    Thread.sleep(1000);
                    System.out.println("students average: " + studentsAverageTime);
                    System.out.println("----------------------------------------");
                    Thread.sleep(1000);
                    System.out.println("Statistics Complete. To ensure accuracy, use the following stats to confirm that the average of the queue (total wait time divided by sum of people seen). Goodbye! =)");
                }
                catch (InterruptedException ie)
                {
                   System.out.println("ERROR: Something went wrong from our end. Please restart the simulation.");
                }
        } catch(IOException e) {
            System.out.println("ERROR RUNNING PROGRAM. PLEASE TRY AGAIN.");
        }
    }
    
    
}
