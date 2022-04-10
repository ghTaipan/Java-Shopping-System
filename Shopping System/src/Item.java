public class Item {
    private  String item_name;
    private String item_compartment;
    private int item_weight;

    public Item(String item_name, String item_compartment, int item_weight) {
        this.item_name = item_name;
        this.item_compartment = item_compartment;
        this.item_weight = item_weight;
    }
    // Get name of the item and return Item_name.
    public String getItem_name() {
        return item_name;
    }
    //Call the method to  set name of the item.
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    // Get compartment of the item and return Item_compartment.
    public String getItem_compartment() {
        return item_compartment;
    }
    //Call the method to  set compartment of the item.
    public void setItem_compartment(String item_compartment) {
        this.item_compartment = item_compartment;
    }
    // Get weight of the item and return Item_weight.
    public int getItem_weight() {
        return item_weight;
    }
    //Call the method to  set weight of the item.
    public void setItem_weight(int item_weight) {
        this.item_weight = item_weight;
    }

    public String toString(){
        return item_name;
    }
    public boolean equals(Object obj){
        return false;
    }


}
