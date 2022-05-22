package com.eBiblio.models.domaine.mappers;

import com.eBiblio.models.Document;
import com.eBiblio.models.domaine.dto.DocumentDto;

import java.util.ArrayList;
import java.util.List;

public class DocumentConverter {

    public static DocumentDto toDocumentDto(Document document) {
        if (document == null || document.getId() == null)
            return null;
        DocumentDto documentDto = new DocumentDto();
        documentDto.setId(document.getId());
        documentDto.setTitle(document.getTitle());
        documentDto.setDescription(document.getDescription());
        documentDto.setCover(document.getCover());
        documentDto.setAuthor(document.getAuthor());
        documentDto.setCategorie(document.getCategorie());
        documentDto.setPublisher(document.getPublisher());
        documentDto.setPublish_date(document.getPublish_date());
        documentDto.setCreated_date(document.getCreated_date());
        documentDto.setNumberOfCopy(document.getNumberOfCopy());
        return documentDto;
    }

    public static Document toDocument(DocumentDto documentDto) {
        if (documentDto == null) return null;
        Document document = new Document();
        document.setId(documentDto.getId());
        document.setTitle(documentDto.getTitle());
        document.setDescription(documentDto.getDescription());
        document.setCover(documentDto.getCover());
        document.setAuthor(documentDto.getAuthor());
        document.setPublisher(documentDto.getPublisher());
        document.setCategorie(documentDto.getCategorie());
        document.setPublish_date(documentDto.getPublish_date());
        document.setCreated_date(documentDto.getCreated_date());
        document.setNumberOfCopy(documentDto.getNumberOfCopy());
        return document;
    }

    public static List<DocumentDto> documentDtoList(List<Document> documentList) {
        List<DocumentDto> documentDtoList = new ArrayList<>();
        for (Document document : documentList) {
            documentDtoList.add(toDocumentDto(document));
        }
        return documentDtoList;
    }

}
