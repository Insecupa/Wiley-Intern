package Day13.Assignment.LinkedListMap;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {
    Node root;
    private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public RemoveDuplicates(int data) {
        this.root = new Node(data);
    }

    public RemoveDuplicates(){
        root = null;
    }

    public Boolean insert(int data){
        if(this.root == null) {
            this.root = new Node(data);
            return true;
        }
        Node temp = root;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = new Node(data);
        return true;
    }

    public void print() {
        if(root == null)
            System.out.println(" ");
        else{
            Node temp = root;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public Boolean removeDuplicates() {
        Set<Integer> map = new TreeSet<>();

        if(root == null)
            return false;

        Node current = root;
        Node prev = null;
        while(current != null){
            if(map.contains(current.data)){
                prev.next = current.next;
            }else{
                map.add(current.data);
                prev = current;
            }
            current = current.next;
        }
        return true;
    }

    public static void main(String[] args) {
        RemoveDuplicates list = new RemoveDuplicates();
        list.insert(2);
        list.insert(5);
        list.insert(15);
        list.insert(7);
        list.insert(0);
        list.insert(9);
        list.insert(13);
        list.insert(10);
        list.insert(18);
        list.insert(18);
        list.insert(9);
        list.insert(10);

        System.out.println("Before Duplis");
        list.print();

        list.removeDuplicates();

        System.out.println("After Duplis");
        list.print();
    }
}
