/**
 * Created by RENT on 2017-09-15.
 */
public class AbstractUnit {
    public AbstractUnit() {
        EventDispatcher.getInstance().registerObject(this);
    }
}
