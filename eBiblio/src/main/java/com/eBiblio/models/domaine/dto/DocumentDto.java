package com.eBiblio.models.domaine.dto;

import com.eBiblio.enums.Categorie;
import com.eBiblio.models.Reservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
public class DocumentDto {

    private Long id;
    @NotEmpty(message = "Le titre de ne peut pas être vide")
    private String title;
    @NotEmpty(message = "La description de ne peut pas être vide")
    private String description;
    private String cover;
    @NotNull(message = "La categorie de ne peut pas être vide")
    private Categorie categorie;
    @NotEmpty(message = "L'auteur de ne peut pas être vide")
    private String author;
    @NotEmpty(message = "L'editeur ne peut pas être vide")
    private String publisher;
    @NotNull(message = "La date de publication ne peut pas être vide")
    private Date publish_date;
    private Date created_date;
    @NotNull(message = "Le nombre de copy ne peut pas être vide")
    private int numberOfCopy;
    private Reservation reservation;

    public DocumentDto(String title, String description, String cover, Categorie categorie, String author, String publisher, Date publish_date, int numberOfCopy) {
        this.title = title;
        this.description = description;
        this.cover = cover;
        this.categorie = categorie;
        this.author = author;
        this.publisher = publisher;
        this.publish_date = publish_date;
        this.numberOfCopy = numberOfCopy;

    }

}
