public class Man extends Person{


    public Man(String firstName, String lastName, int age)  {
        super(firstName, lastName, age);
    }

    @Override
    public boolean isRetired() {
        return super.getAge() > 65;
    }


    public void registerPartnership(Person person) {
        if(!isHasRegisteredPartnership() && !person.isHasRegisteredPartnership()){
            person.setHasRegisteredPartnership(true);
            person.setPartner(this);
            if(person instanceof Woman){
                person.setLastName(getLastName());
            }
            setHasRegisteredPartnership(true);
            this.setPartner(person);
        }
    }

    public void deregisterPartnership(boolean returnToPreviousLastName) {
        if (isHasRegisteredPartnership() && getPartner().isHasRegisteredPartnership()) {
            getPartner().setHasRegisteredPartnership(false);
            getPartner().setPartner(null);
            if(returnToPreviousLastName && getPartner() instanceof Woman){
                getPartner().setLastName(((Woman)getPartner()).getPreviousLastName());
            }
            setHasRegisteredPartnership(false);
            setPartner(null);
        }
    }
}
