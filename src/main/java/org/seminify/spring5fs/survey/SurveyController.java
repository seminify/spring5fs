package org.seminify.spring5fs.survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {
    private List<Question> createQuestions() {
        Question question1 = new Question("당신의 역활은 무엇입니까?", Arrays.asList("서버", "프론트", "풀스택"));
        Question question2 = new Question("많이 사용하는 개발도구는 무엇입니까?", Arrays.asList("이클립스", "인텔리J", "서브라임"));
        Question question3 = new Question("하고 싶은 말을 적어주세요.");
        return Arrays.asList(question1, question2, question3);
    }

    @GetMapping
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questions", createQuestions());
        modelAndView.setViewName("survey/surveyForm");
        return modelAndView;
    }

    @PostMapping
    public String submit(@ModelAttribute("answeredData") AnsweredData answeredData) {
        return "survey/submitted";
    }
}
