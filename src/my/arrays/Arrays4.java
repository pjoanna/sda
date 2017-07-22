package my.arrays;

/**
 * Created by RENT on 2017-07-08.
 */
public class Arrays4 {
    public static boolean compareArrays(int tab1[], int tab2[]){
        boolean b = false;
        for (int i = 0; i < tab1.length; i++){
            if(tab1.length == tab2.length) {
                if (tab1[i] == tab2[i]) {
                    b = true;
                } else {
                    b = false;
                    break;
                }
            } else {
               b = false;
               break;
            }
        }

        return b;
    }
    public static void main(String[] args) {
        int[] numbers1 = {1,2,3,4,5,6,7};
        int[] numbers2 = {1,2,3,4,5,6,7};
        if(compareArrays(numbers1,numbers2) == false){
            System.out.println("Podane tablice nie są równe");
        }else{
            System.out.println("Podane tablice są równe");
        }
    }
}
