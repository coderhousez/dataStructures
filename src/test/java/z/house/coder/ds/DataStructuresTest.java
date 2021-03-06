package z.house.coder.ds;

import z.house.coder.datastructures.Position;
import z.house.coder.datastructures.PositionalSequence;
import z.house.coder.datastructures.Queue;
import z.house.coder.datastructures.RankedSequence;
import z.house.coder.datastructures.Stack;
import z.house.coder.datastructures.algorithm.ArrayQueue;
import z.house.coder.datastructures.algorithm.ArrayStack;
import z.house.coder.datastructures.algorithm.LinkedQueue;
import z.house.coder.datastructures.algorithm.LinkedStack;
import z.house.coder.datastructures.algorithm.NodePositionalSequence;
import z.house.coder.datastructures.algorithm.NodeRankedSequence;
import z.house.coder.datastructures.algorithm.extra.DoublyLinkedList;
import z.house.coder.datastructures.algorithm.extra.LinkedList;
import z.house.coder.datastructures.data.Node;
import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;
import z.house.coder.datastructures.exceptions.InvalidPositionException;
import z.house.coder.datastructures.exceptions.InvalidRankException;
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
    	Queue<String> q = new ArrayQueue<>(4);
    	assertEquals(q.count(), 0);
    	q.enqueue("a");
    	assertEquals(q.count(), 1);
    	String s = q.dequeue();
    	assertEquals(s, "a");
    	q.enqueue("b");
    	q.enqueue("c");
    	q.enqueue("d");
    	q.enqueue("e");
    	boolean error = false;
    	try{
    		q.enqueue("f");
    	} catch(Full f) {
    		error = true;
    	} finally {
    		assertTrue(error);
    	}
    	s = q.dequeue();
    	assertEquals("b", s);
    }

    public void testNode()
    {
    	Node<String> node = new Node<>("Test");  	
        assertTrue("Test".equals(node.getElement()));
        node.setNode(new Node<String>("Test2"));
        assertTrue("Test2".equals(node.getNode().getElement()));
    }
    
    public void testLinkedList() throws Empty , Full {
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
    		ll.removeLast();
    	} catch(Empty e) {
    		empty = true;
    	} finally {
    		assertTrue(empty);
    	}
    	ll.insertLast("az");
    	ll.insertLast("bz");
    	ll.insertLast("gz");
    	ll.insertFirst("cc");
    	String first = ll.first();
    	assertEquals("cc", first);
    	String s = ll.removeFirst();
    	assertEquals("cc", s);
    	s = ll.removeLast();
    	assertEquals("gz", s);
    }
    
    public void testLinkedStack() throws Empty, Full{
    	Stack<String> s = new LinkedStack<>();
    	assertEquals(s.count(), 0);
    	s.push("a");
    	assertEquals(s.count(), 1);
    	s.push("b");
    	assertEquals(s.pop(), "b");
    	assertEquals(s.count(), 1);
    	
    }
    
    public void testLinkedQueue() throws Full, Empty{
    	Queue<String> q = new LinkedQueue<>();
    	assertEquals(q.count(), 0);
    	q.enqueue("a");
    	assertEquals(q.count(), 1);
    	String s = q.dequeue();
    	assertEquals(s, "a");
    	q.enqueue("b");
    	q.enqueue("c");
    	q.enqueue("d");
    	q.enqueue("e");
    	q.enqueue("f");
    	s = q.dequeue();
    	assertEquals("b", s);
    	s = q.dequeue();
    	assertEquals("c", s);
    	s = q.dequeue();
    	assertEquals("d", s);
    	s = q.dequeue();
    	assertEquals("e", s);
    	s = q.dequeue();
    	assertEquals("f", s);
    	
    }
    
    public void testDoublyLinkedList() throws Full, Empty, InvalidRankException {
    	DoublyLinkedList<String> dll = new DoublyLinkedList<>();
    	dll.insertFirst("a");
    	dll.insertFirst("b");
    	assertEquals("a", dll.last());
    	assertEquals("b", dll.first());
    	dll.insertLast("y");
    	dll.insertLast("z");
    	assertEquals("z", dll.last());
    	// b , a , y , z
    	// remove elements
    	assertEquals(4, dll.size());
    	assertEquals("b", dll.removeFirst());
    	assertEquals("z", dll.removeLast());
    	assertEquals("a", dll.removeFirst());
    	assertEquals("y", dll.removeLast());
    	assertEquals(0, dll.size());
    }
    
    public void testRankedSequence() throws Full, InvalidRankException {
    	NodeRankedSequence<String> rankedSequence = new NodeRankedSequence<>();
    	rankedSequence.insertFirst("A");
    	rankedSequence.insertLast("Z");
    	rankedSequence.insertElementAtRank(1, "M");
    	// A, M, Z
    	String removed = rankedSequence.removeElementAtRank(2);
    	assertEquals("Z", removed);
    	String s = rankedSequence.elementAtRank(1);
    	assertEquals("M", s);
    	rankedSequence.insertLast("Z");
    	rankedSequence.replaceElementAtRank(1, "N");
    	// A, N, Z
    	assertEquals("A", rankedSequence.elementAtRank(0));
    	assertEquals("N", rankedSequence.elementAtRank(1));
    	assertEquals("Z", rankedSequence.elementAtRank(2));
    	
    }
    
    public void testNodePositionalSequence() throws InvalidPositionException {
    	NodePositionalSequence<String> nps = new NodePositionalSequence<>();
    	nps.insertFirst("jz");
    	nps.insertLast("zz");
    	Position<String, PositionalSequence<String>> position = nps.first();
    	assertEquals("jz", position.getElement().get());
    	PositionalSequence<String> container = position.getContainer();
    	assertTrue(nps == container); // same reference
    	nps.insertAfter(position, "AA");
    	assertTrue(nps.count() == 3);
    }
    
}
