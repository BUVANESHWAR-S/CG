class SL1 {
    public static void main(String[] args) {
        student_ll std_list = new student_ll();
        std_list.insert_first("Buvaneshwar", 1232, 21, 'A');
        std_list.insert_last("Karun", 1233, 21, 'A');
        std_list.insert_first("Dina", 1234, 20, 'O');
        std_list.insert_first("Jawa", 1235, 21, 'A');
        std_list.insert("Mukkesh", 1236, 20, 'A', 2);


        std_list.display();
    }
    
}