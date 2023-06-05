package org.seminify.spring5fs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("memberListPrinter")
public class MemberListPrinter {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    @Qualifier("memberSummaryPrinter")
    private MemberPrinter memberPrinter;

    public void printAll() {
        memberDao.selectAll().forEach(member -> memberPrinter.print(member));
    }
}
