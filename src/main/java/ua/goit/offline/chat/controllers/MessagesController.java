package ua.goit.offline.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.offline.chat.dao.MessagesService;

import java.util.Collections;

/**
 * Created by andreymi on 2/7/2017.
 */
@Controller
@RequestMapping("/messages")
public class MessagesController {

    private final MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping("create")
    public void addMessage(String text) {
        System.out.println(text);
    }

    @GetMapping
    public ModelAndView getMessages() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("messages");
        modelAndView.addObject("msgs", messagesService.getAllMessages());
        return modelAndView;
    }


}
