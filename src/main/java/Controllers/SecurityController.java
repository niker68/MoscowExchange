package Controllers;

import models.Security;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.SecurityService;

import java.util.List;

@Controller
public class SecurityController {
    private final SecurityService securityService = new SecurityService();

    public SecurityController() {
    }

    @RequestMapping(value = "/")
    public ModelAndView home() {
        List<Security> listSecurity = securityService.findAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listSecurity", listSecurity);
        return mav;
    }
}
