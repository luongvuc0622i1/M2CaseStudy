package model.member;

import java.io.Serializable;

public class InternalMember extends Member implements Serializable {
    private int group;

    public InternalMember() {
    }

    public InternalMember(int group) {
        this.group = group;
    }

    public InternalMember(String memberId, String passport, String memberName, int sex, String address, String phone, String password, int group) {
        super(memberId, passport, memberName, sex, address, phone, password);
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
