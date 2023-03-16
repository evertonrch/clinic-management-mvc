package br.com.sys.clinicmanagement.web;

import br.com.sys.clinicmanagement.dao.PatientDao;
import br.com.sys.clinicmanagement.dto.PatientRequestDto;
import br.com.sys.clinicmanagement.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientDao patientDao;

    @GetMapping
    public ModelAndView all() {
        ModelAndView mv = new ModelAndView("patient/patients");
        mv.addObject("patients", patientDao.getPatients());
        return mv;
    }


    @GetMapping("/create")
    public String create(PatientRequestDto patientRequest) {
        return "patient/create-patient";
    }

    @PostMapping("/processForm")
    public String processForm(PatientRequestDto patientRequest, BindingResult result) {
        if(result.hasErrors())
            return "redirect:/patient/create-patient";

        Patient patient = patientRequest.toPatient();
        patientDao.savePatient(patient);
        return "redirect:/home";
    }
}
