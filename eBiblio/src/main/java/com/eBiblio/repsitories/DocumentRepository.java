package com.eBiblio.repsitories;

import com.eBiblio.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByTitleLike(String title);

}
