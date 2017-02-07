package ua.goit.offline.chat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andreymi on 2/7/2017.
 */
@Controller
public class LandingPage {
    @GetMapping
    public ModelAndView mainPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
