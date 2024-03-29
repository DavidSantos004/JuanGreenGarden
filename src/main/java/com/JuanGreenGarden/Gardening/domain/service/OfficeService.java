package com.JuanGreenGarden.Gardening.domain.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.OfficeRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Customer;
import com.JuanGreenGarden.Gardening.persistence.entity.Office;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OfficeDTO;

/**
 * Servicio para operaciones relacionadas con las oficinas.
 */
@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    /**
     * Obtiene todas las oficinas.
     * 
     * @return Una lista de todas las oficinas.
     */
    public List<OfficeDTO> getAllOffices() {
        return officeRepository.findAll().stream()
                .map(Office::toDTO)
                .toList();
    }

    /**
     * Obtiene una oficina por su código.
     * 
     * @param officeCode El código de la oficina a obtener.
     * @return La oficina correspondiente al código especificado.
     */
    public Office getOfficeByCode(String officeCode) {
        return officeRepository.findById(officeCode).orElse(null);
    }


    /**
     * Convierte un arreglo de objetos en un DTO de oficina.
     * 
     * @param objects         El arreglo de objetos.
     * @param propertyIndices Un mapa que mapea los nombres de las propiedades del DTO a los índices en el arreglo de objetos.
     * @return El DTO de oficina creado a partir del arreglo de objetos.
     */
    private OfficeDTO convertToObject(Object[] objects, Map<String, Integer> propertyIndices) {
        if (objects == null || objects.length < propertyIndices.size()) {
            throw new IllegalArgumentException("The array of objects is null or doesn't have enough elements");
        }
        OfficeDTO dto = new OfficeDTO();
        propertyIndices.forEach((propertyName, index) -> {
            switch (propertyName) {
                case "officeCode":
                    dto.setOfficeCode((String) objects[index]);
                    break;
                case "city":
                    dto.setCity((String) objects[index]);
                    break;
                case "country":
                    dto.setCountry((String) objects[index]);
                    break;
                case "region":
                    dto.setRegion((String) objects[index]);
                    break;
                case "postalCode":
                    dto.setPostalCode((String) objects[index]);
                    break;
                case "phone":
                    dto.setPhone((String) objects[index]);
                    break;
                case "address1":
                    dto.setAddressLine1((String) objects[index]);
                    break;
                case "address2":
                    dto.setAddressLine2((String) objects[index]);
                    break;
            }
        });
        return dto;
    }

    /**
     * Obtiene una lista de DTO de oficina a partir de una lista de arreglos de objetos y un mapa de índices de propiedades.
     * 
     * @param objectList      La lista de arreglos de objetos.
     * @param propertyIndices El mapa de índices de propiedades.
     * @return Una lista de DTO de oficina.
     */
    public List<OfficeDTO> getOfficeDTOListFromObjectArray(List<Object[]> objectList,
            Map<String, Integer> propertyIndices) {
        return objectList.stream()
                .map(objects -> convertToObject(objects, propertyIndices))
                .collect(Collectors.toList());
    }

    /**
     * Obtiene los códigos de oficina y las ciudades.
     * 
     * @return Una lista de mapas donde cada mapa contiene el código de la oficina y la ciudad.
     */
     public List<Map<Object, Object>> OfficeCodeAndCity() {
         List<Object[]> results = officeRepository.OfficeCodeAndCity();
            List<Map<Object, Object>> resultsModel = new ArrayList<>();

            for (Object[] result : results) {
                Map model = new LinkedHashMap<>();
                model.put("officeCode", result[0]);
                model.put("officeCity", result[1]);
                resultsModel.add(model);
            }

            return resultsModel;

 
    }


    /**
     * Obtiene las oficinas en España.
     * 
     * @return Una lista de arreglos de objetos donde cada arreglo contiene la ciudad y el teléfono de las oficinas en España.
     */
    public List<Object[]> getOfficesInSpain() {
        return officeRepository.findOfficesInSpain();
    }

    /**
     * Obtiene las direcciones de las oficinas que tienen clientes en Fuenlabrada.
     * 
     * @return Lista de direcciones de las oficinas con clientes en Fuenlabrada.
     */
    public List<String> getOfficeAddressesWithCustomersInFuenlabrada() {
        return officeRepository.findOfficeAddressesWithCustomersInFuenlabrada();
    } 

   

}
