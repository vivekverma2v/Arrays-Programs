package com.learning.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> mxPQ;
	PriorityQueue<Integer> mnPQ;
	
	public MedianFinder() {
		mxPQ = new PriorityQueue<>(Comparator.reverseOrder()); //max heap
		mnPQ = new PriorityQueue<>();  //min heap
	}

	
	public void addNum(int num) {
		if(mxPQ.size() == 0 || mxPQ.peek() > num) 
			mxPQ.add(num);
		else mnPQ.add(num);
		if(mxPQ.size() > mnPQ.size() + 1)  // keeping difference between two heaps  = 1
			mnPQ.add(mxPQ.poll());
		else if(mnPQ.size() > mxPQ.size() + 1)
			mxPQ.add(mnPQ.poll());
	}

	public double findMedian() {
		if(mnPQ.size() == mxPQ.size())
			return (double)(mxPQ.peek() + mnPQ.peek()) / 2;

		if(mnPQ.size() > mxPQ.size()) return (double)mnPQ.peek();
		else return (double)mxPQ.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 301, 400, 3, 4, 5};
		MedianFinder finder = new MedianFinder();
		
		for (int i = 0; i < arr.length; ++i)
			finder.addNum(arr[i]);
		
		System.out.println("Median Number: " + finder.findMedian());			

	}
}
