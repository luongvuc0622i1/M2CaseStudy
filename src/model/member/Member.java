package model.member;

import java.io.Serializable;

public abstract class Member implements Serializable {
    private String memberId;
    private String passport;
    private String memberName;
    private int sex;
    private String address;
    private String phone;
    private String password;

    public Member() {
    }

    public Member(String memberId, String passport, String memberName, int sex, String address, String phone, String password) {
        this.memberId = memberId;
        this.passport = passport;
        this.memberName = memberName;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSexToString() {
        if (sex == 0) {
            return "male";
        } else if (sex == 1) {
            return "female";
        } else {
            return null;
        }
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", passport='" + passport + '\'' +
                ", memberName='" + memberName + '\'' +
                ", sex='" + getSexToString() + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
