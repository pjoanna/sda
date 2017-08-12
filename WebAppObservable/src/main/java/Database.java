import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-08-12.
 */
public enum Database {
    INSTANCE;


    public void saveToDatabase(DatabaseType dbType, Object obj) {
        saveToDatabase(dbType.getFilename(), obj);
    }

    public void saveToDatabase(DatabaseType dbType, Request req) {
        saveToDatabase(dbType.getFilename(), req);
    }

    public void saveToDatabase(String dbName, Object obj) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(dbName, true))) {
            writer.println(obj);
        } catch (FileNotFoundException fnfe) {
            System.err.println("Error reading file.");
        }
    }

    public void appendServiceRequest(String dbName, Request obj) {
        String userName = obj.getUsername();
        String content = obj.getContent();

        // read from file
        Map<String, List<String>> fileContent = readFile(dbName);

        // handle adding to collection
        List<String> list;
        if (fileContent.containsKey(userName)) {
            list = fileContent.get(userName);
            list.add(content);
        } else {
            list = new LinkedList<>();
            list.add(content);
        }
        fileContent.put(userName, list);
        System.out.println("Service record added to list.");

        // save back to file
        saveRecordsToFile(dbName, fileContent);
    }

    private void saveRecordsToFile(String dbName, Map<String, List<String>> fileContent) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(dbName, true))) {
            for (Map.Entry<String, List<String>> entry : fileContent.entrySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getKey());
                sb.append(";");

                for (String content : entry.getValue()) {
                    sb.append(content);
                    sb.append(":");
                }
                writer.println(sb.substring(0, sb.length() - 1));
            }

        } catch (FileNotFoundException fnfe) {
            System.err.println("Error reading file.");
        }
        System.out.println("File " + dbName + " has been saved.");
    }

    private Map<String, List<String>> readFile(String dbName) {
        Map<String, List<String>> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dbName))) {

            String line = null;
            while ((line = reader.readLine()) != null) {
                // line splitted to username and contents
                String[] splits = line.split(";");
                String userName = splits[0];

                // contents splitted more
                String[] contents = splits[1].split(":");

                // rewrite list into array
                List<String> list = new LinkedList<>();
                for(String content : contents){
                    list.add(content);
                }

                // put everything into map
                map.put(userName, list);
            }

        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found.");
        } catch (IOException ioe) {
            System.err.println("IOException.");
        }

        return map;
    }

}
