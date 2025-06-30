package LinkedList;

public class CLL {
    Node head;
    Node tail ;
    int size = 0 ;

    public void append(int value){
        Node node = new Node(value) ;
        if (head != null && tail != null){
            tail.next = node ;
            node.next = head ;
            tail = node ;
        } else {
            head = node ;
            tail = node ;
        }
        this.size++ ;
    }

    public void delete(int value){
        if (head == null) return; // Empty list

        if (head.value == value) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            size--;
            return;
        }

        Node current = head;
        do {
            Node nextNode = current.next;
            if (nextNode.value == value) {
                current.next = nextNode.next;
                if (nextNode == tail) {
                    tail = current;
                }
                size--;
                return;
            }
            current = current.next;
        } while (current != head);
    }


    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("End");
    }
    private class Node {
        int value ;
        Node next;

        public Node(int value){
            this.value = value ;
        }
    }
}
