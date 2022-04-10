public class MeatsCompartment<T> implements  IBag<T>{
    private  T[] Compartment;
    private int currentMeat_weight;
    private int meat_count;
    private int current_compartment_capacity;
    private boolean initialized = false;
    private static final  int DEFAULT_COMPARTMENT_CAPACITY = 1000 ;
    private static final int max_compartment_capacity = 5000;

    public  MeatsCompartment() {
        T[] tempCompartment = (T[]) new Object[DEFAULT_COMPARTMENT_CAPACITY];
        Compartment = tempCompartment;
        meat_count= 0;
        currentMeat_weight = 0;
        current_compartment_capacity = max_compartment_capacity-currentMeat_weight;
        initialized = true;
    }
    public int getCurrentMeat_weight() {
        return currentMeat_weight;
    }

    public int getCurrent_compartment_capacity() {
        return current_compartment_capacity;
    }

    @Override
    public boolean add(T newItem) {
        if(contains(newItem)&&!isFull()) {
            if (((Item) newItem).getItem_name().equals("chicken")) {
                if (currentMeat_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[meat_count] = newItem;
                    currentMeat_weight += ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentMeat_weight;
                    meat_count++;
                    return true;
                } else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals("beef")) {
                if (currentMeat_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[meat_count] = newItem;
                    currentMeat_weight += ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentMeat_weight;
                    meat_count++;
                    return true;
                } else {
                    return false;
                }
            }
            if (((Item) newItem).getItem_name().equals("fish")) {
                if (currentMeat_weight <= max_compartment_capacity- ((Item) newItem).getItem_weight()) {
                    Compartment[meat_count] = newItem;
                    currentMeat_weight += ((Item) newItem).getItem_weight();
                    current_compartment_capacity = max_compartment_capacity-currentMeat_weight;
                    meat_count++;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (currentMeat_weight == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (currentMeat_weight == max_compartment_capacity){
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
        return meat_count;
    }

    @Override
    public int getIndexOf(T item) {
        return 0;
    }

    @Override
    public boolean contains(T item) {
        if (((Item) item).getItem_compartment().equals( "meats")) {
            return true;
        }
        else {
            return false;

        }
    }

    @Override
    public void displayItems() {
        System.out.println("Meats: "+(current_compartment_capacity)+" grams");
    }

    @Override
    public void dump() {

    }

    @Override
    public boolean transferTo(IBag<T> targetBag, T item) {
        return false;
    }
}
