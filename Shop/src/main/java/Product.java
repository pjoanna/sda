/**
 * Created by RENT on 2017-08-05.
 */
public class Product {
    private Double price;
    private String name;
    private ProductClass productClass;
    private ProductType productType;

    public Product(String name, Double price, ProductClass productClass, ProductType productType) {
        this.price = price;
        this.name = name;
        this.productClass = productClass;
        this.productType = productType;
    }

    public ProductClass getProductClass() {
        return productClass;
    }
    public ProductType getType() {
        return productType;
    }

    @Override
    public String toString() {
        return name + "::" + price + "::" + productType + "::" + productClass;

    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
