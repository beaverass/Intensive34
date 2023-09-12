package ru.aston.morozov_aa.task4.work_with_db.models;

import java.sql.Date;
import java.util.Objects;

public class Order {
    private Integer id;
    private String name;
    private Date orderDate;
    private Integer shipperId;

    public Order() {
    }

    public Order(String name, Date orderDate, Integer shipperId) {
        this.name = name;
        this.orderDate = orderDate;
        this.shipperId = shipperId;
    }

    public Order(Integer id, String name, Date orderDate, Integer shipperId) {
        this.id = id;
        this.name = name;
        this.orderDate = orderDate;
        this.shipperId = shipperId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!Objects.equals(id, order.id)) return false;
        if (!Objects.equals(name, order.name)) return false;
        if (!Objects.equals(orderDate, order.orderDate)) return false;
        return Objects.equals(shipperId, order.shipperId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (shipperId != null ? shipperId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderDate=" + orderDate +
                ", shipperId=" + shipperId +
                '}';
    }
}
