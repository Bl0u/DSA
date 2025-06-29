package LinkedList;

public class Main {
    public static void main (String[] args){
        LL ll = new LL() ;
        ll.insertFirst(5);
        ll.insertFirst(3);

        ll.append(10);
        ll.append(0, 47) ;
        ll.append(2, 48) ;
        ll.append(3, 49) ;
        ll.append(5, 50) ;
        ll.traverse();
    }
}
