package no.comp.astn2025.entity;

import java.util.Objects;

public class User extends Entity {
    private String email;
    private String password;

    private UserInfo uInfo;

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

    public UserInfo getuInfo() {
        return uInfo;
    }

    public void setuInfo(UserInfo uInfo) {
        this.uInfo = uInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return email.equals(user.email) && password.equals(user.password) && Objects.equals(uInfo, user.uInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, uInfo);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", uInfo=" + uInfo +
                "} " + super.toString();
    }
}
