import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Создаем пул потоков для параллельной обработки
        File directory = new File("D:\\ITIS\\Прога\\CW2\\src\\main\\java\\v18");
        File[] files = directory.listFiles();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (File file : files) {
            executor.submit(new ReaderThread(new FileData(file)));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        Writer.createImage();
    }
}
