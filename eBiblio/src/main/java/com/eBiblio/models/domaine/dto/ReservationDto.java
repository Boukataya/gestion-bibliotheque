package com.eBiblio.models.domaine.dto;

import com.eBiblio.models.Document;
import com.eBiblio.models.Membre;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDto {

    private Long id;
    @JsonFormat(pattern = "EEE, d MMM yyyy HH:mm")
    private Date dateReservation;
    private Membre membre;
    private Document document;

    public ReservationDto(Date dateReservation, Membre membre, Document document) {
        this.dateReservation = dateReservation;
        this.membre = membre;
        this.document = document;
    }

}
