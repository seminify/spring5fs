package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtx;
import org.seminify.spring5fs.spring.ChangePasswordService;
import org.seminify.spring5fs.spring.MemberNotFoundException;
import org.seminify.spring5fs.spring.WrongIdPasswordException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForCPS {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppCtx.class);
        ChangePasswordService changePasswordService = annotationConfigApplicationContext.getBean("changePasswordService", ChangePasswordService.class);
        try {
            changePasswordService.changePassword("madvirus@madvirus.net", "1234", "1111");
            System.out.println("암호를 변경했습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("회원 데이터가 존재하지 않습니다.");
        } catch (WrongIdPasswordException e) {
            System.out.println("암호가 올바르지 않습니다.");
        }
        annotationConfigApplicationContext.close();
    }
}
