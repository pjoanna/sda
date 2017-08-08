package pc;

/**
 * Created by RENT on 2017-08-08.
 */
public abstract class AbstractPCWithFactory {
    protected String name;
    protected COMPUTER_BRAND computerBrand;
    protected int cpuPower;
    protected double gpuPower;
    protected boolean isOverlocked;

    public AbstractPCWithFactory(String name, COMPUTER_BRAND computerBrand, int cpuPower, double gpuPower, boolean isOverlocked) {
        this.name = name;
        this.computerBrand = computerBrand;
        this.cpuPower = cpuPower;
        this.gpuPower = gpuPower;
        this.isOverlocked = isOverlocked;
    }

    public static AbstractPCWithFactory createApplePC1(){
        return new ApplePC("MAC1", COMPUTER_BRAND.APPLE, 40, 0.4, false);
    }

    public static AbstractPCWithFactory createApplePC2(){
        return new ApplePC("MAC2", COMPUTER_BRAND.APPLE, 99, 0.99, true);
    }

    public static AbstractPCWithFactory createAsusPC1(){
        return new AsusPC("asus1", COMPUTER_BRAND.ASUS, 40, 0.4, false);
    }

    public static AbstractPCWithFactory createAsusPC2(){
        return new AsusPC("asus2", COMPUTER_BRAND.ASUS, 99, 0.99, true);
    }
    public static AbstractPCWithFactory createSamsungPC1(){
        return new SamsungPC("SAMSUNG1", COMPUTER_BRAND.SAMSUNG, 40, 0.4, false);
    }

    public static AbstractPCWithFactory createSamsungPC2(){
        return new SamsungPC("SAMSUNG2", COMPUTER_BRAND.SAMSUNG, 99, 0.99, true);
    }

    public static AbstractPCWithFactory createHpPC1(){
        return new HpPC("HP1", COMPUTER_BRAND.HP, 40, 0.4, false);
    }

    public static AbstractPCWithFactory createHpPC2(){
        return new HpPC("HP2", COMPUTER_BRAND.HP, 99, 0.99, true);
    }

}
