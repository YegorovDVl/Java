package LinkedArrayList;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedArrayListTest extends TestCase {


    public void testAddFirst0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        TestList.addFirst(expect);
        Assert.assertEquals(expect, TestList.getFirst());
    }

    public void testAddFirst1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        for (int i = 0; i < 5; i++){
            TestList.addFirst(""+i);
        }
        TestList.addFirst(expect);
        Assert.assertEquals(expect, TestList.getFirst());
    }

    public void testAddFirst2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        int Test = 0;
        for (int i = 0; i < 1000; i++){
            TestList.addFirst(""+i);
        }
        try {
            TestList.addFirst("Test");
        } catch (IllegalStateException ex){
            Test = 1;
        }
        Assert.assertEquals(1, Test);
    }

    public void testAddLast0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        TestList.addLast(expect);
        Assert.assertEquals(expect, TestList.getLast());
    }

    public void testAddLast1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        for (int i = 0; i < 5; i++){
            TestList.addLast(""+i);
        }
        TestList.addLast(expect);
        Assert.assertEquals(expect, TestList.getLast());
    }

    public void testAddLast2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        int Test = 0;
        for (int i = 0; i < 1000; i++){
            TestList.addLast(""+i);
        }
        try {
            TestList.addLast("Test");
        } catch (IllegalStateException ex){
            Test = 1;
        }
        Assert.assertEquals(1, Test);
    }

    public void testOfferFirst0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        TestList.offerFirst(expect);
        Assert.assertEquals(expect, TestList.getFirst());
    }

    public void testOfferFirst1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 5; i++){
            TestList.offerFirst(""+i);
        }
        boolean Test = TestList.offerFirst("Test");
        Assert.assertEquals(true, Test);
        Assert.assertEquals("Test", TestList.getFirst());
    }

    public void testOfferFirst2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 1100; i++){
            TestList.offerFirst(""+i);
        }
        String Test = "999";
        Assert.assertEquals(Test, TestList.getFirst());
    }

    public void testOfferLast0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        TestList.offerLast(expect);
        Assert.assertEquals(expect, TestList.getLast());
    }

    public void testOfferLast1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 5; i++){
            TestList.offerLast(""+i);
        }
        boolean Test = TestList.offerLast("Test");
        Assert.assertEquals(true, Test);
        Assert.assertEquals("Test", TestList.getLast());
    }

    public void testOfferLast2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 1100; i++){
            TestList.offerLast(""+i);
        }
        String Test = "999";
        Assert.assertEquals(Test, TestList.getLast());
    }

    public void testRemoveFirst0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        TestList.addFirst("Test");
        TestList.removeFirst();
        int Test = 0;
        Assert.assertEquals(Test, TestList.size());
    }

    public void testRemoveFirst1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        TestList.removeFirst();
        String Test = "4";
        int size = 5;
        Assert.assertEquals(Test, TestList.getFirst());
        Assert.assertEquals(size, TestList.size());
    }

    public void testRemoveFirst2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        boolean Flag = false;
        try {
            TestList.removeFirst();
        } catch (NoSuchElementException er){
            Flag = true;
        }
        Assert.assertEquals(true, Flag);
    }

    public void testRemoveLast0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        TestList.addLast("Test");
        TestList.removeLast();
        int Test = 0;
        Assert.assertEquals(Test, TestList.size());
    }

    public void testRemoveLast1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        TestList.removeLast();
        String Test = "4";
        int size = 5;
        Assert.assertEquals(Test, TestList.getLast());
        Assert.assertEquals(size, TestList.size());
    }

    public void testRemoveLast2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        boolean Flag = false;
        try {
            TestList.removeLast();
        } catch (NoSuchElementException er){
            Flag = true;
        }
        Assert.assertEquals(true, Flag);
    }

    public void testPollFirst0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        TestList.addFirst("Test");
        TestList.pollFirst();
        int Test = 0;
        Assert.assertEquals(Test, TestList.size());
    }

    public void testPollFirst1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        TestList.pollFirst();
        String Test = "4";
        int size = 5;
        Assert.assertEquals(Test, TestList.getFirst());
        Assert.assertEquals(size, TestList.size());
    }

    public void testPollFirst2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Assert.assertEquals(null, TestList.pollFirst());
    }

    public void testPollLast0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        TestList.addLast("Test");
        TestList.pollLast();
        int Test = 0;
        Assert.assertEquals(Test, TestList.size());
    }

    public void testPollLast1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        TestList.pollLast();
        String Test = "4";
        int size = 5;
        Assert.assertEquals(Test, TestList.getLast());
        Assert.assertEquals(size, TestList.size());
    }

    public void testPollLast2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Assert.assertEquals(null, TestList.pollLast());
    }

    public void testGetFirst0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "0";
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        Assert.assertEquals(Test, TestList.getFirst());
    }

    public void testGetFirst1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "5";
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        Assert.assertEquals(Test, TestList.getFirst());
    }

    public void testGetFirst2() {
        boolean flag = false;
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        try {
            TestList.getFirst();
        } catch (NoSuchElementException er){
            flag = true;
        }
        Assert.assertEquals(true, flag);
    }

    public void testGetLast0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "5";
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        Assert.assertEquals(Test, TestList.getLast());
    }

    public void testGetLast1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "0";
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        Assert.assertEquals(Test, TestList.getLast());
    }

    public void testGetLast2() {
        boolean flag = false;
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        try {
            TestList.getLast();
        } catch (NoSuchElementException er){
            flag = true;
        }
        Assert.assertEquals(true, flag);
    }

    public void testPeekFirst0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "0";
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        Assert.assertEquals(Test, TestList.peekFirst());
    }

    public void testPeekFirst1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "5";
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        Assert.assertEquals(Test, TestList.peekFirst());
    }

    public void testPeekFirst2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Assert.assertEquals(null, TestList.peekFirst());
    }

    public void testPeekLast0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "5";
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        Assert.assertEquals(Test, TestList.peekLast());
    }

    public void testPeekLast1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "0";
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        Assert.assertEquals(Test, TestList.peekLast());
    }

    public void testPeekLast2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Assert.assertEquals(null, TestList.peekLast());
    }

    public void testRemoveFirstOccurrence0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        TestList.removeFirstOccurrence("1");
        boolean flag = TestList.contains("1");
        Assert.assertEquals(false, flag);
        Assert.assertEquals(5, TestList.size());
    }

    public void testRemoveFirstOccurrence1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        TestList.addLast("1");
        TestList.removeFirstOccurrence("1");
        boolean flag = TestList.contains("1");
        Assert.assertEquals(true, flag);
        Assert.assertEquals(6, TestList.size());
    }

    public void testRemoveFirstOccurrence2() {
        boolean flag = false;
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        try {
            TestList.removeFirstOccurrence(null);
        } catch (NullPointerException er){
            flag = true;
        }
        Assert.assertEquals(true, flag);
    }

    public void testRemoveLastOccurrence0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        TestList.removeLastOccurrence("1");
        boolean flag = TestList.contains("1");
        Assert.assertEquals(false, flag);
        Assert.assertEquals(5, TestList.size());
    }

    public void testRemoveLastOccurrence1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        TestList.addLast("1");
        TestList.removeLastOccurrence("1");
        boolean flag = TestList.contains("1");
        Assert.assertEquals(true, flag);
        Assert.assertEquals(6, TestList.size());
    }

    public void testRemoveLastOccurrence2() {
        boolean flag = false;
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        try {
            TestList.removeLastOccurrence(null);
        } catch (NullPointerException er){
            flag = true;
        }
        Assert.assertEquals(true, flag);
    }

    public void testAdd0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        TestList.add(expect);
        Assert.assertEquals(expect, TestList.getLast());
    }

    public void testAdd1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        for (int i = 0; i < 5; i++){
            TestList.add(""+i);
        }
        TestList.add(expect);
        Assert.assertEquals(expect, TestList.getLast());
    }

    public void testAdd2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        int Test = 0;
        for (int i = 0; i < 1000; i++){
            TestList.add(""+i);
        }
        try {
            TestList.add("Test");
        } catch (IllegalStateException ex){
            Test = 1;
        }
        Assert.assertEquals(1, Test);
    }

    public void testOffer0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        TestList.offer(expect);
        Assert.assertEquals(expect, TestList.getLast());
    }

    public void testOffer1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 5; i++){
            TestList.offer(""+i);
        }
        boolean Test = TestList.offer("Test");
        Assert.assertEquals(true, Test);
        Assert.assertEquals("Test", TestList.getLast());
    }

    public void testOffer2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 1100; i++){
            TestList.offer(""+i);
        }
        String Test = "999";
        Assert.assertEquals(Test, TestList.getLast());
    }

    public void testRemove0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        TestList.addFirst("Test");
        TestList.remove();
        int Test = 0;
        Assert.assertEquals(Test, TestList.size());
    }

    public void testRemove1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        TestList.remove();
        String Test = "4";
        int size = 5;
        Assert.assertEquals(Test, TestList.getFirst());
        Assert.assertEquals(size, TestList.size());
    }

    public void testRemove2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        boolean Flag = false;
        try {
            TestList.remove();
        } catch (NoSuchElementException er){
            Flag = true;
        }
        Assert.assertEquals(true, Flag);
    }

    public void testPoll0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        TestList.addFirst("Test");
        TestList.poll();
        int Test = 0;
        Assert.assertEquals(Test, TestList.size());
    }

    public void testPoll1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        TestList.poll();
        String Test = "4";
        int size = 5;
        Assert.assertEquals(Test, TestList.getFirst());
        Assert.assertEquals(size, TestList.size());
    }

    public void testPoll2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Assert.assertEquals(null, TestList.poll());
    }

    public void testElement0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "0";
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        Assert.assertEquals(Test, TestList.element());
    }

    public void testElement1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "5";
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        Assert.assertEquals(Test, TestList.element());
    }

    public void testElement2() {
        boolean flag = false;
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        try {
            TestList.element();
        } catch (NoSuchElementException er){
            flag = true;
        }
        Assert.assertEquals(true, flag);
    }

    public void testPeek0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "0";
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        Assert.assertEquals(Test, TestList.peek());
    }

    public void testPeek1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String Test = "5";
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        Assert.assertEquals(Test, TestList.peek());
    }

    public void testPeek2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Assert.assertEquals(null, TestList.peek());
    }

    public void testAddAll0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        ArrayList<String> Array = new ArrayList<String>();
        String Test1 = "Test1";
        String Test2 = "Test2";
        Array.add(Test1);
        Array.add(Test2);
        TestList.addAll(Array);
        int size = TestList.size();
        Assert.assertEquals(2, size);
        Assert.assertEquals(Test1, TestList.getFirst());
        Assert.assertEquals(Test2, TestList.getLast());
    }

    public void testAddAll1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        ArrayList<String> Array = new ArrayList<String>();
        String Test1 = "Test1";
        String Test2 = "Test2";
        Array.add(Test1);
        Array.add(Test2);
        TestList.addFirst("1");
        TestList.addAll(Array);
        int size = TestList.size();
        Assert.assertEquals(3, size);
        Assert.assertEquals("1", TestList.getFirst());
        Assert.assertEquals(Test2, TestList.getLast());
    }

    public void testAddAll2() {
        boolean flag = false;
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        ArrayList<String> Array = new ArrayList<String>();
        Array.add("Test1");
        Array.add("Test2");
        for (int i = 0; i < 999; i++){
            TestList.add(""+i);
        }
        try {
            TestList.addAll(Array);
        } catch (IllegalStateException er){
            flag = true;
        }
        Assert.assertEquals(true, flag);
    }

    public void testPush0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        TestList.push(expect);
        Assert.assertEquals(expect, TestList.getFirst());
    }

    public void testPush1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        String expect = "Test";
        for (int i = 0; i < 5; i++){
            TestList.push(""+i);
        }
        TestList.push(expect);
        Assert.assertEquals(expect, TestList.getFirst());
    }

    public void testPush2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        int Test = 0;
        for (int i = 0; i < 1000; i++){
            TestList.push(""+i);
        }
        try {
            TestList.push("Test");
        } catch (IllegalStateException ex){
            Test = 1;
        }
        Assert.assertEquals(1, Test);
    }

    public void testPop0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        TestList.addFirst("Test");
        TestList.pop();
        int Test = 0;
        Assert.assertEquals(Test, TestList.size());
    }

    public void testPop1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addFirst(""+i);
        }
        TestList.pop();
        String Test = "4";
        int size = 5;
        Assert.assertEquals(Test, TestList.getFirst());
        Assert.assertEquals(size, TestList.size());
    }

    public void testPop2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        boolean Flag = false;
        try {
            TestList.pop();
        } catch (NoSuchElementException er){
            Flag = true;
        }
        Assert.assertEquals(true, Flag);
    }

    public void testBoolRemove0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        TestList.remove("1");
        boolean flag = TestList.contains("1");
        Assert.assertEquals(false, flag);
        Assert.assertEquals(5, TestList.size());
    }

    public void testBoolRemove1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        TestList.addLast("1");
        TestList.remove("1");
        boolean flag = TestList.contains("1");
        Assert.assertEquals(true, flag);
        Assert.assertEquals(6, TestList.size());
    }

    public void testBoolRemove2() {
        boolean flag = false;
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 6; i++){
            TestList.addLast(""+i);
        }
        try {
            TestList.remove(null);
        } catch (NullPointerException er){
            flag = true;
        }
        Assert.assertEquals(true, flag);
    }

    public void testContains0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        TestList.add("1");
        Assert.assertEquals(true, TestList.contains("1"));
    }

    public void testContains1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Assert.assertEquals(false, TestList.contains("1"));
    }

    public void testContains2() {
        boolean flag = false;
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        TestList.add("1");
        try {
            TestList.contains(null);
        } catch (NullPointerException er){
            flag = true;
        }
        Assert.assertEquals(true, flag);
    }

    public void testSize0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Assert.assertEquals(0, TestList.size());
    }

    public void testSize1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 10; i ++){
            TestList.add(""+i);
        }
        Assert.assertEquals(10, TestList.size());
    }

    public void testSize2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        for (int i = 0; i < 13; i ++){
            TestList.add(""+i);
        }
        for (int i = 0; i < 13; i ++){
            TestList.addFirst(""+i);
        }
        Assert.assertEquals(26, TestList.size());
    }

    public void testIterator0() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Iterator<String> iter = TestList.iterator();
        TestList.add("1");
        TestList.add("2");
        TestList.add("3");
        Assert.assertEquals("1", iter.next());
        Assert.assertEquals("2", iter.next());
    }

    public void testIterator1() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Iterator<String> iter = TestList.iterator();
        Assert.assertEquals(false, iter.hasNext());
    }

    public void testIterator2() {
        LinkedArrayList<String> TestList = new LinkedArrayList<String>();
        Iterator<String> iter = TestList.iterator();
        TestList.add("1");
        TestList.add("2");
        TestList.add("3");
        iter.next();
        iter.next();
        iter.remove();
        Assert.assertEquals(2, TestList.size());
        Assert.assertEquals(false, TestList.contains("2"));
    }

}