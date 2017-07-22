package zadania;

/**
 * Created by RENT on 2017-07-10.
 */
public class StringArrays {
    public static void main(String[] args) {
        String[] stringArray = {"Ala", "ma", "kota","a","kot","ma","Alę"};
        int totalLength = 0;

        for (int i = 0; i < stringArray.length; i++) {
            String assistantWord = stringArray[i];
                totalLength += assistantWord.length();
        }
        System.out.println(totalLength);


        double averageLength = 0;
        averageLength = (double)(totalLength)/stringArray.length;
        System.out.println("Średnia długość słowa to: "+averageLength);
    }




}
