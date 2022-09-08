package storage.member_ReadWriteData;

import model.member.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileExcel implements IReadWriteData {
    private static ReadWriteFileExcel instance = null;

    private ReadWriteFileExcel() {
    }

    public static ReadWriteFileExcel getInstance() {
        if (instance == null) instance = new ReadWriteFileExcel();
        return instance;
    }

    @Override
    public void writeData(List<Member> memberList) {
        try {
            FileOutputStream fos = new FileOutputStream("memberList.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(memberList);
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
        List<Member> memberList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("memberList.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            memberList = (List<Member>) obj;
            return memberList;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeData(List<Member> memberList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(memberList);
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
        List<Member> memberList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            memberList = (List<Member>) obj;
            return memberList;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
