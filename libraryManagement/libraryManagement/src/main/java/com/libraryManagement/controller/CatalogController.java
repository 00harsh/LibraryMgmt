package com.libraryManagement.controller;

import com.libraryManagement.entity.Catalog;
import com.libraryManagement.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @PostMapping
    public ResponseEntity<Catalog> addCatalogEntry(@RequestBody Catalog catalog) {
        Catalog newCatalog = catalogService.addCatalogEntry(catalog);
        return ResponseEntity.ok(newCatalog);
    }

    @GetMapping
    public ResponseEntity<List<Catalog>> getAllCatalogEntries() {
        List<Catalog> catalogs = catalogService.getAllCatalogEntries();
        return ResponseEntity.ok(catalogs);
    }

    @GetMapping("/{catalogId}")
    public ResponseEntity<Optional<Catalog>> getCatalogEntryById(@PathVariable int catalogId) {
        Optional<Catalog> catalog = catalogService.getCatalogEntryById(catalogId);
        return ResponseEntity.ok(catalog);
    }

    @PutMapping("/{catalogId}")
    public ResponseEntity<Catalog> updateCatalogEntry(@PathVariable int catalogId, @RequestBody Catalog catalogDetails) {
        Catalog updatedCatalog = catalogService.updateCatalogEntry(catalogId, catalogDetails);
        return ResponseEntity.ok(updatedCatalog);
    }

    @DeleteMapping("/{catalogId}")
    public ResponseEntity<Integer> deleteCatalogEntry(@PathVariable int catalogId) {
        catalogService.deleteCatalogEntry(catalogId);
        return ResponseEntity.ok(catalogId);
    }
}
