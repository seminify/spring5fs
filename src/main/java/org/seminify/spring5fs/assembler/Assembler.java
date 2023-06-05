package org.seminify.spring5fs.assembler;

import org.seminify.spring5fs.spring.ChangePasswordService;
import org.seminify.spring5fs.spring.MemberDao;
import org.seminify.spring5fs.spring.MemberRegisterService;

public class Assembler {
    private MemberDao memberDao;
    private MemberRegisterService memberRegisterService;
    private ChangePasswordService changePasswordService;

    public Assembler() {
        this.memberDao = new MemberDao();
        this.memberRegisterService = new MemberRegisterService(memberDao);
        this.changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService() {
        return memberRegisterService;
    }

    public ChangePasswordService getChangePasswordService() {
        return changePasswordService;
    }
}
