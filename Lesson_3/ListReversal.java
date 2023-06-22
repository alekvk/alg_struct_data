package Home_tasks.Lesson_3;


class dList{
    static Node head;
    static Node tail;
    
    static class Node{
        int value;
        Node next;
        Node prev;
    }

    public static void pushFront(int value){
        Node node = new Node();
        node.value = value;
        
        if(head == null){
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public static void popFront(){
        if(head != null && head.next != null){
            head = head.next;
        }else{
            tail = null;
            head = null;
        }
    }

    public static void print(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static boolean find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void pushBack(int value){
        Node node = new Node();
        node.value = value;
        

        if(tail == null){
            head = node;
        }else{
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
             


    }

    public static void popBack(){
        if(tail != null && tail.prev != null){
            tail = tail.prev;
            tail.next = null;
        }else{
            tail = null;
            head = null;
        }
    }

    public static void sort(){
        boolean needSort = true;
        do{
            needSort = false;
            if(head != null) {
                Node node = head;
                while (node != null && node.next != null) {
                    if(node.value > node.next.value){
                        Node before = node.prev;
                        Node cur = node;
                        Node next = node.next;
                        Node after = next.next;

                        cur.next = after;
                        cur.prev = next;
                        next.next = cur;
                        next.prev = before;

                        if(after != null){
                            after.prev = cur;
                        }else{
                            tail = cur;
                        }

                        if(before != null){
                            before.next = next;
                        }else{
                            head = next;
                        }

                        needSort = true;
                    }
                    node = node.next;
                }
            }
        }while(needSort);
    }

 
    public void reverseList() {
        tail = head;
        Node current = head.next;
        head.next = null;
        while (current != null) {
          Node nextElement = current.next;
          current.next = head;
          head = current;
          current = nextElement;
          }
    }

    /*  public void reverseList() {
        tail = head;
        System.out.println("tail.value" + "  " + tail.value);  
        Node current = head.next;
        System.out.println("Node current = head.next;  ");  
        System.out.println("current" + "  " + current);  
        System.out.println("current.value" + "  " + current.value);  
        head.next = null;
        System.out.println(" while (current != null) ");
        int i = 1;
        while (current != null) {
          System.out.println("");    
          System.out.println(i + "-я" + " итерация");   
          System.out.println("current.next" + "  " + current.next ); 
          System.out.println("current.value" + "  " + current.value);  
          System.out.println("Node nextElement = current.next; ");  
          Node nextElement = current.next;
          System.out.println("nextElement" + "   " + nextElement);
          System.out.println("nextElement.value" + "   " +nextElement.value ); 
          System.out.println("head" + "   " + head );  
          current.next = head;
          head = current;
          System.out.println("head = current;" );
          System.out.println("head.value" + "   " + head.value );
          Node pre = head.next;
          System.out.println("pre.value" + "  " + pre.value);
          current = nextElement;
          System.out.println("current = nextElement;" );
          System.out.println("current.value" + "   " + current.value );
          i++;
      }
    } */

  
}
public class ListReversal {
    public static void main(String[] args) {
        dList list = new dList();
        for(int i=10; i>=1; i--)
            list.pushBack(i);

        list.print();
        list.reverseList();
        list.print();
        list.reverseList();
        list.print();
        
       
    }       
}

























/* class List{
    static Node head;
    static class Node{
        int value;
        Node next;
    }

    public static void pushFront(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public static void popFront(){
        if(head != null){
            head = head.next;
        }
    }

    public static void print(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static boolean find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void pushBack(int value){
        Node node = new Node();
        node.value = value;

        if(head == null){
            head = node;
        }else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    public static void popBack(){
        if(head != null){
            if(head.next == null){
                head = null;
            }else {
                Node cur = head;
                while (cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
    }

} */








