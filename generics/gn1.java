import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
    private String Item_name;

    public WarehouseItem(String Item_name){
        this.Item_name = Item_name;
    }
    public String getname(){
        return Item_name;
    }
    public abstract void display();
}

class Electronics extends WarehouseItem{
    private int Warranty_mnths;

    public Electronics(String Item_name, int Warranty_mnths){
        super(Item_name);
        this.Warranty_mnths = Warranty_mnths;
    }
    @Override
    public void display(){
        System.out.println("Electronics: "+getname()+"\nWarranty: "+Warranty_mnths);
    }
}

class Groceries extends WarehouseItem{
    private String Expiry_date;

    public Groceries(String Item_name, String Expiry_date){
        super(Item_name);
        this. Expiry_date = Expiry_date;

    }
    @Override
    public void display(){
        System.out.println("Grocery: "+getname()+"\nExpiry Date: "+Expiry_date);
    }
}

class Furniture extends WarehouseItem{
    private String material;

    public Furniture(String Item_name, String material){
        super(Item_name);
        this.material = material;
    }

    public void display(){
        System.out.println("Furniture: "+getname()+"\nmaterial: "+material);
    }
}

class Storage<T extends WarehouseItem>{
    private List<T> item = new ArrayList<>();

    public void add(T item_name){
        item.add(item_name);
    }

    public List<T> get_item(){
        return item;
    }

}

class WarehouseUtils{
    public static void displayAllitems(List<? extends WarehouseItem> items){
        for(WarehouseItem item : items){
            item.display();
        }
    }
}

public class gn1{
    public static void main(String[] args) {
        Storage<Electronics> elec = new Storage<>();
        elec.add(new Electronics("Fan", 4));
        elec.add(new Electronics("Light", 5));
        elec.add(new Electronics("Tv", 21));

        Storage<Furniture> Fur = new Storage<>();
        Fur.add(new Furniture("chair", "wood"));
        Fur.add(new Furniture("bench", "Plastic"));

        Storage<Groceries> groc = new Storage<>();
        groc.add(new Groceries("pure magic", "12-01-2026"));
        groc.add(new Groceries("Dark Fantasy", "12-01-2026"));

        System.out.println("Electronics");
        
        WarehouseUtils.displayAllitems(elec.get_item());

        System.out.println("Groceries");
        WarehouseUtils.displayAllitems(groc.get_item());

        System.out.println("Furniture");
        WarehouseUtils.displayAllitems(Fur.get_item());
    }
}