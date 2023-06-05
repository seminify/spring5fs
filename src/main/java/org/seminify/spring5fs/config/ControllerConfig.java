package org.seminify.spring5fs.config;

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
}
