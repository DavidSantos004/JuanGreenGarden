package com.JuanGreenGarden.Gardening.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.Payment;
import com.JuanGreenGarden.Gardening.persistence.entity.Product;

/**
 * Repositorio para la entidad Payment.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    /**
     * Encuentra los números de cliente distintos en el año 2008.
     * 
     * @return Lista de números de cliente distintos en el año 2008.
     */
    @Query("SELECT DISTINCT p.customerNumber FROM Payment p WHERE YEAR(p.paymentDate) = 2008")
    List<Integer> findDistinctCustomerNumbersIn2008();

    /**
     * Encuentra los pagos realizados en un año específico y utilizando un método de pago específico.
     * 
     * @param year Año de los pagos.
     * @param method Método de pago.
     * @return Lista de pagos que cumplen con los criterios especificados.
     */
    @Query("SELECT p FROM Payment p WHERE YEAR(p.paymentDate) = :year AND p.paymentMethod = :method ORDER BY p.paymentDate DESC")
    List<Payment> findByYearAndMethod(@Param("year") int year, @Param("method") String method);

    /**
     * Encuentra todos los métodos de pago distintos.
     * 
     * @return Lista de métodos de pago distintos.
     */
    @Query("SELECT DISTINCT p.paymentMethod FROM Payment p")
    List<String> findAllPaymentMethods();


}
