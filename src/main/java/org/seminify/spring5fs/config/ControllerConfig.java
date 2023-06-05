package org.seminify.spring5fs.config;

import org.seminify.spring5fs.controller.ChangePwdController;
import org.seminify.spring5fs.controller.LoginController;
import org.seminify.spring5fs.controller.LogoutController;
import org.seminify.spring5fs.controller.RegisterController;
import org.seminify.spring5fs.survey.SurveyController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
    @Bean
    public RegisterController registerController() {
        return new RegisterController();
    }

    @Bean
    public SurveyController surveyController() {
        return new SurveyController();
    }

    @Bean
    public LoginController loginController() {
        return new LoginController();
    }

    @Bean
    public LogoutController logoutController() {
        return new LogoutController();
    }

    @Bean
    public ChangePwdController changePwdController() {
        return new ChangePwdController();
    }
}
