package ru.aston.morozov_aa.task4.work_with_db.dto;

import java.util.Objects;

public class UserJoinOrderDTO {
    private String id;
    private String fullName;
    private String email;
    private String orderName;
    private String orderShipperName;

    public UserJoinOrderDTO() {
    }

    public UserJoinOrderDTO(String id, String fullName, String email, String orderName, String orderShipperName) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.orderName = orderName;
        this.orderShipperName = orderShipperName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderShipperName() {
        return orderShipperName;
    }

    public void setOrderShipperName(String orderShipperName) {
        this.orderShipperName = orderShipperName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserJoinOrderDTO that = (UserJoinOrderDTO) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(fullName, that.fullName)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(orderName, that.orderName)) return false;
        return Objects.equals(orderShipperName, that.orderShipperName);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        result = 31 * result + (orderShipperName != null ? orderShipperName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserJoinOrderDTO{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderShipperName='" + orderShipperName + '\'' +
                '}';
    }
}
