import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-05.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Magazine magazine = new Magazine();
        Scanner scanner = new Scanner(System.in);
        String line;
        String command = "";
        List<Product> list = new ArrayList<>();

        menuOnStart();

        line = scanner.nextLine();
        while (!line.equals("quit")) {
            command = line.split(" ")[0];
            switch (command) {
                case "dodaj_produkt":
                    String name = line.split(" ")[1];
                    Double price = Double.parseDouble(line.split(" ")[2]);
                    ProductType productType = ProductType.valueOf(line.split(" ")[3]);
                    ProductClass productClass = ProductClass.valueOf(line.split(" ")[4]);
                    magazine.addProduct(name, price, productClass, productType);
                    magazine.saveToExcel();
                    break;
                case "wylistuj_typ":
                    ProductType productType1 = ProductType.valueOf(line.split(" ")[1]);
                    list = magazine.getByType(productType1);
                    // list = magazine.readDataFromExcel("out.xls");
//                    for (Product product : list) {
//                        if(product.getType().equals(productType1)){
//                            System.out.println(product.toString());
//                        }
//                    }
                    break;
                case "wylistuj_polka":
                    ProductClass productClass1 = ProductClass.valueOf(line.split(" ")[1]);
                    list = magazine.getByClass(productClass1);
                    //  list = magazine.readDataFromExcel("out.xls");
                    break;
                default:
                    break;
            }
            System.out.println("Podaj następną komendę");
            line = scanner.nextLine();
        }
        if (list.size() > 0) {
            System.out.println("wyświetlam");
            for (Product product : list) {
                System.out.println(product.toString());
            }
        }


    }

    private static void menuOnStart() {
        System.out.println("Wybierz: ");
        System.out.println("dodaj_produkt NAZWA_PRODUKTU CENA FOOD/ALCOHOL/INDUSTRIAL LOW/MID/HIGH");
        System.out.println("wylistuj_typ FOOD/ALCOHOL/INDUSTRIAL");
        System.out.println("wylistuj_polka LOW/MID/HIGH");
    }
}
