package controller.comparator.comparatorMember;

import model.member.Member;

import java.util.Comparator;

public class MemberIdComparator implements Comparator<Member> {
    @Override
    public int compare(Member o1, Member o2) {
        return o1.getMemberId().compareTo(o2.getMemberId());
    }
}
