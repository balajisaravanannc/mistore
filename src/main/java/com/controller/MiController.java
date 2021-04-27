package com.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MiController {

    private static final Logger logger = LogManager.getLogger(MiController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String AmazonHome() {
        BasicConfigurator.configure();
        logger.info("AmazonController method from where i get my default page");

        return "miHomePage";
    }

    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String aboutUs() {
        logger.info("aboutUs method");

        return "aboutUsPage";
    }

    public static Logger getLogger() {
        return logger;
    }
}
