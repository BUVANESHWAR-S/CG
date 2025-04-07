public class student_ll {

    private Node head;
    private Node tail;
    private int size;

    public student_ll(){
        this.size = 0;
    }

    public void insert_first(String Name, int Roll_num, int age, char grade){
        Node node = new Node(Name, Roll_num, age, grade);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insert(String Name, int Roll_num, int age, char grade, int index){
        if(index == 0){
            insert_first(Name, Roll_num, age, grade);
            return;
        }
        else if(index == size){
            insert_last(Name, Roll_num, age, grade);
            return;
        }
        else if(index > size){
            System.out.println("Index out of Range");
            return;
        }
        Node temp = head;
        for(int i = 1; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node(Name, Roll_num, age, grade);
        node.next = temp.next;
        temp.next = node;
        size++;

    }

    public void insert_last(String Name, int Roll_num, int age, char grade){
        if(tail == null){
            insert_first(Name, Roll_num, age, grade);
            return;
        }
        Node node = new Node(Name, Roll_num, age, grade);
        tail.next = node;
        tail = node;
        size++;
        
    }

    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.Name + " "+ temp.Roll_num +" "+ temp.age);
            temp = temp.next;
        }
        System.out.println("done");
    }

    private class Node{
        private int Roll_num, age;
        String Name;
        char grade;
        private Node next;

        public Node(String Name, int Roll_num, int age, char grade){
            this.Name = Name;
            this.Roll_num = Roll_num;
            this.age = age;
            this.grade = grade;
        }
    }
    
}