package LinkedList;

public class DLL {
    Node head;
    Node tail;
    int size ;
    public DLL(){
        this.size = 0 ;
    }
    private class Node{
        int value ;
        Node next, prev ;

        public Node(int val){
            this.value = val ;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val) ;
        if (this.size == 0) tail = node ;
        node.next = head ;
        node.prev = null ;
        if (head != null){
            head.prev = node ;
        }
        head = node ;
        this.size++ ;
    }

    public void traverse(){
        Node temp = head ;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next ;
        }
    }

    public void append(int value){
        Node temp = new Node(value) ;
        if (head == null){
            head = temp ;
            tail = temp ;
            temp.prev = null ;
            temp.next = null ;
            this.size++ ;
            return ;
        }
        tail.next = temp ;
        temp.prev = tail ;
        tail = temp ;
        temp.next = null ;
        this.size++ ;
    }

    public void traverseRev(){
        Node node = tail ;
        while (node != null){
            System.out.println(node.value);
            node = node.prev ;
        }
    }
}
