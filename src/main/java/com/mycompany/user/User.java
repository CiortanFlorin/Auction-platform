package com.mycompany.user;


import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 128, nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 45)
    private String CompanyName;

    @Column(columnDefinition = "varchar(255) default 'USER'")
    private String Role;

    public String getRole() {
        return Role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
