/*
    Find the running median of an array using heaps
*/

import java.util.PriorityQueue;
import java.util.Comparator;

public class ContinuousMedian {
    public static void addNumber(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() == 0 || number < lower.peek()) {
            lower.add(number);
        } else {
            higher.add(number);
        }
    }

    public static void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() * smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }
    public static double[] getMedians(int[] array) {
        // max heap
        PriorityQueue<Integer> lower = new PriorityQueue<Integer> (new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });

        // min heap
        PriorityQueue<Integer> higher = new PriorityQueue<Integer>(); 

        double[] medians = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            addNumber(number, lower, higher);
            rebalance(lower, higher);
            medians[i] = getMedian(lower, higher);
        }
        return medians;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,6,22,200,201};

        double[] testMedians = getMedians(array);

        for (double d : testMedians) {
            System.out.println(d);
        }
    }
}