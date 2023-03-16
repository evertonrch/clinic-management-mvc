package br.com.sys.clinicmanagement.web;

import br.com.sys.clinicmanagement.dao.ConsultationDao;
import br.com.sys.clinicmanagement.dao.MedicDao;
import br.com.sys.clinicmanagement.dao.PatientDao;
import br.com.sys.clinicmanagement.dto.ConsultationRequestDto;
import br.com.sys.clinicmanagement.model.Consultation;
import br.com.sys.clinicmanagement.model.Medic;
import br.com.sys.clinicmanagement.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private MedicDao medicDao;

    @Autowired
    private ConsultationDao consultationDao;

    @Autowired
    private PatientDao patientDao;

    @GetMapping("/create")
    public String create(Model model, ConsultationRequestDto consultationRequest) {
        medicDao.medicsByName().forEach(System.out::println);
        model.addAttribute("medicsName", medicDao.medics());
        return "consultation/create-consult.html";
    }

    @PostMapping("/process")
    public String processForm(ConsultationRequestDto consultationRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            allErrors.forEach(err -> System.out.println(err.getDefaultMessage()));
            return "redirect:/consultation/create-consult";
        }

        System.out.println(consultationRequest);

        Medic medic = medicDao.findByName(consultationRequest.getMedic());
        System.out.println("medic= " + medic.getCrm());

        Patient patient = patientDao.findByName(consultationRequest.getPatient());

        Consultation consultation = consultationRequest.toConsultation();
        consultation.setMedic(medic);
        consultation.setPatient(patient);

        System.out.println(consultation);
        consultationDao.saveConsultation(consultation);
        return "redirect:/home";
    }
}
