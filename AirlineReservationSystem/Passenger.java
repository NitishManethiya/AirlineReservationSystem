package AirlineReservationSystem;

public class Passenger {
    private String name;
    private int age;
    private String gender;

    public Passenger(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Passenger(String name) {
        this(name, 0, "Not Specified");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) { this.age = age; }

    public void setGender(String gender) { this.gender = gender; }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Gender: " + gender;
    }
}

