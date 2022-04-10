import java.lang.reflect.Array;
import java.util.Scanner;

public class ShoppingApp {
    public static Object createItem(int i){
        String name = "";
        String compartment = "";
        int weight = 0;
        FileIO val = new FileIO();
        for( String j:val.readValues("inventory.txt")[i-1]) {
            if (j.equals(val.readValues("inventory.txt")[i-1][0])) {
                name = j;
            }
            else if(j.equals(val.readValues("inventory.txt")[i-1][1])){
                compartment = j;
            }
            else if(j.equals(val.readValues("inventory.txt")[i-1][2])){
                weight = Integer.parseInt(j);
            }
        }
        Item item = new Item(name,compartment,weight);
        return item;
    }
    public static int weight(int i ){
        int weight = 0;
        FileIO val = new FileIO();
        for( String j:val.readValues("inventory.txt")[i-1]) {
            if (j.equals(val.readValues("inventory.txt")[i-1][2])) {
                weight = Integer.parseInt(j);
            }
        }
        return weight;
    }
    public static void main(String[] args) {
        FileIO fileIO = new FileIO();
        String[][] file = fileIO.readValues("inventory.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The Shopping App!");
        ShoppingBasket basket = new ShoppingBasket();
        VegetablesFruitsCompartment VandF  = new VegetablesFruitsCompartment();
        MeatsCompartment M = new MeatsCompartment();
        SnacksCompartment S = new SnacksCompartment();
        BevaragesCompartment B  = new BevaragesCompartment();
        while(true) {
            int x; //main options
            int y; //shopping options
            int z; // item to select
            int a; // to control current capacity of basket
            if (VandF.getCurrent_compartment_capacity() < 500 && M.getCurrent_compartment_capacity() < 500 && B.getCurrent_compartment_capacity() < 250 &&
                    S.getCurrent_compartment_capacity() < 250) {
                System.out.println("You can't add anymore item to compartments!!");
                System.out.println("You are exiting the app now...");
                break;
            }
            System.out.println("Please select an option:");
            System.out.println("[1]Go to shopping\n[2]See the status of the fridge\n[3]Exit");
            x = scanner.nextInt();

            if (x == 1) {
                while (true) {
                    System.out.println("Please select an option:");
                    System.out.println("[1]Add an item to the basket\n[2]See the basket\n[3]Finish shopping");
                    y = scanner.nextInt();
                    if (y == 1) {
                        System.out.println("Please select an item:");

                        for (int i = 0; i < file.length; i++) {
                            System.out.println("[" + (i + 1) + "]" + file[i][0]);
                        }

                        z = scanner.nextInt();
                        a = weight(z);
                        if (!basket.isFull() && basket.getCurrentWeight() <= 1750 && basket.getCurrentWeight()+a<=2000) {
                            basket.add(createItem(z));
                            System.out.println(createItem(z)+ " is added to the basket");
                            if (basket.isFull() && basket.getCurrentWeight() > 1750) {
                                System.out.println("Basket is full now");
                                System.out.println("Shopping is finished and going to fill the fridge\nThe fridge is filled");
                                for (int i = 0; i < (basket.getCurrentItemCount()); i++) {
                                    if (basket.transferTo(VandF, basket.getBasket()[i])) {

                                    } else if (basket.transferTo(M, basket.getBasket()[i])) {

                                    } else if (basket.transferTo(B, basket.getBasket()[i])) {

                                    } else if (basket.transferTo(S, basket.getBasket()[i])) {

                                    } else {
                                        System.out.println(basket.getBasket()[i] + " cannot be added to the fridge");
                                    }
                                }
                                basket.dump();
                                break;
                            } else if (!basket.isFull() && basket.getCurrentWeight() > 1750) {
                                System.out.println("You cannot add any more items to the basket");
                                System.out.println("Shopping is finished and going to fill the fridge\nThe fridge is filled");
                                for (int i = 0; i < (basket.getCurrentItemCount()); i++) {
                                    if (basket.transferTo(VandF, basket.getBasket()[i])) {

                                    } else if (basket.transferTo(M, basket.getBasket()[i])) {

                                    } else if (basket.transferTo(B, basket.getBasket()[i])) {

                                    } else if (basket.transferTo(S, basket.getBasket()[i])) {
                                    } else {
                                        System.out.println(basket.getBasket()[i] + " couldn’t be added to the fridge");
                                    }
                                }
                                basket.dump();
                                break;
                            }
                        }
                        else {
                            System.out.println("There is no space for "+createItem(z));
                            String recommended = "";
                            String recommended1 = "";
                            for (int i = 0; i < file.length; i++) {
                                int file_int = Integer.parseInt(file[i][2]);
                                if(file_int+basket.getCurrentWeight()<=2000){
                                    recommended += file[i][0]+",";
                                }
                            }
                            for(int j =0;j<recommended.length()-1;j++){
                                recommended1 += recommended.charAt(j);
                            }
                            System.out.println("The items that you can sellect: " +recommended1+"\nPlease sellect one of them..!");
                        }
                    } else if (y == 2) {
                        basket.displayItems();
                    } else if (y == 3) {
                        System.out.println("Shopping is finished and going to fill the fridge\nThe fridge is filled");
                        for (int i = 0; i < (basket.getCurrentItemCount()); i++) {
                            if (basket.transferTo(VandF, basket.getBasket()[i])) {

                            } else if (basket.transferTo(M, basket.getBasket()[i])) {

                            } else if (basket.transferTo(B, basket.getBasket()[i])) {

                            } else if (basket.transferTo(S, basket.getBasket()[i])) {
                            } else {
                                System.out.println(basket.getBasket()[i] + " cannot be added to the fridge");
                            }
                        }
                        basket.dump();
                        break;
                    } else {
                        System.out.println("Please select a valid option");
                    }
                }
            } else if (x == 2) {
                System.out.println("Remaining capacities of each compartments:");
                VandF.displayItems();
                M.displayItems();
                B.displayItems();
                S.displayItems();
            } else if (x == 3) {
                System.out.println("You are exiting the app now...");
                break;
            } else {
                System.out.println("Please select a valid option");
            }
        }
    }
}


