package org.seminify.spring5fs.controller;

import jakarta.servlet.http.HttpSession;
import org.seminify.spring5fs.spring.AuthInfo;
import org.seminify.spring5fs.spring.ChangePasswordService;
import org.seminify.spring5fs.spring.WrongIdPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
    @Autowired
    private ChangePasswordService changePasswordService;

    @GetMapping
    public String form(@ModelAttribute("command") ChangePwdCommand changePwdCommand) {
        return "edit/changePwdForm";
    }

    @PostMapping
    public String submit(@ModelAttribute("command") ChangePwdCommand changePwdCommand, Errors errors, HttpSession httpSession) {
        new ChangePwdCommandValidator().validate(changePwdCommand, errors);
        if (errors.hasErrors())
            return "edit/changePwdForm";
        AuthInfo authInfo = (AuthInfo) httpSession.getAttribute("authInfo");
        try {
            changePasswordService.changePassword(authInfo.getEmail(), changePwdCommand.getCurrentPassword(), changePwdCommand.getNewPassword());
            return "edit/changePwd";
        } catch (WrongIdPasswordException e) {
            errors.rejectValue("currentPassword", "notMatching");
            return "edit/changePwdForm";
        }
    }
}
