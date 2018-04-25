package org.leetcode.medium;

import java.util.*;

public class MyCalendarII {
	private List<int[]> overlap;
	private List<int[]> calendar;

    public MyCalendarII() {
        overlap = new ArrayList<>();
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] v : overlap) {
        	if(v[0] < end && start < v[1])
        		return false;
        }
        for(int[] v : calendar) {
        	if(v[0] < end && start < v[1])
        		overlap.add(new int[]{ Math.max(v[0], start), Math.min(v[1], end) });
        }
        calendar.add(new int[] { start, end });
        return true;
    }
}
