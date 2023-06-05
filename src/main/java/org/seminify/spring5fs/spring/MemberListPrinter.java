package org.seminify.spring5fs.spring;

public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
        this.memberDao = memberDao;
        this.memberPrinter = memberPrinter;
    }

    public void printAll() {
        memberDao.selectAll().forEach(member -> memberPrinter.print(member));
    }
}
