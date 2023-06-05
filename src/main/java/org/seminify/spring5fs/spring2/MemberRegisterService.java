package org.seminify.spring5fs.spring2;

import org.seminify.spring5fs.config.NoProduct;
import org.seminify.spring5fs.spring.DuplicateMemberException;
import org.seminify.spring5fs.spring.Member;
import org.seminify.spring5fs.spring.MemberDao;
import org.seminify.spring5fs.spring.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@NoProduct
@Component
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
