import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-08-05.
 */
public class Magazine {
    private final Map<ProductClass, List<Product>> productMap = new HashMap<>();

    private List<Product> midProducts (){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(12.0,"food1", ProductClass.MID, ProductType.FOOD));
        productList.add(new Product(13.0,"food2", ProductClass.MID, ProductType.INDUSTRIAL));
        productList.add(new Product(14.0,"food3", ProductClass.MID, ProductType.FOOD));
        productList.add(new Product(15.0,"food4", ProductClass.MID, ProductType.INDUSTRIAL));
        productList.add(new Product(16.0,"food5", ProductClass.MID, ProductType.ALCOHOL));
        return productList;
    }
    private List<Product> lowProducts (){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(12.0,"alcohol0", ProductClass.LOW, ProductType.ALCOHOL));
        productList.add(new Product(13.0,"alcohol1", ProductClass.LOW, ProductType.FOOD));
        productList.add(new Product(14.0,"alcohol2", ProductClass.LOW, ProductType.ALCOHOL));
        productList.add(new Product(15.0,"alcohol3", ProductClass.LOW, ProductType.INDUSTRIAL));
        productList.add(new Product(16.0,"alcohol4", ProductClass.LOW, ProductType.FOOD));
        return productList;
    }

    private List<Product> highProducts (){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(12.0,"industrial11", ProductClass.HIGH, ProductType.INDUSTRIAL));
        productList.add(new Product(13.0,"industrial110", ProductClass.HIGH, ProductType.ALCOHOL));
        productList.add(new Product(14.0,"industrial112", ProductClass.HIGH, ProductType.INDUSTRIAL));
        productList.add(new Product(15.0,"industrial1", ProductClass.HIGH, ProductType.ALCOHOL));
        productList.add(new Product(16.0,"industrial2", ProductClass.HIGH, ProductType.FOOD));
        return productList;
    }
    public void fillMagazine(){
        productMap.put(ProductClass.HIGH, highProducts());
        productMap.put(ProductClass.MID, midProducts());
        productMap.put(ProductClass.LOW, lowProducts());
    }



}
