package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.OfficeService;
import com.JuanGreenGarden.Gardening.persistence.entity.Office;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OfficeDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * Controlador REST para operaciones relacionadas con las oficinas.
 */
@RestController
@RequestMapping("/api/offices")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Obtiene todas las oficinas.
     * 
     * @return Una respuesta con una lista de todas las oficinas.
     */
    @GetMapping
    public ResponseEntity<List<OfficeDTO>> getAllOffices() {
        List<OfficeDTO> offices = officeService.getAllOffices();
        return new ResponseEntity<>(offices, HttpStatus.OK);
    }

    /**
     * Obtiene una oficina por su código.
     * 
     * @param officeCode El código de la oficina a obtener.
     * @return Una respuesta con la oficina correspondiente al código especificado.
     * @throws NotFoundEndPoint Si no se encuentra ninguna oficina con el código especificado.
     */
    @GetMapping("/{officeCode}")
    public ResponseEntity<Office> getOfficeByCode(@PathVariable String officeCode) {
        Office office = officeService.getOfficeByCode(officeCode);
        if (office != null){
            return new ResponseEntity<>(office, HttpStatus.OK);
        } else {
            throw new NotFoundEndPoint("Office With ID " + officeCode + " not found");
        }  
    }
    
    /**
     * Obtiene los códigos de oficina y las ciudades.
     * 
     * @return Una lista de mapas donde cada mapa contiene el código de la oficina y la ciudad.
     */
    @GetMapping("/office-code-and-city")
    public List<Map<Object, Object>> getAndCodeAndCyty() {
        return  officeService.OfficeCodeAndCity();
    }

    /**
     * Obtiene las oficinas en España.
     * 
     * @return Una respuesta con una lista de arreglos de objetos donde cada arreglo contiene la ciudad y el teléfono de las oficinas en España.
     */
    @GetMapping("/offices-in-spain")
    public ResponseEntity<List<Object[]>> getOfficesInSpain() {
        List<Object[]> offices = officeService.getOfficesInSpain();
        return new ResponseEntity<>(offices, HttpStatus.OK);
    }

    /**
     * Obtiene las direcciones de las oficinas que tienen clientes en Fuenlabrada.
     * 
     * @return Lista de direcciones de las oficinas con clientes en Fuenlabrada.
     */
    @GetMapping("/addresses-in-fuenlabrada")
    public List<String> getOfficeAddressesWithCustomersInFuenlabrada() {
        return officeService.getOfficeAddressesWithCustomersInFuenlabrada();
    }
    
    
}
