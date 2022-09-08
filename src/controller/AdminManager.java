package controller;

import model.member.InternalMember;
import model.member.Member;
import storage.IGenericReadWriteData;

import java.util.ArrayList;
import java.util.List;

public class AdminManager {
    private static IGenericReadWriteData readWriteData = storage.admin_ReadWriteData.ReadWriteFile.getInstance();
    public static List<Member> adminList = new ArrayList<>();

    static {
        Member member = new InternalMember("CG001", "027098000271", "Vux Hieenf Luowng", 0, "HN", "0915814526", "admin", 1);
        adminList.add(member);
    }

    public AdminManager() {
    }

    public void addNewMember(Member member) {
        adminList = readWriteData.readData();
        adminList.add(member);
        readWriteData.writeData(adminList);
    }

    public void copyMemberList(String pathIn, String pathOut) {
        adminList = readWriteData.readData(pathIn);
        readWriteData.writeData(adminList, pathOut);
    }

    public void editMemberById(int index, Member member) {
        adminList = readWriteData.readData();
        adminList.set(index, member);
        readWriteData.writeData(adminList);
    }

    public void removeBookById(int index) {
        adminList = readWriteData.readData();
        adminList.remove(index);
        readWriteData.writeData(adminList);
    }

    public static boolean isAdmin(String phone, String password) {
        boolean result = false;
        for (Member member : adminList) {
            if (phone.equals(member.getPhone()) && password.equals(member.getPassword())) {
                result = true;
            }
        }
        return result;
    }
}
