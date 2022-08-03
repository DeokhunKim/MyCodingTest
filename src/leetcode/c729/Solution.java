package leetcode.c729;

public class Solution {

    public static void main(String[] args) {

        MyCalendar myCalendar = new MyCalendar();

        //["MyCalendar","book","book","book"]
        //[[],[10,20],[15,25],[20,30]]

        //["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
        //[[],[23,32],[42,50],[6,14],[0,7],[21,30],[26,31],[46,50],[28,36],[0,6],[27,36],[6,11],[20,25],[32,37],[14,20],[7,16],[13,22],[39,47],[37,46],[42,50],[9,17],[49,50],[31,37],[43,49],[2,10],[3,12],[8,14],[14,21],[42,47],[43,49],[36,43]]

        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(23,32));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(42,50));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(6,14));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(0,7));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(21,30));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(26,31));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(46,50));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(28,36));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(0,6));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(27,36));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(6,11));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(20,25));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(32,37));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(14,20));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(7,16));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(13,22));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(39,47));

        System.out.println("myCalendar.book = " + myCalendar.book(37,46));

        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(42,50));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(9,17));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(49,50));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(31,37));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(43,49));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(2,10));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(3,12));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(8,14));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(14,21));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(42,47));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(43,49));
        System.out.println("myCalendar.book(1,20) = " + myCalendar.book(36,43));




    }
}
