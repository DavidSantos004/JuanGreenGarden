package com.JuanGreenGarden.Gardening.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.Office;

/**
 * Repositorio para acceder a la tabla de oficinas.
 */
@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {
    
    /**
     * Consulta para obtener los códigos de oficina y las ciudades.
     * 
     * @return Una lista de arreglos de objetos donde cada arreglo contiene el código de la oficina y la ciudad.
     */
    @Query("SELECT o.officeCode, o.city FROM Office o")
    List<Object[]> OfficeCodeAndCity();

    /**
     * Consulta para obtener las oficinas en España.
     * 
     * @return Una lista de arreglos de objetos donde cada arreglo contiene la ciudad y el teléfono de las oficinas en España.
     */
    @Query("SELECT o.city, o.phone FROM Office o WHERE o.country = 'España'")
    List<Object[]> findOfficesInSpain();
}
