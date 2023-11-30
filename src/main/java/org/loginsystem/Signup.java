package org.loginsystem;

import jakarta.persistence.Entity;
import org.customannotations.MatchPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Signup {

    @NotNull(message = "is required!")
    private String email;

    @NotNull(message="is required!")
    @Size(min = 6, message = "minimum password length 6!")
    private String password;

    @NotNull(message = "is required!")
    private String confirmPassword;

    public Signup(){

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "Signup{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
