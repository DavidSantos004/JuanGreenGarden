package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.OfficeRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Office;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OfficeDTO;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<OfficeDTO> getAllOffices() {
        return officeRepository.findAll().stream()
                .map(Office::toDTO)
                .toList();
    }

    public Office getOfficeByCode(String officeCode) {
        return officeRepository.findById(officeCode).orElse(null);
    }

}
