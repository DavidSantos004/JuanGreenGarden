package com.JuanGreenGarden.Gardening.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetail;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}