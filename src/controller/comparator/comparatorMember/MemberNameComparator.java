package controller.comparator.comparatorMember;

import model.member.Member;

import java.util.Comparator;

public class MemberNameComparator implements Comparator<Member> {
    @Override
    public int compare(Member o1, Member o2) {
        return o1.getMemberName().compareTo(o2.getMemberName());
    }
}
