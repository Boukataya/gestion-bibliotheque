package com.eBiblio.controllers;

import com.eBiblio.models.domaine.dto.DocumentDto;
import com.eBiblio.models.domaine.dto.MemberDto;
import com.eBiblio.services.document.IDocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private IDocumentService documentService;

    public DocumentController(IDocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveDocument(@RequestBody @Valid DocumentDto documentDto) {
        documentService.saveDocument(documentDto);
        return new ResponseEntity<>("Document is saved successfully!", HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public List<DocumentDto> getAllDocuments() {
        return documentService.getAllDocument();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findDocumentById(@PathVariable Long id) {
        DocumentDto documentDto = documentService.getDocumentById(id);
        if (documentDto == null) return new ResponseEntity<>("Document doesn't exist!!", HttpStatus.OK);
        return new ResponseEntity<>(documentDto, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateDocument(@PathVariable Long id, @Valid @RequestBody DocumentDto documentDto) {
        DocumentDto checkIfDocumentExist = documentService.getDocumentById(id);
        if (checkIfDocumentExist == null)
            return new ResponseEntity<>("Document doesn't exist", HttpStatus.OK);
        documentDto.setId(id);
        documentService.saveDocument(documentDto);
        return new ResponseEntity<>("Document is updated successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/sort/{fieldName}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<DocumentDto> sortBy(@PathVariable String fieldName) {
        return documentService.sortBy(fieldName);
    }

    @GetMapping("/{pageId}/{size}")
    public List<DocumentDto> pagination(@PathVariable int pageId, @PathVariable int size, Model m) {
        return documentService.findAll(pageId, size);
    }

}
