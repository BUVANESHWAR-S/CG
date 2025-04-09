import java.util.NoSuchElementException;

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

    public void delete_first(){
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
    }

    public void delete(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if(index == 0){
            delete_first();
            return;
        }
        if(index == size-1){
            delete_last();
            return;
        }
        Node del_node = get(index-1);
        del_node.next = del_node.next.next;
        size--;
    }

    public void delete_last(){
        if(size <= 1){
            delete_first();
            return;
        }
        tail = get(size-2);
        tail.next = null;
        size--;
    }

    public void delete_val(int id){
        int index = find(id);
        delete(index);
    }
    
    public void delete_val(String item_name){
        int index = find(item_name);
        delete(index);
    }

    public void update(int quantity, int item_id){
        int index = find(item_id);
        Node temp = head;

        for(int i =0; i<index; i++){
            temp = temp.next;
        }
        temp.quantity = quantity;
    }

    public Node get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node temp = head;
        for(int i =0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public int find(int id){
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.item_id == id){
                return index;
            }
            temp = temp.next;
            index++;
        }
        throw new NoSuchElementException(id + " is not found");
    }

    public int find(String item_name){
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.item_name.equals(item_name)){
                return index;
            }
            temp = temp.next;
            index++;
        }
        throw new NoSuchElementException(item_name + " is not found");
    }

    public void display_price(){
        Node temp = head;
        int total = 0;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println(total);
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