package controller;

import model.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.EmailConfigService;

@Controller
public class EmailConfigController {
    @Autowired
    private EmailConfigService emailConfigService;

    @GetMapping("")
    public ModelAndView emailConfig() {
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("emailconfig", emailConfigService.getConfig());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showEditForm() {
        EmailConfig emailConfig = emailConfigService.getConfig();
        if (emailConfig != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("emailconfig", emailConfig);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST, params="action=Update")
    public ModelAndView updateEmailConfig(@ModelAttribute("emailconfig") EmailConfig emailConfig) {
        emailConfigService.setConfig(emailConfig);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("emailconfig", emailConfig);
        modelAndView.addObject("message", "Updated successfully");
        return modelAndView;
    }
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="action=Cancel")
    public ModelAndView CancelUpdate() {
        return emailConfig();
    }





}
