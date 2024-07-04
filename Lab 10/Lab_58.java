public class Lab_58 {
    public static void main(String[] args) {
        Linked_List ll=new Linked_List();

        ll.insertAtFirstPosition(3);
        ll.insertAtFirstPosition(2);
        ll.insertAtFirstPosition(1);

        ll.insertAtLastPosition(8);
        ll.insertAtLastPosition(9);
        ll.insertAtLastPosition(10);

        ll.insertAtOrder(0);
        ll.insertAtOrder(5);
        ll.insertAtOrder(50);

        ll.displayLinkedList();
    }
}

class Linked_List{
    private Node first=null;

    protected void insertAtFirstPosition(int data){
        Node newNode=new Node(data);
        newNode.link=first;
        first=newNode;
    }

    protected void insertAtLastPosition(int data){
        Node newNode=new Node(data);
        if(first==null){
            first=newNode;
            return;
        }
        Node current=first;
        while(current.link!=null){
            current=current.link;
        }
        current.link=newNode;
    }

    protected void insertAtOrder(int data) {
        Node newNode = new Node(data);
        if (first == null || newNode.info <= first.info) {
            newNode.link = first;
            first = newNode;
            return;
        }
        Node current = first;
        while (current.link != null && newNode.info >= current.link.info) {
            current = current.link;
        }
        newNode.link = current.link;
        current.link = newNode;
    }

    protected void displayLinkedList() {
        Node current = first;
        String str="";
        System.out.print("Linked List : [");
        while (current != null) {
            str += current.info+", ";
            current = current.link;
        }
        str=str.substring(0, str.length()-2);
        str += "]";
        System.out.println(str);
    }
}
