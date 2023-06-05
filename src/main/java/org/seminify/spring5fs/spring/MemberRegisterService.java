package org.seminify.spring5fs.spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest registerRequest) {
        Member member = memberDao.selectByEmail(registerRequest.getEmail());
        if (member != null)
            throw new DuplicateMemberException("dup email " + registerRequest.getEmail());
        Member newMember = new Member(registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getName(), LocalDateTime.now());
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
