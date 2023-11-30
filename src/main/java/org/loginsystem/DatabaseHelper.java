package org.loginsystem;

import jakarta.persistence.*;

@Entity
@Table(name = "details")
public class DatabaseHelper {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email_id")
    private String email;

    @Column(name = "password")
    private String password;

    public DatabaseHelper(){

    }

    public DatabaseHelper(String email, String password){
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "DatabaseHelper{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
