package com.JuanGreenGarden.Gardening.persistence.entity.DTO;

import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;

public class OrderDetailDTO {
    private OrderDetailId orderDetailId;
    private Integer quantityOrdered;
    private double priceEach;


    public OrderDetailId getOrderDetailId() {
        return this.orderDetailId;
    }

    public void setOrderDetailId(OrderDetailId orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getQuantityOrdered() {
        return this.quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getPriceEach() {
        return this.priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

}
