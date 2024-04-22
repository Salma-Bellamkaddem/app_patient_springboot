package net.youssfi.patientapp.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 4, max =40)
     private  String nom;
     private  String prenom;
     @Temporal(TemporalType.DATE)
     @DateTimeFormat(pattern="yyyy-mm-dd")
      private Date dateNaissance;
    @DecimalMin("100")
      private int score;

      private  boolean malade;


}
