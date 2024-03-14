package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.OfficeRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Office;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office getOfficeByCode(String officeCode) {
        return officeRepository.findById(officeCode).orElse(null);
    }

    public Office createOrUpdateOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteOffice(String officeCode) {
        officeRepository.deleteById(officeCode);
    }
}
