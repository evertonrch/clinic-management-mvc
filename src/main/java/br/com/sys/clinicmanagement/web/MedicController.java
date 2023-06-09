package br.com.sys.clinicmanagement.web;

import br.com.sys.clinicmanagement.dao.MedicDao;
import br.com.sys.clinicmanagement.dto.MedicRequestDto;
import br.com.sys.clinicmanagement.model.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/medic")
public class MedicController {

    @Autowired
    private MedicDao medicDao;

    @GetMapping
    public ModelAndView medics() {
        ModelAndView mv = new ModelAndView("medic/medics");
        mv.addObject("medics", medicDao.getMedics());
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        Medic medic = medicDao.findById(Long.parseLong(id));
        if(medic == null) return "redirect:/medic/form";
        medicDao.delete(medic);
        return "redirect:/medic";
    }
    @GetMapping("/form")
    public String medicForm(MedicRequestDto medicReq) {
        return "medic/medic-form";
    }

    @PostMapping("/processForm")
    public String processForm(MedicRequestDto medicReq, BindingResult result) {
        if (result.hasErrors())
            return "redirect:/home";

        Medic medic = new Medic(medicReq);
        medicDao.saveMedic(medic);
        return "redirect:/home";
    }

}
