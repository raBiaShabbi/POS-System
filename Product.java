
package POS;

/**
 *
 * @author Dell
 */
public class Product {
    private int productId;
    private String productName;
    private double retailPrice;
    private double wholesalePrice;
    private int stock;
    private boolean availabilty;

    public Product() {
    }

    public Product(int productId, String productName, double retailPrice, double wholesalePrice, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.retailPrice = retailPrice;
        this.wholesalePrice = wholesalePrice;
        this.stock = stock;
    }

    public Product(int productId, double retailPrice) {
        this.productId = productId;
        this.retailPrice = retailPrice;
    }
    
    

    public Product(int productId, String productName, double retailPrice, double wholesalePrice, int stock, boolean availabilty) {
        this.productId = productId;
        this.productName = productName;
        this.retailPrice = retailPrice;
        this.wholesalePrice = wholesalePrice;
        this.stock = stock;
        this.availabilty = availabilty;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isAvailabilty() {
        return availabilty;
    }

    public void setAvailabilty(boolean availabilty) {
        this.availabilty = availabilty;
    }
    
    
}
