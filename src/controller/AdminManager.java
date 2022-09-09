package controller;

import model.member.InternalMember;
import model.member.Member;
import storage.IGenericReadWriteData;

import java.util.ArrayList;
import java.util.List;

public class AdminManager {
    private static IGenericReadWriteData readWriteData = storage.admin_ReadWriteData.ReadWriteFile.getInstance();
    public static List<Member> adminList = new ArrayList<>();

//    static {
//        Member member = new InternalMember("CGMD-Admin-001", "027098000271", "Vũ Hiền Lương", 0, "Cầu Giấy", "0915814526", "admin", 1);
//        adminList.add(member);
//    }

    public AdminManager() {
    }

    public void addNewAdmin(Member member) {
        adminList = readWriteData.readData();
        adminList.add(member);
        readWriteData.writeData(adminList);
    }

    public void copyAdminList(String pathIn, String pathOut) {
        adminList = readWriteData.readData(pathIn);
        readWriteData.writeData(adminList, pathOut);
    }

    public void editAdminById(int index, Member member) {
        adminList = readWriteData.readData();
        adminList.set(index, member);
        readWriteData.writeData(adminList);
    }

    public void removeAdminById(int index) {
        adminList = readWriteData.readData();
        adminList.remove(index);
        readWriteData.writeData(adminList);
    }

    public static boolean isAdmin(String phone, String password) {
        adminList = readWriteData.readData();
        boolean result = false;
        for (Member member : adminList) {
            if (phone.equals(member.getPhone()) && password.equals(member.getPassword())) {
                result = true;
            }
        }
        return result;
    }

    public void display() {
        adminList = readWriteData.readData();
        if(adminList.isEmpty()){
            System.out.println("Thư viện không có admin!");
        } else {
            for (Member member : adminList ) {
                System.out.println(member);
            }
        }
    }
}
