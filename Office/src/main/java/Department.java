import java.util.ArrayList;
import java.util.List;

/**
 * Created by pjoanna on 2017-08-08.
 */
public class Department {
    private List<Office> officeList = new ArrayList<>();

    public void addOffice(Office office){
        officeList.add(office);
    }

    public Office getOffice(int room){
        Office office = officeList.get(room);
        return office;
    }

    public List<Office> getOfficeList() {
        return officeList;
    }
}
