package com.mrfz.PageController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class Pagecontroller {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(Pagecontroller.class);

    @RequestMapping(value = "/test/indexs", method = RequestMethod.GET)
    public String loginPage() {
        return "index";
    }


}
