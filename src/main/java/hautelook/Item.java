package hautelook;


public class Item {

  private String _itemName;
  private double _itemPrice;
  private int _itemWeight;

  public Item(String itemName, double itemPrice) {
	    _itemName = itemName;
	    _itemPrice = itemPrice;
  }
  
  public Item(String itemName, double itemPrice, int itemWeight) {
    _itemName = itemName;
    _itemPrice = itemPrice;
    _itemWeight = itemWeight;
  }

  public double getItemPrice() {
    return _itemPrice;
  }

  public String getItemName() {
    return _itemName;
  }
  
  public int getItemWeight() {
	  return _itemWeight;
  }

}
