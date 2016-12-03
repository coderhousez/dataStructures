package z.house.coder.ds;

import z.house.coder.datastructures.Queue;
import z.house.coder.datastructures.Stack;
import z.house.coder.datastructures.algorithm.ArrayQueue;
import z.house.coder.datastructures.algorithm.ArrayStack;
import z.house.coder.datastructures.algorithm.LinkedList;
import z.house.coder.datastructures.data.Node;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DataStructuresTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DataStructuresTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DataStructuresTest.class );
    }
    
    public void testArrayStack() {
    	Stack<String> s = new ArrayStack<>();
    	assertEquals(s.count(), 0);
    	s.push("a");
    	assertEquals(s.count(), 1);
    	s.push("b");
    	assertEquals(s.pop(), "b");
    	assertEquals(s.count(), 1);
    	
    }
    
    public void testArrayQueue() {
    	Queue<String> q = new ArrayQueue<>();
    	assertEquals(q.count(), 0);
    	q.enqueue("a");
    	assertEquals(q.count(), 1);
    	String s = q.dequeue();
    	assertEquals(s, "a");
    	q.enqueue("b");
    	q.enqueue("c");
    	q.enqueue("d");
    	s = q.dequeue();
    	assertEquals("d", s);
    }

    public void testNode()
    {
    	Node<String> node = new Node<>("Test");  	
        assertTrue("Test".equals(node.getElement()));
        node.setNode(new Node<String>("Test2"));
        assertTrue("Test2".equals(node.getNode().getElement()));
    }
    
    public void testLinkedList() {
    	LinkedList<String> ll = new LinkedList<String>("jz");
    	ll.append("az");
    	ll.append("bz");
    	ll.prepend("cc");
    	String head = ll.head();
    	assertEquals("cc", head);
    	String s = ll.remove();
    	assertEquals("cc", s);
    }
    
}
