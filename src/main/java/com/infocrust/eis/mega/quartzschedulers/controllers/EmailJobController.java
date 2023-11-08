package com.infocrust.eis.mega.quartzschedulers.controllers;


import com.infocrust.eis.mega.quartzschedulers.schedulers.EmailScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/notify")
public class EmailJobController {

    @Autowired
    EmailScheduler emailScheduler;


    @GetMapping(path="/by-email")
    public String getSomething(){

        emailScheduler.schedule();
        return "something123";
    }
}
