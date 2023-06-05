package org.seminify.spring5fs.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MemberRegisterService {
    @Autowired
    private MemberDao memberDao;

    public Long regist(RegisterRequest registerRequest) {
        Member member = memberDao.selectByEmail(registerRequest.getEmail());
        if (member != null)
            throw new DuplicateMemberException("dup email " + registerRequest.getEmail());
        Member newMember = new Member(registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getName(), LocalDateTime.now());
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
