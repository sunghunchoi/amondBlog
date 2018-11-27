package com.amond.blog.controller;

import com.amond.blog.Test;
import com.amond.blog.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @Autowired
    private Test test;

    @Autowired
    private PostsService postsService;


    @ModelAttribute("title")
    public String title(){
        return "Spring Boot Test ... " + test.getTest();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model)
    {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }


}
