package com.jenkov.concurrent;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {

    	/*BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);*/
        
        /*BlockingQueue priorityBlockingQueue   = new PriorityBlockingQueue();
        priorityBlockingQueue.put("a");
        priorityBlockingQueue.put("v");
        priorityBlockingQueue.put("c");
        priorityBlockingQueue.put("b");
        
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue.take());*/

    	
    	/*BlockingDeque<String> deque = new LinkedBlockingDeque<String>();

    	deque.addFirst("1");
    	deque.addLast("2");

    	String one = deque.takeFirst();
    	String two = deque.takeLast();
    	
    	System.out.println(two);
    	System.out.println(one);*/
    	
    	/*ConcurrentMap concurrentMap = new ConcurrentHashMap();

    	concurrentMap.put("key", "value");

    	Object value = concurrentMap.get("key");*/
    	
    	/**
    	 * The headMap will point to a ConcurrentNavigableMap which only contains the key "1", 
    	 * since only this key is strictly less than "2".
    	 */
    	/*ConcurrentNavigableMap map = new ConcurrentSkipListMap();

    	map.put("1", "one");
    	map.put("2", "two");
    	map.put("3", "three");

    	ConcurrentNavigableMap headMap = map.headMap("2");*/
    	
    	/**
    	 * The tailMap will contain the keys "2" and "3" 
    	 * because these two keys are greather than or equal to the given key, "2".
    	 */
    	/*ConcurrentNavigableMap map = new ConcurrentSkipListMap();

    	map.put("1", "one");
    	map.put("2", "two");
    	map.put("3", "three");

    	ConcurrentNavigableMap tailMap = map.tailMap("2");*/
    	
    	/**
    	 * The returned submap contains only the key "2", because only this key is greater than or equal to "2", and smaller than "3".
    	 */
    	ConcurrentNavigableMap map = new ConcurrentSkipListMap();

    	map.put("1", "one");
    	map.put("2", "two");
    	map.put("3", "three");

    	ConcurrentNavigableMap subMap = map.subMap("2", "3");
    }
}
