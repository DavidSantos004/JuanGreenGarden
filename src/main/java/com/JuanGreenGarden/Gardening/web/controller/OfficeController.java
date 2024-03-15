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

import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
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
        if (office != null){
            return new ResponseEntity<>(office, HttpStatus.OK);
        } else {
            throw new NotFoundEndPoint("Office With ID " + officeCode + " not found");
        }
       
    }


}
