package zadania;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-10.
 */
public class SumOfPositionArray {

    public static void main(String[] args) {
        int sum = 0;
        int[] data = {1,3,5,8};
        double avg = 0;
        int multiply = 1;
        int strong = 1; //silnia
        int count;
        Scanner scanner = new Scanner(System.in);

        sum = getSum(sum, data);

        getAvg(sum, data);

        getMultiply(data, multiply);


        getStrong(strong);

        sumaCiagArytmetyczny();
        sumCiagGeometryczny();

        ileLiterWSlowie();


    }

    public static void ileLiterWSlowie() {
        int licznik = 0;
        String slowo = "Ala ma kota";

        for (int i = 0; i < slowo.length(); i++) {
            String slowoUpper = slowo.toUpperCase();
            if(slowoUpper.charAt(i) == 'A'){
                licznik += 1;
            }

        }
        System.out.println("licznik to: "+licznik);
    }

    public static void sumCiagGeometryczny() {
        int q = 3;
        int aGeo = 1;
        int n0 = 3;
        int sumaCiaguGeo = 0;

        for (int i = 0; i < n0; i++) {
            sumaCiaguGeo += aGeo;
            aGeo *= q;
        }
    }

    public static void sumaCiagArytmetyczny() {
        int sumaCiaguArytm = 0;
        int r = 2;
        int a = 1;
        int n = 4;


        for (int i = 0; i < n; i++) {
            sumaCiaguArytm += a;
            a += r;
        }
    }

    public static void getStrong(int strong) {
        int count;
        count = 4;
        for (int i = 0; i < count; i++) {
            strong *= (i+1);
        }
        System.out.println("Silnia z liczby "+count+" wynosi: "+strong);
    }

    public static void getMultiply(int[] data, int multiply) {
        for (int i = 0; i < data.length; i++) {
            multiply *= data[i];
        }
        System.out.println(multiply);
    }

    public static void getAvg(int sum, int[] data) {
        double avg;
        avg = (double)(sum)/data.length;
        System.out.println(avg);
    }

    private static int getSum(int sum, int[] data) {
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }
}
