package org.loginsystem;

import javax.validation.constraints.NotNull;

public class Login {

    @NotNull(message = "is required!")
    private String email;

    @NotNull(message = "is required!")
    private String password;

    public Login(){

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
        return "Login{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
