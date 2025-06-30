package LinkedList;

public class MainCLL {
    public static void main(String[] args){
        CLL cll = new CLL() ;
        cll.append(1) ;
        cll.append(12) ;
        cll.append(13) ;
        cll.append(14) ;
        cll.append(50) ;
        cll.delete(12);
        cll.delete(1);
        cll.delete(50);
        cll.delete(14);
        cll.delete(13);
        cll.traverse();
    }
}
