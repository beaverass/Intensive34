package ru.aston.morozov_aa.task4.work_with_db.dto;

public class UserJoinOrderDTO {
    private Integer id;
    private String fullName;
    private String email;
    private String orderName;
    private String orderShipperName;

    public UserJoinOrderDTO() {
    }

    public UserJoinOrderDTO(Integer id, String fullName, String email, String orderName, String orderShipperName) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.orderName = orderName;
        this.orderShipperName = orderShipperName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public String toString() {
        return "UserJoinOrderDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderShipperName='" + orderShipperName + '\'' +
                '}';
    }
}
