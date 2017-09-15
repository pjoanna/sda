/**
 * Created by RENT on 2017-09-14.
 */
public class Request {
    private String request;
    private AlexaDevice deviceToCall;

    public Request(String request, AlexaDevice deviceToCall) {
        this.request = request;
        this.deviceToCall = deviceToCall;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public AlexaDevice getDeviceToCall() {
        return deviceToCall;
    }

    public void setDeviceToCall(AlexaDevice deviceToCall) {
        this.deviceToCall = deviceToCall;
    }
}
