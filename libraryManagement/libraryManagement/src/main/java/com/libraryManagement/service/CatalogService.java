package com.libraryManagement.service;

import com.libraryManagement.entity.Catalog;
import com.libraryManagement.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    public Catalog addCatalogEntry(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    public List<Catalog> getAllCatalogEntries() {
        return catalogRepository.findAll();
    }

    public Optional<Catalog> getCatalogEntryById(int catalogId) {
        return catalogRepository.findById(catalogId);
    }

    public Catalog updateCatalogEntry(int catalogId, Catalog catalogDetails) {
        Catalog catalog = catalogRepository.findById(catalogId).orElseThrow(() -> new RuntimeException("Catalog entry not found"));
        catalog.setBookId(catalogDetails.getBookId());
        catalog.setCategory(catalogDetails.getCategory());
        catalog.setKeywords(catalogDetails.getKeywords());
        return catalogRepository.save(catalog);
    }

    public void deleteCatalogEntry(int catalogId) {
        catalogRepository.deleteById(catalogId);
    }
}
