import sun.util.resources.LocaleData;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by RENT on 2017-08-05.
 */
public class VehicleInfo {
    private String registrationNumber;
    private CarType carType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public VehicleInfo(String registrationNumber, CarType carType) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.startTime = LocalDateTime.now();
    }

    public CarType getCarType() {
        return carType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

}
