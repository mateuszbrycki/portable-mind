package com.portablemind.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mateusz Brycki on 12/05/2015.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private String viewPath = "controller/admin/";

    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public String welcome() {
        return this.viewPath + "main";
    }
}
