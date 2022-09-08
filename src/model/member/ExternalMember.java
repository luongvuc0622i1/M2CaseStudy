package model.member;

import java.io.Serializable;

public class ExternalMember extends Member implements Serializable, IDepositMoney {
    private int maxBorrow = 5;

    public ExternalMember() {
    }

    public ExternalMember(int maxBorrow) {
        this.maxBorrow = maxBorrow;
    }

    public ExternalMember(String memberId, String passport, String memberName, int sex, String address, String phone, String password, int maxBorrow) {
        super(memberId, passport, memberName, sex, address, phone, password);
        this.maxBorrow = maxBorrow;
    }

    public int getMaxBorrow() {
        return maxBorrow;
    }

    public void setMaxBorrow(int maxBorrow) {
        this.maxBorrow = maxBorrow;
    }

    @Override
    public int getDepositMoney() {
        return 0;
    }
}
