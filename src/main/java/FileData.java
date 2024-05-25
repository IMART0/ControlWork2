import java.io.File;

public class FileData {
    private int sz; // размер блока данных
    private byte[] data; // данные с фрагментом картинки
    private int even; // контрольное число четности
    private int part; // номер фрагмента картинки [0..7]
    private File file;

    public FileData(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getSz() {
        return sz;
    }

    public void setSz(int sz) {
        this.sz = sz;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getEven() {
        return even;
    }

    public void setEven(int even) {
        this.even = even;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }
}
