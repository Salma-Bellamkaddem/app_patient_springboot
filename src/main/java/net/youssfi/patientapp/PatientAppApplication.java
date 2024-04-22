package net.youssfi.patientapp;

import net.youssfi.patientapp.dao.entities.Patient;
import net.youssfi.patientapp.dao.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PatientAppApplication  {

    public static void main(String[] args) {

        SpringApplication.run(PatientAppApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            Patient p2 =new Patient();
            p2.setNom("salmarr");
            p2.setPrenom("bellaggg");
            p2.setScore(12324);
            p2.setMalade(true);
patientRepository.save(p2);
            Patient p1= new Patient(null,"Yassine","Med",new Date(),1233,false);
            //code
            Patient p3 = Patient.builder()
                    .nom("Ahemdd")
                    .score(2233)
                    .dateNaissance(new Date())
                    .build();
            patientRepository.save(p3);
            patientRepository.save(p1);

            List<Patient> patientList = patientRepository.findAll();
             patientList.forEach(p->{
    System.out.println(p.getNom());

});


        };

    }

}
