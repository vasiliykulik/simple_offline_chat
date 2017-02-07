package ua.goit.offline.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.offline.chat.dao.MessagesService;
import ua.goit.offline.chat.dao.UserService;
import ua.goit.offline.chat.entity.Message;
import ua.goit.offline.chat.entity.User;
import ua.goit.offline.chat.security.UserEntity;

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
    public void addMessage(Authentication authentication, String text) {
        try {
            UserEntity entity = (UserEntity) authentication.getPrincipal();
            Message message = new Message();
            message.setText(text);
            message.setUser(entity.getUser());
            messagesService.save(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping
    public ModelAndView getMessages() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("messages");
        modelAndView.addObject("msgs", messagesService.getAllMessages());
        return modelAndView;
    }


}
