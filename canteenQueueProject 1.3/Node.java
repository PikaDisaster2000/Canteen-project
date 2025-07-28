
/**
 * The class that sets attributes to for a Node.
 *
 * Joseph T
 * Version 1.3
 */
public class Node
{
    // instance variables
    private int joinTime; //the time the student or teacher joined
    private String type; //the type of person (teacher or student)
    private Node nextNode;
    
    //constructor for nodes with no data
    public Node(int joinTime)
    {
        this.type = "";
        this.joinTime = joinTime;
    }
    //constructor for nodes with data
    public Node(String type, int joinTime) {
        this.type = type;
        this.joinTime = joinTime;
    }
    
    // setters
    public void setType(String type) {
        this.type = type;
    }
    public void setJoinTime(int joinTime) {
        this.type = type;
    }
    public void setNextNode(Node node) {
        this.nextNode = node;
    }    
    //getters 
    public String getType() {
        return(this.type);
    }
    public int getJoinTime() {
        return(this.joinTime);
    }
    public Node getNextNode() {
        return(this.nextNode);
    }
}
