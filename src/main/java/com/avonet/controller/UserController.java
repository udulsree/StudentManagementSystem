package com.avonet.controller;

import com.avonet.dao.UserDao;
import com.avonet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

        @Autowired
        UserDao UserDao;

        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("user", new User());

            return mav;
        }

        @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
        public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                         @ModelAttribute("user")  User user) {
            ModelAndView mav = null;

            user = UserDao.validateUser(user);

            if (null != user) {
                mav = new ModelAndView("welcome");
                mav.addObject("firstname", user.getUsername());
            } else {
                mav = new ModelAndView("login");
                mav.addObject("message", "Username or Password is wrong!!");
            }

            return mav;
}
}
