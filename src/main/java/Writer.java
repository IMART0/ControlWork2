import java.io.*;
import java.util.*;

public class Writer {
    private static final File png = new File("D:\\ITIS\\Прога\\CW2\\src\\main\\java\\v18.png");
    private static List<FileData> fileDataList = new ArrayList<>();
    public static void add(FileData fileData){
        synchronized (png){
            fileDataList.add(fileData);
        }
    }
    public static void createImage(){
        fileDataList.sort(Comparator.comparingInt(fd -> fd.getPart()));
        try(BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(png))) {
            for (int i = 0; i < fileDataList.size(); i++) {
                writer.write(fileDataList.get(i).getData());
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
