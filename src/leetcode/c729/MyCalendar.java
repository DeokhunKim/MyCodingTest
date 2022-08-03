package leetcode.c729;

import java.util.*;

class MyCalendar {
    TreeSet<Integer> startSet = new TreeSet<>();
    TreeSet<Integer> endSet = new TreeSet<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        Iterator<Integer> startIter = startSet.iterator();
        Iterator<Integer> endIter = endSet.iterator();

        boolean isAdd = true;

        while (startIter.hasNext()) {
            Integer book_start = startIter.next();
            Integer book_end = endIter.next();

            if (book_start > end) {
                break;
            } else if (book_start == end) {
                isAdd = false;
                startSet.remove(book_start);
                startSet.add(start);
                break;
            } else if (start < book_start) {
                return false;
            } else if (start > book_start && end < book_end) {
                return false;
            } else if (start < book_end) {
                return false;
            } else if (start == book_end) {
                if ( !startIter.hasNext() ||
                        (startIter.hasNext() && startIter.next() >= end)) {
                    isAdd = false;
                    endSet.remove(book_end);
                    endSet.add(end);
                    break;
                }
                return false;
            } else {
                //break;
            }
        }
        if(isAdd)
            add(start, end);


        return true;
    }

    private void add(int start, int end) {
        startSet.add(start);
        endSet.add(end);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */