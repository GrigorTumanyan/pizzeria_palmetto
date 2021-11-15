package homework4.io;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class DownloadPage {
    private static final String GENERAL_PATH = "C:\\Users\\Student\\Projects_Grigor_Tumanyan\\";

    public static void main(String[] args) {

        DownloadPage.write("http://tutorials.jenkov.com/java-io/index.html");
    }

    public static InputStream openStream(String webPath) {
        try {
            URL url = new URL(webPath);
            return url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createFile(Path path) {
        if (Files.isExecutable(path)) {
            throw new RuntimeException("File is exists");
        } else {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String fileName(String webPath){
        String fileName = webPath.substring(7);
        return fileName.replace('/', '_');
    }

    public static void write(String webPath) {
        final String fileName = fileName(webPath);
        createFile(Path.of(GENERAL_PATH + fileName));
        try (InputStream in = openStream(webPath);
             OutputStream out = new FileOutputStream(fileName)) {
            byte[] buff = new byte[8192];
            int bytesRead;
            if (in != null) {
                while (in.read() != -1){
                    bytesRead = in.read(buff);
                    out.write(buff,0,bytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
