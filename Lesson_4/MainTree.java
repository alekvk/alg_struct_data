package Home_tasks.Lesson_4;

import java.util.Scanner;

class Tree{
    Node root;

    class Node{
        int value;
        Node left;
        Node right;
        private Color color;
    }

     private enum Color {
        RED,
        BLACK
    }


    public Node find(int value){
        return find(root, value);
    }

    private Node find(Node node, int value){
        if(node == null){
            return null;
        }
        if(node.value == value){
            return node;
        }
        if(node.value < value){
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }

    public void insert(int value){
        if(root == null){
            root = new Node();
            root.color = Color.BLACK; 
            root.value = value;

        }else {
            insert(root, value);
            root = balance(root);
            root.color = Color.BLACK;
        }

        //root.color = BLACK;
    }

    public void insert(Node node, int value){
        if(node.value != value){
            if(node.value < value){
                if(node.right == null){
                    node.right = new Node();
                    System.out.println("node.right");
                    System.out.println(node.right);
                    node.right.color = Color.RED;
                    node.right.value = value;
                    //node.right.color = RED;
                }else{
                    insert(node.right, value);
                    node.right = balance (node.right);
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    System.out.println("node.left");
                    System.out.println(node.left);
                    node.left.color = Color.RED;
                    node.left.value = value;
                    //node.left.color = RED;
                }else{
                    insert(node.left, value);
                    node.left = balance (node.left); 
                }
            }
        }
    }

    private Node balance(Node node) {
        Node result = node;
        boolean needBalance;
        do {
            needBalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                     (result.left == null || result.left.color == Color.BLACK)) {
                needBalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED && 
                    result.left.left != null && result.left.left.color == Color.RED) {
                needBalance = true; 
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                   result.right != null && result.right.color == Color.RED) {
                needBalance = true;
                colorSwap(result); 
            }
        }
        while (needBalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }
    
    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }



}

public class MainTree {
      public static void main(String[] args) {

        Tree tree = new Tree();  
        Scanner conin = new Scanner(System.in);
        
        System.out.print("Введите целое число: ");
        while (conin.hasNext()) {
            System.out.print("Введите целое число: ");
            if(conin.hasNextInt()) {
                tree.insert(conin.nextInt());
            }
            else {
                String str = conin.next ();
                if (str.equals("done")) break;
                else {
                    System.out.println("Ошибка формата данных.");
                    return;
                }
            }
        } 
    }
        
       
        //int num = in.nextInt();


        /* Tree tree = new Tree();

        for(int i = 10; i >= 0; i--){
            tree.insert(i);
        } */

        

}


    

