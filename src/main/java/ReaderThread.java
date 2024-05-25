import java.io.*;

public class ReaderThread extends Thread {
    private FileData fileData;
    public ReaderThread(FileData fileData) {
        this.fileData = fileData;
    }

    @Override
    public void run() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileData.getFile()));){
            byte[] sz_bytes = new byte[4];
            bis.read(sz_bytes);
            fileData.setSz(((sz_bytes[0] & 0xFF) << 24) + ((sz_bytes[1] & 0xFF) << 16)
                    + ((sz_bytes[2] & 0xFF) << 8) + (sz_bytes[3] & 0xFF));

            byte[] dataBytes = new byte[fileData.getSz()];
            bis.read(dataBytes);
            fileData.setData(dataBytes);

            byte[] even_bytes = new byte[4];
            bis.read(even_bytes);
            fileData.setEven(((even_bytes[0] & 0xFF) << 24) + ((even_bytes[1] & 0xFF) << 16)
                    + ((even_bytes[2] & 0xFF) << 8) + (even_bytes[3] & 0xFF));

            checkEven(dataBytes, fileData.getEven());

            byte[] part_bytes = new byte[4];
            bis.read(part_bytes);
            fileData.setPart(((part_bytes[0] & 0xFF) << 24) + ((part_bytes[1] & 0xFF) << 16)
                    + ((part_bytes[2] & 0xFF) << 8) + (part_bytes[3] & 0xFF));

            Writer.add(fileData);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean checkEven(byte dataBytes[], int even) {
        int cnt = 0;
        for (int i = 0; i < dataBytes.length; i++) {
            cnt += Integer.bitCount(dataBytes[i]);
        }
        int realEven = cnt%2;
        return realEven==even;
    }
}
