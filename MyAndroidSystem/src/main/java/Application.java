/**
 * Created by RENT on 2017-09-16.
 */
public abstract class Application {
    public Application() {
        EventDispatcher.getInstance().registerObject(this);
    }
}
