package day1_4.class_;

public class student_ll {

    private Node head;
    private Node tail;

    private class Node{
        private int Roll_num, age;
        String Name;
        char grade;

        public Node(String Name, int Roll_num, int age, char grade){
            this.Name = Name;
            this.Roll_num = Roll_num;
            this.age = age;
            this.grade = grade;
        }
    }
    
}