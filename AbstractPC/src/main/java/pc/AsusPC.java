package pc;

/**
 * Created by RENT on 2017-08-08.
 */
class AsusPC extends AbstractPCWithFactory {
    public AsusPC(String name, COMPUTER_BRAND computerBrand, int cpuPower, double gpuPower, boolean isOverlocked) {
        super(name, computerBrand, cpuPower, gpuPower, isOverlocked);
    }

}
