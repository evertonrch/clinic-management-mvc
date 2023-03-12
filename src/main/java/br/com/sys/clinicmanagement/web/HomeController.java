package br.com.sys.clinicmanagement.web;

import br.com.sys.clinicmanagement.model.Medic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public ModelAndView home() {
        System.out.println("Home");
        ModelAndView mv = new ModelAndView("home");
        Medic meddic1 = new Medic("Um medico", "23432403");
        Medic meddic2 = new Medic("Another one", "98723743");
        Medic meddic3 = new Medic("Some", "62376423");
        Medic meddic4 = new Medic("Something", "91892312");
        mv.addObject("medics", Arrays.asList(meddic1, meddic2, meddic3, meddic4));
        return mv;
    }
}
