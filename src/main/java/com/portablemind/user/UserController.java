package com.portablemind.user;

import com.portablemind.user.service.UserService;
import com.portablemind.userrole.service.UserRoleService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

/**
 * Created by Mateusz Brycki on 12/05/2015.
 */

@Controller
@RequestMapping(UserUrls.USER)
public class UserController {

    @Inject
    private UserService userService;

    @Inject
    private UserRoleService userRoleService;

    @Inject
    private PasswordEncoder passwordEncoder;

    private String viewPath = "controller/user/";

    @RequestMapping(value = UserUrls.USER_LOGIN, method = RequestMethod.GET)
    public String loginFormPage(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, ModelMap model) {
        if (error != null) {
            model.addAttribute("error", "Invalid mail or password. Try again.");
        }

        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return this.viewPath + "login";
    }

    @RequestMapping(value = UserUrls.USER_LOGIN, method = RequestMethod.POST)
    public String loginPage() {

        return "redirect:/";
    }

    @RequestMapping(value = UserUrls.USER_LOGOUT, method = RequestMethod.GET)
    public String logoutPage() {

        return "redirect:/";
    }

    @RequestMapping(value = UserUrls.USER_REGISTER, method = RequestMethod.GET)
    public String registerFormPage() {

        return this.viewPath + "register";
    }

    @RequestMapping(value = UserUrls.USER_REGISTER, method = RequestMethod.POST)
    public String registerPage(@RequestParam("mail") String mail,
                               @RequestParam("password") String password,
                               @RequestParam("password_repeat") String passwordRepeat,
                               ModelMap model) {

        Boolean equals = password.equals(passwordRepeat);
        Boolean userExists = userService.checkIfUserWithMailExists(mail);

        if(userExists == false && equals) {
            User user = new User();
            user.setMail(mail);
            user.setPassword(passwordEncoder.encode(password));
            user.setIsEnabled(User.DEFAULT_IS_ENABLED);
            user.setIsPublic(User.DEFAULT_IS_PUBLIC);
            user.setRole(userRoleService.findByName(User.DEFAULT_ROLE));

            userService.saveUser(user);

            model.addAttribute("success", "User successfully created. Please log in.");

        } else {

            if(userExists != null) {
                model.addAttribute("error", "Passed mail is in use.");
            } else {
                model.addAttribute("error", "Passwords are not equals.");
            }

        }

        return this.viewPath + "register";
    }
}
