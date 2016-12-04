package z.house.coder.ds;

import z.house.coder.datastructures.Queue;
import z.house.coder.datastructures.Stack;
import z.house.coder.datastructures.algorithm.ArrayQueue;
import z.house.coder.datastructures.algorithm.ArrayStack;
import z.house.coder.datastructures.algorithm.LinkedList;
import z.house.coder.datastructures.data.Node;
import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;
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
    
    public void testArrayStack() throws Full, Empty{
    	Stack<String> s = new ArrayStack<>();
    	assertEquals(s.count(), 0);
    	s.push("a");
    	assertEquals(s.count(), 1);
    	s.push("b");
    	assertEquals(s.pop(), "b");
    	assertEquals(s.count(), 1);
    	
    }
    
    public void testArrayQueue() throws Full, Empty{
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
    
    public void testLinkedList() throws Empty {
    	boolean empty = false;
    	LinkedList<String> ll = new LinkedList<>("jz");
    	ll.removeFirst();
    	try {
    		ll.removeFirst();
    	} catch(Empty e) {
    		empty = true;
    	} finally {
    		assertTrue(empty);
    	}
    	empty = false;
    	try {
    		ll.removeFirst();
    	} catch(Empty e) {
    		empty = true;
    	} finally {
    		assertTrue(empty);
    	}
    	ll.insertLast("az");
    	ll.insertLast("bz");
    	ll.insertFirst("cc");
    	String first = ll.first();
    	assertEquals("cc", first);
    	String s = ll.removeFirst();
    	assertEquals("cc", s);
    }
    
}
