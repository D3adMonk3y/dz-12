public class Woman extends Person{
    private final String previousLastName;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        previousLastName = lastName;
    }

    public String getPreviousLastName() {
        return previousLastName;
    }

    @Override
    public boolean isRetired() {
        return getAge() > 60;
    }

    @Override
    public void registerPartnership(Person person) {
        if(!isHasRegisteredPartnership() && !person.isHasRegisteredPartnership()){
            person.setHasRegisteredPartnership(true);
            person.setPartner(this);

            if(person instanceof Man){
                setLastName(person.getLastName());
            }

            setHasRegisteredPartnership(true);
            this.setPartner(person);
        }
    }

    public void deregisterPartnership(boolean returnToPreviousLastName) {
        if (isHasRegisteredPartnership() && getPartner().isHasRegisteredPartnership()) {
            getPartner().setHasRegisteredPartnership(false);
            getPartner().setPartner(null);
            setHasRegisteredPartnership(false);
            setPartner(null);
            if(returnToPreviousLastName)
                setLastName(previousLastName);
        }
    }


}
