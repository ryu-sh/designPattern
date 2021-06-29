package designPattern.builder.case1;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String gender;
    private boolean driverLicenseYn;
    private boolean marriedYn;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isDriverLicenseYn() {
        return driverLicenseYn;
    }

    public void setDriverLicenseYn(boolean driverLicenseYn) {
        this.driverLicenseYn = driverLicenseYn;
    }

    public boolean isMarriedYn() {
        return marriedYn;
    }

    public void setMarriedYn(boolean marriedYn) {
        this.marriedYn = marriedYn;
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }
}
