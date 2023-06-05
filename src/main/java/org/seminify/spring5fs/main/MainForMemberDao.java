package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtx;
import org.seminify.spring5fs.spring.Member;
import org.seminify.spring5fs.spring.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainForMemberDao {
    private static MemberDao memberDao;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMddHHmmss");

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppCtx.class);
        memberDao = annotationConfigApplicationContext.getBean(MemberDao.class);
        selectAll();
        updateMember();
        insertMember();
        annotationConfigApplicationContext.close();
    }

    private static void selectAll() {
        System.out.println("----- selectAll");
        int total = memberDao.count();
        System.out.println("전체 데이터 : " + total);
        memberDao.selectAll().forEach(member -> System.out.println(member.getId() + " : " + member.getEmail() + " : " + member.getName()));
    }

    private static void updateMember() {
        System.out.println("----- updateMember");
        Member member = memberDao.selectByEmail("madvirus@madvirus.net");
        String oldPw = member.getPassword();
        String newPw = Double.toHexString(Math.random());
        member.changePassword(oldPw, newPw);
        memberDao.update(member);
        System.out.println("암호 변경 : " + oldPw + " > " + newPw);
    }

    private static void insertMember() {
        System.out.println("----- insertMember");
        String prefix = dateTimeFormatter.format(LocalDateTime.now());
        Member member = new Member(prefix + "@test.com", prefix, prefix, LocalDateTime.now());
        memberDao.insert(member);
        System.out.println(member.getId() + "데이터 추가");
    }
}
