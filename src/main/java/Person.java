public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Person partner;

    private boolean hasRegisteredPartnership;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // getters and setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public boolean isHasRegisteredPartnership() {
        return hasRegisteredPartnership;
    }

    public void setHasRegisteredPartnership(boolean hasRegisteredPartnership) {
        this.hasRegisteredPartnership = hasRegisteredPartnership;
    }

    public abstract boolean isRetired();

    public abstract void deregisterPartnership(boolean returnToPreviousLastName);

    public abstract void registerPartnership(Person person);


}
