import java.lang.reflect.Array;
import java.util.Arrays;

public class ShoppingBasket<T> implements  IBag<T> {
    private T[] basket;
    private int currentItemCount;
    private int currentWeight;
    private boolean initialized = false;
    private static final  int DEFAULT_BASKET_CAPACITY = 10 ;
    private static final int max_basket_capacity = 2000;


    public ShoppingBasket(){
        T[] tempBasket= (T[]) new Object[DEFAULT_BASKET_CAPACITY];
        basket = tempBasket;
        currentItemCount = 0;
        currentWeight = 0;
        initialized = true;
    }

    public int getCurrentItemCount() {
        return currentItemCount;
    }

    public void setCurrentItemCount(int currentItemCount) {
        this.currentItemCount = currentItemCount;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public T[] getBasket() {
        return basket;
    }

    public void setBasket(T[] basket) {
        this.basket = basket;
    }

    public boolean add(T newItem) {
        if (!isFull()) {
            basket[currentItemCount] =  newItem;
            currentWeight += ((Item) newItem).getItem_weight();
            currentItemCount ++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        if (currentItemCount == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if(currentWeight == max_basket_capacity){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public T removeByIndex(int index) {
        return null;
    }

    @Override
    public T remove() {
        T result =null;
        if(currentItemCount>0){
            result=
                    basket[currentItemCount-1];
            basket[currentItemCount-1] =null;
            currentItemCount --;

        }
        return result;
    }

    @Override
    public T remove(Object item) {
        return null;
    }

    @Override
    public int getItemCount() {
        return basket.length;
    }

    @Override
    public int getIndexOf(Object item) {
        for (int i = 0;i < basket.length;i++) {
            if (i == 0&& basket[0] == item){
                return i;
            }

        }
    return -1;
    }

    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < basket.length; i++) {
            if (i == 0 && basket[0] == item) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void displayItems() {
        String x = "Basket contains: ";
       for (int i=0; i<currentItemCount;i++){
           if (i+1 == currentItemCount) {
               x += basket[i];
           }
            else {
                x += basket[i]+",";
           }
       }
        System.out.println(x);
    }

    @Override
    public void dump() {
        while (!isEmpty()){
            remove();
        }
    currentWeight = 0;

    }

    @Override
    public boolean transferTo(IBag<T> targetBag, T item) {
        if (targetBag.add(item)){
            return true;
        }
        else {
            String x = ((Item) item).getItem_name();
            return false;
        }
    }
}