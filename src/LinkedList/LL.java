package LinkedList;

public class LL {
    Node head ;
    int size ;
    public LL(){
        this.size = 0 ;
    }

    public void insertFirst(int value){
        Node node = new Node(value) ;
        node.next = head ;
        head = node ;
        this.size++ ;

    }

    public void traverse(){
        Node temp = head ;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next ;
        }
        System.out.println("size -> "+this.size);
    }

    public void append(int val){
        Node newNode = new Node(val) ;
        if (head == null){
            head = newNode ;
            return ;
        }
        Node temp = head ;
        while (temp.next != null){
            temp = temp.next ;
        }
        temp.next = newNode ;
        this.size++ ;

    }

    public void append(int index, int value){
        if (index > size)  return ;
        if (index == size){
            this.append(value); ;
            return ;
        }
        Node node = new Node(value) ;
        if (head == null){
            head = node ;
            return ;
        }
        if (index == 0){
            node.next = head ;
            head = node ;
            return ;
        }
        Node temp = head ;
        int cnt = 0 ;
        while (temp.next != null && cnt < index){
            temp = temp.next ;
            cnt++ ;
        }
        if (temp.next != null){
            node.next = temp.next ;
            temp.next = node ;
            this.size++ ;
        }

    }

    private class Node{
        int value ;
        Node next ;

        public Node(int value){
            this.value = value ;
        }

        public Node (int value, Node next){
            this.value = value ;
            this.next= next ;
        }
    }
}
