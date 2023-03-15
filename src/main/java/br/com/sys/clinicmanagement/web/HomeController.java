package br.com.sys.clinicmanagement.web;

import br.com.sys.clinicmanagement.dao.ConsultationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ConsultationDao consultationDao;

    @GetMapping
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("consultations", consultationDao.getConsultations());
        return mv;
    }

}
