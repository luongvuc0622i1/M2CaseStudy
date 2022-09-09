package controller;

import model.book.Book;
import model.member.ExternalMember;
import model.member.InternalMember;
import model.member.Member;
import storage.IGenericReadWriteData;

import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    private static IGenericReadWriteData readWriteData = storage.member_ReadWriteData.ReadWriteFile.getInstance();
    public static List<Member> memberList = new ArrayList<>();

    public MemberManager() {
    }

    public void addNewMember(Member member) {
        memberList = readWriteData.readData();
        memberList.add(member);
        readWriteData.writeData(memberList);
    }

    public void copyMemberList(String pathIn, String pathOut) {
        memberList = readWriteData.readData(pathIn);
        readWriteData.writeData(memberList, pathOut);
    }

    public void editMemberById(int index, Member member) {
        memberList = readWriteData.readData();
        memberList.set(index, member);
        readWriteData.writeData(memberList);
    }

    public void removeMemberById(int index) {
        memberList = readWriteData.readData();
        memberList.remove(index);
        readWriteData.writeData(memberList);
    }

    public static boolean isMember(String phone, String password) {
        boolean result = false;
        for (Member member : memberList) {
            if (phone.equals(member.getPhone()) && password.equals(member.getPassword())) {
                result = true;
            }
        }
        return result;
    }

    public void display() {
        memberList = readWriteData.readData();
        if(memberList.isEmpty()){
            System.out.println("Thư viện chưa có thành viên nào!");
        } else {
            for (Member member : memberList) {
                System.out.println(member);
            }
        }
    }
}
