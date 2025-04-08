public class Inventory_main {
    public static void main(String[] args) {
        Inventory_management list = new Inventory_management();

        list.insert_first("Lays", 6, 10, 2);
        list.insert_last("kurkure", 3, 10, 2);
        list.insert_first("biscuit", 10, 30, 3);
        list.insert_first("pen", 1, 10, 10);
        list.insert("mac", 1232, 100000, 1, 2);

        list.display();

    }
}