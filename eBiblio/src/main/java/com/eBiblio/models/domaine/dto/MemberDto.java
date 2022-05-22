package com.eBiblio.models.domaine.dto;

import com.eBiblio.models.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MemberDto {

    private Long id;
    @NotEmpty(message = "Le nom de ne peut pas être vide")
    private String nom;
    @NotEmpty(message = "Le prenom de ne peut pas être vide")
    private String prenom;
    private String email;
    private String telephone;
    private boolean active;
    private List<Reservation> reservationList =new ArrayList<>();

    public MemberDto(String nom, String prenom, String email, String telephone, boolean active) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.active = active;
    }

}
