import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-08-05.
 */
public class Magazine {
    private Map<ProductClass, List<Product>> map = new HashMap<>();
//    private List<Product> list = new LinkedList<>();

    public void addProduct(String name, Double price, ProductClass productClass, ProductType type) {
        Product product = new Product(name, price, productClass, type);

        if (map.containsKey(productClass)) {
            List<Product> listOfClass = map.get(productClass);
            listOfClass.add(product);
            map.put(productClass, listOfClass);
        } else {
            List<Product> newProductList = new LinkedList<>();
            newProductList.add(product);
            map.put(productClass, newProductList);
        }
    }

    public List<Product> getByClass(ProductClass productClass) {
        return map.get(productClass);
    }

    public List<Product> getByType(ProductType productType) {
        List<Product> filteredProducts = new LinkedList<>();
        for (List<Product> productClassList : map.values()) {
            for (Product product : productClassList) {
                if (product.getType() == productType) {
                    filteredProducts.add(product);
                }
            }
        }
        return filteredProducts;
    }

    public void saveToExcel() throws IOException {
        String fileName = "out.xls";
        Workbook workbook = null;

        workbook = getWorkbook(fileName, workbook);

        addRows(workbook);
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.close();
    }

    private void addRows(Workbook workbook) {
        Sheet sheet = workbook.createSheet("Products");
        int rowNumber = 0;
        for (List<Product> productClassList : map.values()) {
            for (Product product : productClassList) {
                Row r = sheet.createRow(rowNumber);
                Cell c1 = r.createCell(0);
                c1.setCellValue(product.getName());
                Cell c2 = r.createCell(1);
                c2.setCellValue(product.getPrice());
                Cell c3 = r.createCell(2);
                c3.setCellValue(product.getType().toString());
                Cell c4 = r.createCell(3);

                c4.setCellValue(product.getProductClass().toString());
                rowNumber++;
            }
        }
    }

    private Workbook getWorkbook(String fileName, Workbook workbook) {
        if (fileName.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (fileName.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        }
        return workbook;
    }

    public List<Product> readDataFromExcel(String fileName) {
        List<Product> products = new ArrayList<Product>();

        try {
            FileInputStream fis = new FileInputStream(fileName);
            Workbook workbook = null;
            workbook = getWorkbook(fileName, fis, workbook);
            readRowsFromFile(products, workbook);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private void readRowsFromFile(List<Product> products, Workbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();

        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                String name = "";
                Double price = 0.0;
                ProductClass productClass;
                ProductType productType;

                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    name = getNameFromFile(cellIterator);
                    price = getPriceFromFile(cellIterator);
                    productType = getProductTypeFromFile(cellIterator);
                    productClass = getProductClassFromFile(cellIterator);
                    Product product = new Product(name, price, productClass, productType);
                    products.add(product);
                }
            }
        }
    }

    private ProductClass getProductClassFromFile(Iterator<Cell> cellIterator) {
        ProductClass productClass;
        Cell cellType = cellIterator.next();
        productClass = ProductClass.valueOf(cellType.getStringCellValue());
        return productClass;
    }

    private ProductType getProductTypeFromFile(Iterator<Cell> cellIterator) {
        ProductType productType;
        Cell cellClass = cellIterator.next();
        productType = ProductType.valueOf(cellClass.getStringCellValue());
        return productType;
    }

    private Double getPriceFromFile(Iterator<Cell> cellIterator) {
        Double price;
        Cell cellPrice = cellIterator.next();
        price = cellPrice.getNumericCellValue();
        return price;
    }

    private String getNameFromFile(Iterator<Cell> cellIterator) {
        String name;
        Cell cellName = cellIterator.next();
        name = cellName.getStringCellValue();
        return name;
    }

    private Workbook getWorkbook(String fileName, FileInputStream fis, Workbook workbook) throws IOException {
        if (fileName.toLowerCase().endsWith("xlsx")) {
            workbook = new XSSFWorkbook(fis);
        } else if (fileName.toLowerCase().endsWith("xls")) {
            workbook = new HSSFWorkbook(fis);
        }
        return workbook;
    }
}
