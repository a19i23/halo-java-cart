package hautelook;

import java.util.ArrayList;
/**
 * Created by bill on 4/10/17.
 */
public class Cart {
    private ArrayList<Item> itemsArray;
    private double subtotal;

    public Cart () {
      itemsArray = new ArrayList<Item>();
      subtotal = 0.0;
    }

    public double subtotal() {
        return subtotal;
    }

    public ArrayList<Item> getItemsInCart() {
       return itemsArray;
    }

    public void addItemToCart(Item item) {
       itemsArray.add(item);
       subtotal += item.getItemPrice();
    }
    
    public int getNumberOfItemsInCartNamed(String itemName) {
    	int quantityOfItemsFoundWithName = 0;
    		for (Item item : itemsArray) {
    			if (item.getItemName().equals(itemName)) {
    				quantityOfItemsFoundWithName++;
    			}
    		}
    		return quantityOfItemsFoundWithName;
    }
}
