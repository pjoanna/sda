package instrument;

/**
 * Created by RENT on 2017-07-13.
 */
public class Orchestra {
    Keyboard keyboard = new Keyboard("Keyboard Yamaha", 65);
    Harp harp = new Harp("Harfa");
    Guitar guitar = new Guitar("gitarka");
    Violin violin = new Violin("skrzypki");
    Instrument[] instruments = {keyboard, harp, guitar, violin};

    public void introduce(){
        for (Instrument instrument : instruments) {
            instrument.introduce();
            if(instrument instanceof Keyboard){
                Keyboard k = (Keyboard) instrument;
                System.out.println(k.getKeys());
            }

        }

    }

    public void play(){
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }

    public static void main(String[] args) {
        Orchestra orchestra = new Orchestra();
        orchestra.introduce();
        orchestra.play();


    }
}
