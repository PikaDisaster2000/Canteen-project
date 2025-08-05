
/**
 * The class that sets the attributes for a Queue object. 
 *
 * Joseph T
 * Version 1.6
 */
public class Queue
{
    // instance variables - replace the example below with your own
    private Node head = null;
    private Node tail = null;
    /**
     * Constructor for objects of class Queue
     */
    public Queue()
    {
       
    }
    
    public void enqueue(Node node) {
        if (queueEmpty()) {
        this.head = node;
        this.tail = node;
        } else {
         this.tail.setNextNode(node);
         this.tail = node;
        }
    }
    
    public int dequeue() {
     Node tempNode = this.head; 
       if (this.head == this.tail) {
        this.head = null;
        this.tail = null;
     }
       else {
        this.head = tempNode.getNextNode();
     }
     return(tempNode.getJoinTime());
    }
    
    public boolean queueEmpty() {
        if (head == null && tail == null) {
            return(true);
        } else {
            return(false);
        }
    }
}