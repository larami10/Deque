/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 *
 * @author Luis Ramirez-Zamacona, Professor Acuna
 * @version 06/03/2019
 */
import java.util.NoSuchElementException;
    
//TODO: implement.
public class Deque<Item> extends Node implements DequeInterface<Item> {
	
	//Instance Variables
	private Node<Item> head;	// Declare Object of Type Item
	private Node<Item> temp;	// Will be used as temporary pointer of head.
	private int n = 0;	// Keeps count of number of Elements in Deque
	
	/**
	 * Default Constructor Initializes head to null.
	 */
	public Deque()
	{
		head = null;
	}

	/**  
     * Adds one element to the front of this deque.
     *  
     * @param element the element to be added to the front of the deque  
     */
    public void enqueueFront(Item element)
    {
    	// Create Node with element
    	Node<Item> node = new Node<>(element);
    	
    	// Set temp to equal head
    	temp = head;
    	
    	// If head is null, set Node's previous pointer to null
    	// and set head to point to null
    	if(head == null)
    	{
    		node.setPrev(null);
    		head = node;
    	}
    	// Else set previous and next Pointers of temp
    	else
    	{
    		// Traverse temp to get to the front of Deque
	    	while(temp.getNext() != null)
	    	{
	    		temp = temp.getNext();
	    	}
	    	
	    	// set next Pointer of Object first to point to node
	    	temp.setNext(node);
	    	
	    	// set Node's previous Pointer to point to Object first 
	    	node.setPrev(temp);
    	}
    	
    	// Increment number of elements by one
    	n++;
    }
    
    /**  
     * Adds one element to the back of this deque.
     *  
     * @param element the element to be added to the back of the deque  
     */
    public void enqueueBack(Item element)
    {
    	// Create Node with element
    	Node<Item> node = new Node<>(element);
    	
    	// Node's next Pointer is set to point to head
    	node.setNext(head);
    	
    	// Node's Previous Pointer is set to point to null
    	node.setPrev(null);
    	
    	// If head does not equal null, set head's Previous
    	// Pointer to point to Node
    	if(head != null)
    	{
    		head.setPrev(node);
    	}
    	
    	head = node;
    	
    	// Increment number of elements in Deque by one.
    	n++;
    }

    /**  
     * Removes and returns the element at the front of this deque.
     * Throws an exception if the deque is empty.
     * 
     * @return the element at the front of this deque
     * @throws NoSuchElementException if the deque is empty
     */
    public Item dequeueFront() throws NoSuchElementException
    {
    	// Throw NoSuchElementException
    	if(isEmpty())
    		throw new NoSuchElementException();

    	// Set temp to equal head
    	temp = head;
    	
    	// element is set to equal the first element in Deque
    	Item element = first();

    	// Traverse temp Object to get last element in Deque
    	while(temp.getNext() != null)
    	{
    		temp = temp.getNext();
    	}
    	
    	// Remove the element at the front of Deque
    	temp.getPrev().setNext(null);
	    temp.setPrev(null);
    	
		// Decrement the number of elements in Deque by one.
    	n--;
    	
    	// Return the element at the front of Deque
    	return element;
    }
    
    /**  
     * Removes and returns the element at the back of this deque.
     * Throw an exception if the deque is empty.
     * 
     * @return the element at the back of the deque. 
     * @throws NoSuchElementException if the deque is empty
     */
    public Item dequeueBack() throws NoSuchElementException
    {
    	// Throws NoSuchElementException
    	if(isEmpty())
    		throw new NoSuchElementException();
    	
    	// Set temp to equal head
    	temp = head;
    	
    	// Element equals the last element of Deque
    	Item element = last();
    	
    	// Head equals the next Element
    	head = head.getNext();
    	
    	// Remove the last element in Deque
    	temp.setNext(null);
    	temp.setPrev(null);
    	
    	// Decrement the number of elements in Deque by one.
    	n--;
    	
    	// Return the last element in Deque
    	return element;
    }

    /**  
     * Returns, without removing, the element at the front of this deque.
     * Should throw an exception if the deque is empty.
     * 
     * @return the first element in the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public Item first() throws NoSuchElementException
    {
    	// Throws NoSuchElementException
    	if(isEmpty())
    		throw new NoSuchElementException();
    	
    	// Set temp to equal head
    	temp = head;
    	
    	// Traverse temp to get first element in Deque
    	while(temp.getNext() != null)
    	{
    		temp = temp.getNext();
    	}
    	
    	// Return first Element in Deque
    	return temp.getElement();
    }
    
    /**  
     * Returns, without removing, the element at the back of this deque.
     * Should throw an exception if the deque is empty.
     * 
     * @return the last element in the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public Item last() throws NoSuchElementException
    {
    	// Throws NoSuchElementException
    	if(isEmpty())
    		throw new NoSuchElementException();
    	
    	// Return last element in Deque
    	return head.getElement();
    }
   
    /**  
     * Returns true if this deque is empty and false otherwise.
     * 
     * @return if deque empty
     */
    public boolean isEmpty()
    {
    	return (head == null);
    }

    /**  
     * Returns the number of elements in this deque.
     *  
     * @return the number of elements in the deque
     */
    public int size()
    {
    	return n;
    }

    /**  
     * Returns a string representation of this deque. The back element
     * occurs first, and each element is separated by a space. If the
     * deque is empty, returns "empty".
     * 
     * @return the string representation of the deque
     */
    @Override
    public String toString()
    {
    	String s = "";	// String variable s
    	temp = head;	// Set temp to equal head
    	
    	// If empty, print "empty"
    	if(isEmpty())
    	{
    		s = "empty";
    	}
    	// Else print elements in deque
    	else
    	{
    		for(int i = 0; i < n; i++)
    		{
    			s += temp.getElement() + " ";
    			
    			temp = temp.getNext();
    		}
    	}
    	
    	// return s
    	return s;
    }
	
    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) {
    	Deque<Integer> deque = new Deque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());              
    }
} 