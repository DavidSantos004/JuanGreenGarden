package com.JuanGreenGarden.Gardening.domain.repository;

import java.math.BigDecimal;
import java.util.Date;
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

    /**
     * Busca los pagos realizados entre dos fechas específicas.
     * 
     * @param startDate Fecha de inicio del rango de búsqueda.
     * @param endDate   Fecha de fin del rango de búsqueda.
     * @return          Lista de pagos realizados entre las fechas especificadas.
     */
    List<Payment> findByPaymentDateBetween(Date startDate, Date endDate);

    /**
     * Consulta personalizada para obtener la fecha del primer y último pago realizado por cada cliente.
     *
     * @return Lista de arrays de objetos que contienen el nombre y apellidos del cliente, así como la fecha del primer y último pago.
     */
    @Query("SELECT c.customerName, c.contactFirstName, c.contactLastName, MIN(p.paymentDate), MAX(p.paymentDate) " +
           "FROM Customer c LEFT JOIN Payment p ON c.customerNumber = p.customerField2.customerNumber " +
           "GROUP BY c.customerNumber, c.customerName, c.contactFirstName, c.contactLastName")
    List<Object[]> findFirstAndLastPaymentDatesForCustomers();

    /**
     * Consulta para encontrar la suma total de los pagos agrupados por año.
     * @return Lista de arreglos de objetos, donde cada arreglo contiene el año y la suma total de pagos para ese año.
     */
    @Query("SELECT YEAR(p.paymentDate) AS year, SUM(p.amount) AS totalAmount FROM Payment p GROUP BY YEAR(p.paymentDate)")
    List<Object[]> findTotalPaymentsByYear();

    /**
     * Busca los pagos de clientes junto con los representantes de ventas asociados y la ciudad de la oficina del representante.
     *
     * @return Lista de arrays de objetos que contienen el nombre del cliente, el nombre y apellido del representante de ventas, y la ciudad de la oficina.
     */
    @Query("SELECT c.customerName, e.firstName, e.lastName1, o.city FROM Customer c " +
            "JOIN c.customers2 p " +
            "JOIN c.employeeField e " +
            "JOIN e.officeField o")
    List<Object[]> findCustomerPaymentsAndRepresentatives();
}
