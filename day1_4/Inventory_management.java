public class Inventory_management{
    private Node head, tail;
    private int size;

    public Inventory_management(){
        this.size = 0;
    }

    public void insert_first(String item_name, int item_id, int price, int quantity){
        Node node = new Node(item_name, item_id, price, quantity);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }
    
    public void insert_last(String item_name, int item_id, int price, int quantity){
        if(tail == null){
            insert_first(item_name, item_id, price, quantity);
            return;
        }
        Node node = new Node(item_name, item_id, price, quantity);
        tail.next = node;
        tail = node;
        size++;

    }
    
    public void insert(String item_name, int item_id, int price, int quantity, int index){
        if(index == 0){
            insert_first(item_name, item_id, price, quantity);
            return;
        }
        else if(index == size-1){
            insert_last(item_name, item_id, price, quantity);
            return;
        }
        else if(index >= size){
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node node = new Node(item_name, item_id, price, quantity);
        Node temp = head;
        for(int i = 1; i<index; i++){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;

        size++;

    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.println("item name: " +temp.item_name+ " -> item id: " +temp.item_id+ " -> price: " +temp.price+ " -> quantity: " +temp.quantity);
            temp = temp.next;
        }
        System.out.println("|_> END");

    }

    private class Node{
        private Node next;
        private int item_id, price, quantity;
        private String item_name;

        public Node(String item_name, int item_id, int price, int quantity){
            this.item_name = item_name;
            this.item_id = item_id;
            this.price = price;
            this.quantity = quantity;
        }
    }
}