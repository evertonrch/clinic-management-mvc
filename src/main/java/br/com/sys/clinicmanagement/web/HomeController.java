package br.com.sys.clinicmanagement.web;

import br.com.sys.clinicmanagement.dao.ConsultationDao;
import br.com.sys.clinicmanagement.dao.MedicDao;
import br.com.sys.clinicmanagement.dao.PatientDao;
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

    private final MedicDao medicDao;
    private final PatientDao patientDao;
    @Autowired
    public HomeController(MedicDao medicDao, PatientDao patientDao) {
        this.medicDao = medicDao;
        this.patientDao = patientDao;
    }

    @GetMapping
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("consultations", consultationDao.getConsultations());
        mv.addObject("totalMedics", medicDao.getMedics().size());
        mv.addObject("totalPatients", patientDao.getPatients().size());
        return mv;
    }

}
