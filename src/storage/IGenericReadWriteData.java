package storage;

import java.util.List;

public interface IGenericReadWriteData<T> {
    List<T> readData();
    void writeData(List<T> list);
    List<T> readData(String path);
    void writeData(List<T> list, String path);
}
