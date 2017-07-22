package methods;
//by Adrian
public class Shapes {

    public static void main(String[] args) {
//        printRect(2,4);
//        printRect(3,3);
//        printRect(4,2);
//        printRect(1,1);
        //printTriangle(4);
        printRightTriangle(5);
    }

    public static void printTriangle(int height){
        for(int i=1;i<=height;i++){
            printLine(i);
        }
    }

    public static void printRightTriangle(int height){
        for(int i=1;i<=height;i++){
            printSpaces(height-i);
            printLine(i);
        }
    }

    public static void printRect(int a, int b) {
        for(int i = 0;i<a;i++){
            printLine(b);
        }
    }

    public static void printTriangle(int a,int b) {
        for (int i = 1; i <=a; i++) {
            printLine((b*i+a-1)/a);
        }
    }

    private static void printLine(int length) {
        for(int j = 0;j<length;j++){
            System.out.print("*");
        }
        System.out.println();
    }

    private static void printSpaces(int length) {
        for(int j = 0;j<length;j++){
            System.out.print(" ");
        }
    }
    public static void obramowanie(int a, int b){
        for (int i = 0; i < a; i++){
            if (i==0){
                printLine(b);
            }
            else if (i<a-1){
                System.out.print("*");
                printSpaces(b-2);
                System.out.println("*");
            }
            else {
                printLine(b);
            }
        }
    }
}
