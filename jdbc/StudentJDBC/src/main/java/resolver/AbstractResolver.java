package resolver;

import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-09-23.
 */
public abstract class AbstractResolver<T>{
    public abstract AbstractResolver<T> get(int id);
    public abstract List<T> get();
    public abstract boolean delete(int id);
    public abstract boolean insert(Map<String, String> map);
    public abstract boolean update(int id, Map<String, String> map);


}
