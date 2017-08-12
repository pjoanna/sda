/**
 * Created by RENT on 2017-08-12.
 */
public class Request {
    private RequestType type;
    private String username;
    private String content;


    public Request(RequestType type, String username, String content) {
        this.username = username;
        this.content = content;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Request{" +
                "userName='" + username + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                '}';
    }
}
