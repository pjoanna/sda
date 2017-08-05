import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by RENT on 2017-08-05.
 */
public class Highway {
    private List<VehicleInfo> vehicleInfos = new ArrayList<>();

    public void vehicleEntry(String registrationNumber, CarType carType){
        vehicleInfos.add(new VehicleInfo(registrationNumber, carType));
        System.out.println("Dodano pojazd o numerze rejestracyjnym "+ registrationNumber);
    }

    public void searchVehicle(String registrationNumber){
        boolean isOnList = false;
        for (VehicleInfo vehicleInfo : vehicleInfos) {
            if (vehicleInfo.getRegistrationNumber().equals(registrationNumber)){
                isOnList = true;
                System.out.println("Pojazd o numerze rejestracyjnym jest na autostradzie");
            }
        }
    }

    public void vehicleLeave(String registrationNumber){
        Iterator<VehicleInfo> vehicleInfoIterator = vehicleInfos.iterator();
        while (vehicleInfoIterator.hasNext()){
            VehicleInfo vehicleInfo = vehicleInfoIterator.next();
            if (vehicleInfo.getRegistrationNumber().equals(registrationNumber)){
                vehicleInfo.setEndTime(LocalDateTime.now());
                System.out.println("Opłata za przejazd wynosi "+ getPrice(vehicleInfo));
                vehicleInfos.remove(registrationNumber);
                System.out.println("Usunięto pojazd o numerze rejestracyjnym "+registrationNumber);

                //TODO:REMEMBER kiedy usuwamy elementy korzystamy z iteratora! nie z pętli for/foreach!!
            }
        }
    }

    private long getTimeVehicle(String registrationNumber){
        for (VehicleInfo vehicleInfo : vehicleInfos) {
            if (vehicleInfo.getRegistrationNumber().equals(registrationNumber)){
                Timestamp tStart = Timestamp.valueOf(vehicleInfo.getStartTime());
                Timestamp tEnd = Timestamp.valueOf(vehicleInfo.getEndTime());
                return tEnd.getTime() - tStart.getTime();
            }
        }
        return 0;
    }

    public double getPrice(VehicleInfo vehicleInfo){

        return vehicleInfo.getCarType().getPrice()*getTimeVehicle(vehicleInfo.getRegistrationNumber())/1000;
    }


}
