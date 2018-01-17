package muhammedf.afet.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

    public static final String SERVER_URL = "http://127.0.0.1:8080";
    public static final String FILE_SYSTEM_RELATIVE_URI = "/var/storage";
    public static final String URL_RELATIVE_URI = "/storage";

    private IOUtil(){}

    public static boolean createFile(byte[] fileContent, String path){
        File file = new File(path);
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(fileContent);
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
