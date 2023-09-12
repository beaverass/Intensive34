package ru.aston.morozov_aa.task4.work_with_db.models;

import java.sql.Date;
import java.util.Objects;

public class User {

    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private Date birthday;
    private Integer orderId;

    public User() {
    }

    public User(Integer id, String fullName, String phoneNumber, String email, Date birthday, Integer orderId) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
        this.orderId = orderId;
    }

    public User(String fullName, String phoneNumber, String email, Date birthday, Integer orderId) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
        this.orderId = orderId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(fullName, user.fullName)) return false;
        if (!Objects.equals(phoneNumber, user.phoneNumber)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(birthday, user.birthday)) return false;
        return Objects.equals(orderId, user.orderId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", orderId=" + orderId +
                '}';
    }
}
