/**
 * Created by RENT on 2017-08-12.
 */
public enum DatabaseType {
    DB_USERS("users.txt"), DB_ORDERS("orders.txt"), DB_REQUESTS("requests.txt");

    private String filename;

    DatabaseType (String filename){
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
