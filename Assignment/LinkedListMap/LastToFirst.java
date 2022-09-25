package Day13.Assignment.LinkedListMap;


public class LastToFirst {
    Node root;
    private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
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

    public Node lastToFirst() {
        if(root == null)
            return null;
        if(root.next == null)
            return root;
        Node start = root;
        Node end = null;
        Node endPrev = null;

        while(start.next != null) {
            endPrev = start;
            start = start.next;

        }
        start = root;

        end = start;
        end.next = start.next;
        start.next = null;
        endPrev.next = start;

        return end;
    }

    public static void main(String[] args) {
        LastToFirst list = new LastToFirst();
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

        System.out.println("Before Changing");
        list.print();

        System.out.println("After changing");
        list.root = list.lastToFirst();

        list.print();

    }
}
