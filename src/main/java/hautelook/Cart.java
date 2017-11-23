package hautelook;

import java.util.ArrayList;
/**
 * Created by bill on 4/10/17.
 */
public class Cart {
    private ArrayList<Item> itemsArray;
    private int subtotal;
    private int weightTotal;

    public Cart () {
      itemsArray = new ArrayList<Item>();
      subtotal = 0;
    }

    public double subtotal() {
    		getTotalWeight();
    		
    		//calculate shipping
    		if (subtotal < 100) {
    			if (weightTotal < 10) {
    				subtotal += 5;
    			} else {
    				subtotal += itemsArray.size() * 20;
    			}
    		}
        return subtotal;
    }

    private void getTotalWeight() {
		for (Item item : itemsArray) {
			weightTotal += item.getItemWeight();
		}	
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
    
    public void applyDiscount(int percentDiscount) {
    		int discountedAmount = subtotal * percentDiscount/100;
    		subtotal = subtotal - discountedAmount;  		
    }
    
}
