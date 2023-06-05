package org.seminify.spring5fs.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    public void printAll() {
        memberDao.selectAll().forEach(member -> memberPrinter.print(member));
    }
}
