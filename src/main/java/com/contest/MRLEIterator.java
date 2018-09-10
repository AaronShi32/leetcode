package com.contest;

public class MRLEIterator {

    private int start;

    private int[] A;

    public MRLEIterator(int[] A) {
        start = 0;
        this.A = A;
    }

    public int next(int n) {
        int count = 0;
        for (int i = start; i < A.length; i += 2) {
            count += A[i];
            if(count < n){
                A[i] = 0;
            } else {
                A[i] = count - n;
                start = i;
                return A[i + 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {635, 606, 576, 391, 370, 981, 36, 21, 961, 185, 124, 210, 801, 937, 22, 426, 101, 260, 221, 647, 350, 180, 504, 39, 101, 989, 199, 358, 732, 839, 919, 169, 673, 967, 58, 676, 846, 342, 250, 597, 442, 174, 472, 410, 569, 509, 311, 357, 838, 251};
        MRLEIterator instance = new MRLEIterator(x);
        System.out.println(instance.next(5039));
        System.out.println(instance.next(62));
        System.out.println(instance.next(3640));
        System.out.println(instance.next(671));
        System.out.println(instance.next(67));
        System.out.println(instance.next(395));
        System.out.println(instance.next(262));
        System.out.println(instance.next(839));
        System.out.println(instance.next(74));
        System.out.println(instance.next(43));
        System.out.println(instance.next(42));
        System.out.println(instance.next(77));
        System.out.println(instance.next(13));

    }

}
