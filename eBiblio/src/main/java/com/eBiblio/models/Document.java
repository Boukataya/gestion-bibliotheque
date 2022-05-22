package com.eBiblio.models;

import com.eBiblio.enums.Categorie;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 3000)
    private String description;
    private String cover;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    private String author;
    private String publisher;
    @JsonFormat(pattern = "EEE, d MMM yyyy HH:mm")
    private Date publish_date;
    @CreationTimestamp
    @JsonFormat(pattern = "EEE, d MMM yyyy HH:mm")
    private Date created_date;
    private int numberOfCopy;


}
