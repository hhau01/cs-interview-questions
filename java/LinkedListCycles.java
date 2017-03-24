/*
    Check LinkedList for cycles:

    Create two "pointers": fast and slow. Fast traverses the LinkedList twice as fast as slow. If there is a cycle, then fast will traverse the cycle and catch up to slow. 
*/

public class LinkedListCycles {
    public static boolean hasCycle(Node head) {
        if (head == null) return false;
        Node fast = current;
        Node slow = head;
        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
    public static void main(String[] args) {
        // test code hurr
    }
}