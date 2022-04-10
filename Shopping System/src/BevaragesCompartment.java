public class BevaragesCompartment<T> implements IBag<T> {
    private  T[] Compartment;
    private int currentBevarges_weight;
    private int bevarges_count;
    private int current_compartment_capacity;
    private boolean initialized = false;
    private static final  int DEFAULT_COMPARTMENT_CAPACITY = 1000 ;
    private static final int max_compartment_capacity = 4000;

    public  BevaragesCompartment() {
        T[] tempCompartment = (T[]) new Object[DEFAULT_COMPARTMENT_CAPACITY];
        Compartment = tempCompartment;
        bevarges_count = 0;
        currentBevarges_weight = 0;
        current_compartment_capacity = max_compartment_capacity-currentBevarges_weight;
        initialized = true;
    }
    public int getCurrent_compartment_capacity() {
        return current_compartment_capacity;
    }
    public int getCurrentBevarges_weight() {
        return currentBevarges_weight;
    }

    @Override
    public boolean add(T newItem) {
        if(contains(newItem)&&!isFull()){
            if (((Item) newItem).getItem_name().equals( "coffee" )){
                if (currentBevarges_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[bevarges_count] = newItem;
                    currentBevarges_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentBevarges_weight;
                    bevarges_count++;
                    return true;
                }
                else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals( "coke" )){
                if (currentBevarges_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[bevarges_count] = newItem;
                    currentBevarges_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentBevarges_weight;
                    bevarges_count++;
                    return true;
                }
                else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals( "juice")){
                if (currentBevarges_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[bevarges_count] = newItem;
                    currentBevarges_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentBevarges_weight;
                    bevarges_count++;
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
        if (bevarges_count== 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (currentBevarges_weight == max_compartment_capacity){
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
        return bevarges_count;
    }

    @Override
    public int getIndexOf(T item) {
        return 0;
    }

    @Override
    public boolean contains(T item) {
        if (((Item) item).getItem_compartment().equals("beverages")) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void displayItems() {
        System.out.println("Beverages: "+(current_compartment_capacity)+" grams");
    }

    @Override
    public void dump() {

    }

    @Override
    public boolean transferTo(IBag<T> targetBag, T item) {
        return false;
    }
}
