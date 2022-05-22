package com.eBiblio.services.document;

import com.eBiblio.models.domaine.dto.DocumentDto;

import java.util.List;

public interface IDocumentService {

    List<DocumentDto> getAllDocument();

    void saveDocument(DocumentDto documentDto);

    DocumentDto getDocumentById(Long id);

    List<DocumentDto> searchByTitle(String title);

    void deleteDocument(Long id);

    List<DocumentDto> findAll(int pageId, int size);

    List<DocumentDto> sortBy(String fieldName);

}
