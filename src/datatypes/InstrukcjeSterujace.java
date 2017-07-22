package datatypes;

import java.util.Scanner;

public class InstrukcjeSterujace {
    public static void buzka(boolean b){
        if(b){
            System.out.println(":)");
        }else{
            System.out.println(":(");
        }
    }
    public static void main(String[] args) {
        boolean b1 = (false == false);
        boolean b2 = (false != true);
        boolean b3 = (!true);
        boolean b4 = (2 > 4);
        boolean b5 = (3 < 5);
        boolean b6 = (3 == 3 && 3 == 4);
        boolean b7 = (3 != 5 || 3 == 5);
        boolean b8 = ((2+4)>(1+3));
        boolean b9 = ("cos".equals("cos")); //takie same - równe wartości
        boolean b10 = ("cos" == "cos"); //to samo - identyczne, dotyczy tylko obiektów

        char a ='a';
        int i = 97;
        boolean ai1 = (a==i); //true

        buzka(b1);
        buzka(b2);
        buzka(b3);
        buzka(b4);
        buzka(b5);
        buzka(b6);
        buzka(b7);
        buzka(b8);
        buzka(b9);
        buzka(b10);

//        if(b1){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }
//        if(b2){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }
//        if(b3){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }
//        if(b4){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }
//        if(b5){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }
//        if(b6){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }
//        if(b7){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }
//        if(b8){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }
//        if(b9){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }
//        if(b10){
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }

        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        boolean b;
        if (i1%3==0){
            b = (i1%3==0);
            System.out.println(b);
        }else{
            b = (i1%5==0);
            System.out.println(b);
        }



    }

}
