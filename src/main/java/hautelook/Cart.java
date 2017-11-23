package hautelook;

import java.util.ArrayList;
/**
 * Created by bill on 4/10/17.
 */
public class Cart {
    private ArrayList<Item> itemsArray;
    private int subtotal;
    private int weightTotal;
    private int numberOfItemsTenPoundsOrMore;
    private int total;
    private int discountAmount;

    public Cart () {
      itemsArray = new ArrayList<Item>();
      subtotal = 0;
      total = 0;
      weightTotal = 0;
      numberOfItemsTenPoundsOrMore = 0;
      discountAmount = 0;
    }
    public void processDiscount() {
    	if (discountAmount != 0) {
			int discountedAmount = subtotal * discountAmount/100;
    		subtotal = subtotal - discountedAmount;
		}
    }
    public double subtotal() {
        return subtotal;
    }
    
    public double total() {		
		return total;
    }
    
    public void calculateShipping() {
    		getTotalWeight();
		
		//calculate shipping
		if (subtotal < 100) {
			if (weightTotal < 10) {
				total = subtotal + 5;	//flat rate $5 shipping
			} else if (itemsArray.size() != numberOfItemsTenPoundsOrMore){
				total = subtotal + 5 + numberOfItemsTenPoundsOrMore * 20;
			} else {
				total = subtotal + numberOfItemsTenPoundsOrMore * 20;
			}
			
		} else if (subtotal > 100) {
			if (numberOfItemsTenPoundsOrMore == 0) { 
				total = subtotal;	//free shipping
			} else {
				total = subtotal + numberOfItemsTenPoundsOrMore * 20;
			}			
		}
    }

    private void getTotalWeight() {   	
		for (Item item : itemsArray) {
			int itemWeight = item.getItemWeight();
			weightTotal += itemWeight;
			if (itemWeight >=10) {
				numberOfItemsTenPoundsOrMore++;
			}
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
    		discountAmount = percentDiscount;  		
    }
    
}
