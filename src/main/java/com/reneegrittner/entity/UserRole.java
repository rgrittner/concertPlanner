package com.reneegrittner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "UserRole")
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "role_name")
    private String userRole;

    public UserRole() {
    }

    public UserRole(String userName, String userRole) {
        this.userName = userName;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole1 = (UserRole) o;
        return id == userRole1.id &&
                Objects.equals(userName, userRole1.userName) &&
                Objects.equals(userRole, userRole1.userRole);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, userRole);
    }
}
