package no.comp.astn2025.entity;

import java.time.LocalDate;
import java.util.Objects;

public class UserInfo {
    private String firstname;
    private String lastname;
    private String patronymic;
    private String country;
    private String city;
    private String address;
    private LocalDate dob;
    private String telephoneNumber;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(firstname, userInfo.firstname) && Objects.equals(lastname, userInfo.lastname) && Objects.equals(patronymic, userInfo.patronymic) && Objects.equals(country, userInfo.country) && Objects.equals(city, userInfo.city) && Objects.equals(address, userInfo.address) && Objects.equals(dob, userInfo.dob) && Objects.equals(telephoneNumber, userInfo.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, patronymic, country, city, address, dob, telephoneNumber);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }

    public class UserInfoBuilder {
        public UserInfoBuilder setFirstname(String firstname) {
            UserInfo.this.setFirstname(firstname);
            return this;
        }

        public UserInfoBuilder setLastname(String lastname) {
            UserInfo.this.setLastname(lastname);
            return this;
        }

        public UserInfoBuilder setPatronymic(String patronymic) {
            UserInfo.this.setPatronymic(patronymic);
            return this;
        }

        public UserInfoBuilder setCountry(String country) {
            UserInfo.this.setCountry(country);
            return this;
        }

        public UserInfoBuilder setCity(String city) {
            UserInfo.this.setCity(city);
            return this;
        }

        public UserInfoBuilder setAddress(String address) {
            UserInfo.this.setAddress(address);
            return this;
        }

        public UserInfoBuilder setTelephoneNumber(String number) {
            UserInfo.this.setTelephoneNumber(number);
            return this;
        }

        public UserInfoBuilder setDob(LocalDate dob) {
            UserInfo.this.setDob(dob);
            return this;
        }

        public UserInfo build() {
            return UserInfo.this;
        }
    }
}
