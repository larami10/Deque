/**
 * Node class of Generic Type Item defines the methods that a Node
 * uses to connect to other Nodes or to the ends of the Deque.
 * 
 * @author Luis Ramirez-Zamacona, Professor Acuna
 * @version 06/03/2019
 */
public class Node<Item>
{
	// Declare private variables of a Node
	private Node<Item> next;	// Next Pointer
	private Node<Item> prev;	// Previous Pointer
	private Item element;		// Element in the Node
	
	/**
	 * Node Default Constructor sets variables to null
	 */
	public Node()
	{
		next = null;
		prev = null;
		element = null;
	}

	/**
	 * Node is given an element and sets next to null.
	 * 
	 * @param element element is initialized in null
	 */
	public Node(Item element)
	{
		next = null;
		this.element = element;
	}
	
	/**
	 * Return value of next pointer
	 * 
	 * @return next
	 */
	public Node<Item> getNext()
	{
		return next;
	}
	
	/**
	 * Set next to point to Node.
	 * 
	 * @param node Generic Type Node object
	 */
	public void setNext(Node<Item> node)
	{
		next = node;
	}
	
	/**
	 * Return value of previous pointer
	 * 
	 * @return prev
	 */
	public Node<Item> getPrev()
	{
		return prev;
	}
	
	/**
	 * Set prev to point to Node.
	 * 
	 * @param node Generic Type Node object
	 */
	public void setPrev(Node<Item> node)
	{
		prev = node;
	}
	
	/**
	 * Return element in Node.
	 * 
	 * @return element
	 */
	public Item getElement()
	{
		return element;
	}
	
	/**
	 * Set element in Node.
	 * 
	 * @param element Generic Type element
	 */
	public void setElement(Item element)
	{
		this.element = element;
	}
}