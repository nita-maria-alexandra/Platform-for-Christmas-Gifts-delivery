package data;

import enums.Category;

public class GiftInputData {
    private final String productName;

    private final double price;

    private final Category category;

    private int quantity;

    public GiftInputData() {
        this.productName = null;
        this.category = null;
        this.price = 0;
        this.quantity = 0;
    }

    public GiftInputData(final GiftInputData giftInputData) {
        this.productName = giftInputData.getProductName();
        this.price = giftInputData.getPrice();
        this.category = giftInputData.getCategory();
        this.quantity = giftInputData.getQuantity();
    }

    /**
     *
     * @return returneaza @productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @return returneaza @price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return returneaza @category
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @return ...
     */
    @com.fasterxml.jackson.annotation.JsonIgnore
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity ...
     */
    @com.fasterxml.jackson.annotation.JsonProperty
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * Suprascrie metoda toString()
     */
    @Override
    public String toString() {
        return  "productName='"
                + productName + '\''
                + ", price=" + price
                + ", category=" + category
                + '}';
    }
}
