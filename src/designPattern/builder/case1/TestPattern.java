package designPattern.builder.case1;

public class TestPattern {
    public static void main(String[] args) {
        Person p1 = Person.builder()
                        .FirstName("ryu")
                        .LastName("sungho")
                        .Address("가산")
                        .Gender("male")
                        .MarriedYn(false)
                        .build();
        System.out.println("p1.getLastName() = " + p1.getLastName());
    }
}
