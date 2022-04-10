public class VegetablesFruitsCompartment<T> implements  IBag<T>{
    private  T[] Compartment;
    private int currentVegetables_and_Fruits_weight;
    private int Vegetables_and_Fruits_count;
    private int current_compartment_capacity;
    private boolean initialized = false;
    private static final  int DEFAULT_COMPARTMENT_CAPACITY = 1000 ;
    private static final int max_compartment_capacity = 3000;

    public  VegetablesFruitsCompartment() {
        T[] tempCompartment = (T[]) new Object[DEFAULT_COMPARTMENT_CAPACITY];
        Compartment = tempCompartment;
        Vegetables_and_Fruits_count = 0;
        currentVegetables_and_Fruits_weight = 0;
        current_compartment_capacity = max_compartment_capacity-currentVegetables_and_Fruits_weight;
        initialized = true;
    }

    public int getCurrentVegetables_and_Fruits_weight() {
        return currentVegetables_and_Fruits_weight;
    }

    public int getCurrent_compartment_capacity() {
        return current_compartment_capacity;
    }

    @Override
    public boolean add(T newItem) {
        if(contains(newItem)&&!isFull()){
            if (((Item) newItem).getItem_name().equals("tomato" )){
                if (currentVegetables_and_Fruits_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[Vegetables_and_Fruits_count] = newItem;
                    currentVegetables_and_Fruits_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentVegetables_and_Fruits_weight;
                    Vegetables_and_Fruits_count++;
                    return true;
                }
                else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals("potato" )){
                if (currentVegetables_and_Fruits_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[Vegetables_and_Fruits_count] = newItem;
                    currentVegetables_and_Fruits_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentVegetables_and_Fruits_weight;
                    Vegetables_and_Fruits_count++;
                    return true;
                }
                else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals( "onion")){
                if (currentVegetables_and_Fruits_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[Vegetables_and_Fruits_count] = newItem;
                    currentVegetables_and_Fruits_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentVegetables_and_Fruits_weight;
                    Vegetables_and_Fruits_count++;
                    return true;
                }
                else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals( "banana")){
                if (currentVegetables_and_Fruits_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[Vegetables_and_Fruits_count] = newItem;
                    currentVegetables_and_Fruits_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentVegetables_and_Fruits_weight;
                    Vegetables_and_Fruits_count++;
                    return true;
                }
                else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals("strawberry")){
                if (currentVegetables_and_Fruits_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[Vegetables_and_Fruits_count] = newItem;
                    currentVegetables_and_Fruits_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentVegetables_and_Fruits_weight;
                    Vegetables_and_Fruits_count++;
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (Vegetables_and_Fruits_count== 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (currentVegetables_and_Fruits_weight == max_compartment_capacity){
            return true;
        }
        return false;
    }

    @Override
    public T removeByIndex(int index) {
        return null;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T remove(T item) {
        return null;
    }

    @Override
    public int getItemCount() {
        return Vegetables_and_Fruits_count;
    }

    @Override
    public int getIndexOf(T item) {
        return 0;
    }

    @Override
    public boolean contains(T item) {
            if (((Item) item).getItem_compartment().equals( "vegetables and fruits")) {
                return true;
            }
            else {
                return false;
        }
    }
    @Override
    public void displayItems() {
        System.out.println("Vegetables and Fruits: "+(current_compartment_capacity)+" grams");
    }

    @Override
    public void dump() {

    }

    @Override
    public boolean transferTo(IBag<T> targetBag, T item) {
        return false;
    }
}
