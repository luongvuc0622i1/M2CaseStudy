package controller;

import controller.comparator.comparatorMember.MemberIdComparator;
import controller.comparator.comparatorMember.MemberNameComparator;
import model.member.Member;
import storage.IGenericReadWriteData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemberManager {
    private static IGenericReadWriteData readWriteData = storage.member_ReadWriteData.ReadWriteFile.getInstance();
    public static List<Member> memberList = new ArrayList<>();

    public MemberManager() {
    }

    public static boolean checkMember(String memberId) {
        memberList = readWriteData.readData();
        boolean check = false;
        for (Member member : memberList) {
            if (memberId.equals(member.getMemberId())) {
                check = true;
            }
        }
        return check;
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

    public void editMemberByMemberId(String memberId, Member member) {
        memberList = readWriteData.readData();
        int index = -1;
        for (int i = 0; i < memberList.size(); i++) {
            if (memberId.equals(memberList.get(i).getMemberId())) {
                index = i;
            }
        }
        memberList.set(index, member);
        readWriteData.writeData(memberList);
    }

    public void removeMemberByMemberId(String memberId) {
        memberList = readWriteData.readData();
        int index = -1;
        for (int i = 0; i < memberList.size(); i++) {
            if (memberId.equals(memberList.get(i).getMemberId())) {
                index = i;
            }
        }
        memberList.remove(index);
        readWriteData.writeData(memberList);
    }

    public static boolean isMember(String phone, String password) {
        memberList = readWriteData.readData();
        boolean result = false;
        for (Member member : memberList) {
            if (phone.equals(member.getPhone()) && password.equals(member.getPassword())) {
                result = true;
            }
        }
        return result;
    }

    public String exportMemberId(String phone, String password) {
        memberList = readWriteData.readData();
        String memberId = null;
        for (Member member : memberList) {
            if (phone.equals(member.getPhone()) && password.equals(member.getPassword())) {
                memberId = member.getMemberId();
            }
        }
        return memberId;
    }

    public void sortById() {
        memberList = readWriteData.readData();
        System.out.println("Sắp xếp theo thuộc tính id:");
        Collections.sort(memberList, new MemberIdComparator());
        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    public void sortByName() {
        memberList = readWriteData.readData();
        System.out.println("Sắp xếp theo thuộc tính name:");
        Collections.sort(memberList, new MemberNameComparator());
        for (Member member : memberList) {
            System.out.println(member);
        }
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
