package org.seminify.spring5fs.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class AuthService {
    @Autowired
    private MemberDao memberDao;

    public AuthInfo authenticate(String email, String password) {
        Member member = memberDao.selectByEmail(email);
        if (member == null)
            throw new WrongIdPasswordException();
        if (!member.matchPassword(password))
            throw new WrongIdPasswordException();
        return new AuthInfo(member.getId(), member.getEmail(), member.getName());
    }
}
