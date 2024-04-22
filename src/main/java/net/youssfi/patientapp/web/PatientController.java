package net.youssfi.patientapp.web;


import jakarta.validation.Valid;
import net.youssfi.patientapp.dao.entities.Patient;
import net.youssfi.patientapp.dao.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model , @RequestParam(name="page", defaultValue = "0") int page ,
                        @RequestParam(name="size", defaultValue ="5" ) int size,
                        @RequestParam(name = "Keyword", defaultValue = "") String Keyword){
        Page<Patient> pagePainters= patientRepository.findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase( Keyword, Keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePainters.getContent());
        model.addAttribute("pages", new int[pagePainters.getTotalPages()] );
        model.addAttribute("currentPage",page);
        model.addAttribute("Keyword",Keyword);
        return "patients";

    }
    @GetMapping("/deletePatient")
    public String delete(@RequestParam(name="id") Long id ,String Keyword , int page ){
patientRepository.deleteById(id);
return "redirect:/index?page="+page+"&Keyword="+Keyword;
    }

    @GetMapping("/formPatients")
public String formPatient( Model model){
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }
    @PostMapping(path = "/save")
    public String save(Model model , @Valid  Patient patient, BindingResult bindingResult ,@RequestParam (defaultValue = "0")int page ,
                       @RequestParam(defaultValue = "")
                       String Keyword){
        if(bindingResult.hasErrors())return "formPatients";
        patientRepository.save(patient);
        return "redirect:/index?page="+page+"&Keyword="+Keyword;
    }
    @GetMapping("/editPatient")
    public String editPatient( Model model ,Long id , String Keyword,int page ){
        Patient patient =patientRepository.findById(id).orElse(null);
        if(patient==null) throw  new RuntimeException("Patient introuvable");
        model.addAttribute("patient", patient);
        model.addAttribute("page",page);
        model.addAttribute("Keyword",Keyword);

        return "editPatient";
    }

}
