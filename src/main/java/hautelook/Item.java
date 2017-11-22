package hautelook;


public class Item {

  private String _itemName;
  private double _itemPrice;

  public Item(String itemName, double itemPrice) {
    _itemName = itemName;
    _itemPrice = itemPrice;
  }

  public double getItemPrice() {
    return _itemPrice;
  }

  public String getItemName() {
    return _itemName;
  }

}
