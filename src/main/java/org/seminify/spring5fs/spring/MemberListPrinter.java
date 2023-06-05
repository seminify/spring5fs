package org.seminify.spring5fs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    @Qualifier("memberSummaryPrinter")
    public void setMemberPrinter(MemberPrinter memberPrinter) {
        this.memberPrinter = memberPrinter;
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(member -> memberPrinter.print(member));
    }
}
