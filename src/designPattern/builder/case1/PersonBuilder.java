package designPattern.builder.case1;

import java.time.LocalDate;

public class PersonBuilder {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String gender;
    private boolean driverLicenseYn;
    private boolean marriedYn;

    public PersonBuilder FirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder LastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder BirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PersonBuilder Address(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder Gender(String gender) {
        this.gender = gender;
        return this;
    }

    public PersonBuilder DriverLicenseYn(boolean driverLicenseYn) {
        this.driverLicenseYn = driverLicenseYn;
        return this;
    }

    public PersonBuilder MarriedYn(boolean marriedYn) {
        this.marriedYn = marriedYn;
        return this;
    }

    public Person build(){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        person.setAddress(address);
        person.setBirthDate(birthDate);
        person.setGender(gender);
        person.setMarriedYn(marriedYn);
        person.setDriverLicenseYn(driverLicenseYn);
        return person;
    }
}
