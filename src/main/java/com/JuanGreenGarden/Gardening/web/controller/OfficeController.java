package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.service.OfficeService;
import com.JuanGreenGarden.Gardening.persistence.entity.Office;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public ResponseEntity<List<Office>> getAllOffices() {
        List<Office> offices = officeService.getAllOffices();
        return new ResponseEntity<>(offices, HttpStatus.OK);
    }

    @GetMapping("/{officeCode}")
    public ResponseEntity<Office> getOfficeByCode(@PathVariable String officeCode) {
        Office office = officeService.getOfficeByCode(officeCode);
        return office != null ?
                new ResponseEntity<>(office, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Office> createOffice(@RequestBody Office office) {
        Office createdOffice = officeService.createOrUpdateOffice(office);
        return new ResponseEntity<>(createdOffice, HttpStatus.CREATED);
    }

    @PutMapping("/{officeCode}")
    public ResponseEntity<Office> updateOffice(@PathVariable String officeCode, @RequestBody Office office) {
        office.setOfficeCode(officeCode);
        Office updatedOffice = officeService.createOrUpdateOffice(office);
        return new ResponseEntity<>(updatedOffice, HttpStatus.OK);
    }

    @DeleteMapping("/{officeCode}")
    public ResponseEntity<Void> deleteOffice(@PathVariable String officeCode) {
        officeService.deleteOffice(officeCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
