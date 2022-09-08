package storage.admin_ReadWriteData;

import model.member.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IReadWriteData {
    private static ReadWriteFile instance = null;

    private ReadWriteFile() {
    }

    public static ReadWriteFile getInstance() {
        if (instance == null) instance = new ReadWriteFile();
        return instance;
    }

    @Override
    public void writeData(List<Member> adminList) {
        try {
            FileOutputStream fos = new FileOutputStream("adminList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(adminList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Member> readData() {
        List<Member> adminList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("adminList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            adminList = (List<Member>) obj;
            return adminList;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeData(List<Member> adminList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(adminList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Member> readData(String path) {
        List<Member> adminList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            adminList = (List<Member>) obj;
            return adminList;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
