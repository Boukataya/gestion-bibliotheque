package com.eBiblio.services.document;

import com.eBiblio.models.Document;
import com.eBiblio.models.domaine.dto.DocumentDto;
import com.eBiblio.models.domaine.mappers.DocumentConverter;
import com.eBiblio.models.domaine.mappers.MemberConverter;
import com.eBiblio.repsitories.DocumentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements IDocumentService {

    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public List<DocumentDto> getAllDocument() {
        List<Document> list = documentRepository.findAll();
        return DocumentConverter.documentDtoList(list);
    }

    @Override
    public void saveDocument(DocumentDto documentDto) {
        documentRepository.save(DocumentConverter.toDocument(documentDto));
    }

    @Override
    public DocumentDto getDocumentById(Long id) {
        boolean documentExistenceCheck = documentRepository.existsById(id);
        if (!documentExistenceCheck) return null;
        return DocumentConverter.toDocumentDto(documentRepository.getById(id));
    }

    @Override
    public List<DocumentDto> searchByTitle(String title) {
        List<Document> documentList = documentRepository.findByTitleLike(title);
        if (documentList == null) return null;
        return DocumentConverter.documentDtoList(documentList);

    }

    @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public List<DocumentDto> findAll(int pageId, int size) {
        Page<Document> documentPage = documentRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "title"));
        return DocumentConverter.documentDtoList(documentPage.getContent());
    }

    @Override
    public List<DocumentDto> sortBy(String fieldName) {
        return DocumentConverter.documentDtoList(documentRepository.findAll(Sort.by(fieldName)));
    }

}
