package LinkedList;

public class MainDLL {
    public static void main(String[] args){
        DLL dll = new DLL() ;
        dll.insertFirst(5);
        dll.insertFirst(51);
        dll.insertFirst(52);
        dll.insertFirst(54);
        dll.append(10);
        dll.append(11);
        dll.traverseRev();
    }

}
