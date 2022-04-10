public class SnacksCompartment<T> implements IBag<T> {
    private  T[] Compartment;
    private int currentSnacks_weight = 0;
    private int snacks_count = 0;
    private  int current_compartment_capacity;
    private boolean initialized = false;
    private static final  int DEFAULT_COMPARTMENT_CAPACITY = 1000 ;
    private static final int max_compartment_capacity = 2000;

    public  SnacksCompartment() {
        T[] tempCompartment = (T[]) new Object[DEFAULT_COMPARTMENT_CAPACITY];
        Compartment = tempCompartment;
        snacks_count = 0;
        currentSnacks_weight = 0;
        current_compartment_capacity = max_compartment_capacity - currentSnacks_weight;
        initialized = true;
    }

    public int getCurrentSnacks_weight() {
        return currentSnacks_weight;
    }

    public int getCurrent_compartment_capacity() {
        return current_compartment_capacity;
    }

    @Override
    public boolean add(T newItem) {
        if(contains(newItem)&&!isFull()){
            if (((Item) newItem).getItem_name().equals("chocolate" )){
                if (currentSnacks_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[snacks_count] = newItem;
                    currentSnacks_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity - currentSnacks_weight;
                    snacks_count++;
                    return true;
                }
                else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals("cake" )){
                if (currentSnacks_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[snacks_count] = newItem;
                    currentSnacks_weight+= ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity - currentSnacks_weight;
                    snacks_count++;
                    return true;
                }
                else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals( "nuts")){
                if (currentSnacks_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[snacks_count] = newItem;
                    currentSnacks_weight += ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity - currentSnacks_weight;
                    snacks_count++;
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
        if (currentSnacks_weight == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (currentSnacks_weight == max_compartment_capacity){
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
        return snacks_count;
    }

    @Override
    public int getIndexOf(T item) {
        return 0;
    }

    @Override
    public boolean contains(T item) {
        if (((Item) item).getItem_compartment().equals( "snacks")) {
            return true;
        }
        else {
            return false;

        }
    }

    @Override
    public void displayItems() {
        System.out.println("Snacks: "+(current_compartment_capacity)+" grams");
    }

    @Override
    public void dump() {

    }

    @Override
    public boolean transferTo(IBag<T> targetBag, T item) {
        return false;
    }
}
