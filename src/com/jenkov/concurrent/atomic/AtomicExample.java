package com.jenkov.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicExample {

	public static void main(String[] args) {
		/*AtomicBoolean atomicBoolean = new AtomicBoolean(true);
		System.out.println(atomicBoolean.get());*/		
		
		/*boolean oldValue = atomicBoolean.getAndSet(false);
		System.out.println(oldValue);
		
		boolean expectedValue = true;
		boolean newValue = true;
		boolean wasNewValueSet = atomicBoolean.compareAndSet(expectedValue, newValue);
		System.out.println(wasNewValueSet);
		System.out.println(atomicBoolean.get());*/
		
		
		/*boolean prev;
        do {
            prev = atomicBoolean.get();
            System.out.println("prev:"+prev);//在这之间atomicBoolean的值可能被修改.如果compareAndSet返回false,证明prev和现在的atomicBoolean的值不同，所以需要再次循环获取最新的prev.
        } while (!atomicBoolean.compareAndSet(prev, false));*/
        
		
		
		/*AtomicInteger atomicInteger = new AtomicInteger(123);
		int theValue = atomicInteger.get();
		System.out.println(theValue);
		
		atomicInteger.set(234);
		
		int expectedValue = 123;
		int newValue      = 234;
		boolean waTheNewInteger = atomicInteger.compareAndSet(expectedValue, newValue);
		System.out.println(waTheNewInteger);
		
		System.out.println(atomicInteger.getAndAdd(10));
		System.out.println(atomicInteger.addAndGet(10));
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.incrementAndGet());
		System.out.println(atomicInteger.decrementAndGet());
		System.out.println(atomicInteger.getAndDecrement());
		System.out.println(atomicInteger.accumulateAndGet(5, new IntBinaryOperator() {
			
			@Override
			public int applyAsInt(int left, int right) {
				
				return left*right;
			}
		}));*/
		
		
//		AtomicReference atomicReference = new AtomicReference();
		
//		String initialReference = "the initially referenced string";
//		AtomicReference atomicReference = new AtomicReference(initialReference);
//		String reference = (String) atomicReference.get();
		
//		String initialReference = "the initially referenced string";
//		AtomicReference<String> atomicStringReference = new AtomicReference<String>(initialReference);
//		String reference = atomicStringReference.get();
		
//		AtomicReference atomicReference = new AtomicReference();
//		atomicReference.set("New object referenced");
		
		
		/*String initialReference = "initial value referenced";

		AtomicReference<String> atomicStringReference = new AtomicReference<String>(initialReference);

		String newReference = "new value referenced";
		boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
		System.out.println("exchanged: " + exchanged);

		exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
		System.out.println("exchanged: " + exchanged);
		
		String updateString = atomicStringReference.updateAndGet(new UnaryOperator<String>() {
			
			@Override
			public String apply(String t) {
				
				return "update string:"+t;
			}
		});
		System.out.println(updateString);*/
		
		
		/*String initialRef   = "text";
		int initialStamp = 0;

		AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<String>(initialRef, initialStamp);

		int[] stampHolder = new int[1];
		String ref = atomicStampedReference.get(stampHolder);

		System.out.println("ref = " + ref);
		System.out.println("stamp = " + stampHolder[0]);
		
		String newRef = "New object referenced";
		int newStamp = 1;
		atomicStampedReference.set(newRef, newStamp);*/
		
		/**
		 * The A-B-A problem can occur in non-blocking algorithms.
		 * Non-blocking algorithms often use a reference to an ongoing modification to the guarded data structure,
		 * to signal to other threads that a modification is currently ongoing. 
		 * If thread 1 sees that there is no ongoing modification (reference points to null), 
		 * another thread may submit a modification (reference is now non-null), 
		 * complete the modification and swap the reference back to null without thread 1 detecting it. 
		 * Exactly how the A-B-A problem occurs in non-blocking algorithsm is explained in more detail in my tutorial about non-blocking algorithms.
		 */
		/*Object initialRef   = null;
		int initialStamp = 0;

		AtomicStampedReference atomicStampedReference = new AtomicStampedReference(initialRef, initialStamp);
		int[] stampHolder = new int[1];
		Object ref = atomicStampedReference.get(stampHolder);

		if(ref == null){
		    //prepare optimistic modification
		}

		//if another thread changes the reference and stamp here,
		//it can be detected

		int[] stampHolder2 = new int[1];
		Object ref2 = atomicStampedReference.get(stampHolder);

		if(ref == ref2 && stampHolder[0] == stampHolder2[0]){
		    //no modification since optimistic modification was prepared

		} else {
		    //retry from scratch.
		}*/
		
		
//		AtomicIntegerArray array = new AtomicIntegerArray(10);
		
		int[] ints = new int[10];
		ints[5] = 123;
		AtomicIntegerArray array = new AtomicIntegerArray(ints);
		int value = array.get(5);
		array.set(5, 999);
		boolean swapped = array.compareAndSet(5, 999, 123);
		int newValue = array.addAndGet(5, 3);
		int oldValue = array.getAndAdd(5, 3);
		int newIncreValue = array.incrementAndGet(5);
		int oldIncreValue = array.getAndIncrement(5);
		int newDecreValue = array.decrementAndGet(5);
		int oldDecreValue = array.getAndDecrement(5);
	}
	
}
