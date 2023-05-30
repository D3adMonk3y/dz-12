

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class ManTest {

    private static String RETIRED_MSG = "Man %s with age %d should be retired";
    private static String NOT_RETIRED_MSG = "Man %s with age %d should be retired";

    @DataProvider(name = "personData")
    public Object[][] getPersonData() {
        return new Object[][] {
                { new Man("John", "Doe", 30) },
                { new Man("Adam", "Smith", 35) }
        };
    }

    @Test
    @Parameters("manRetireAge")
    public void testIsRetired(int manRetireAge) {
        SoftAssert softAssert = new SoftAssert();

        Man man1 = new Man("Adam", "Johnson", 50);
        softAssert.assertFalse(man1.isRetired(), String.format(NOT_RETIRED_MSG, man1.getFirstName(), man1.getAge()));

        man1.setAge(manRetireAge);
        softAssert.assertFalse(man1.isRetired(), String.format(NOT_RETIRED_MSG, man1.getFirstName(), man1.getAge()));
        man1.setAge(manRetireAge + 1);
        softAssert.assertTrue(man1.isRetired(), String.format(RETIRED_MSG, man1.getFirstName(), man1.getAge()));

        softAssert.assertAll();
    }

    @Test
    public void testRegisterPartnership() {
        Man man1 = new Man("John", "Doe", 30);
        Woman woman1 = new Woman("Jane", "Smith", 28);

        man1.registerPartnership(woman1);

        assertTrue(man1.isHasRegisteredPartnership());
        assertEquals(woman1, man1.getPartner());
        assertTrue(woman1.isHasRegisteredPartnership());
        assertEquals(man1, woman1.getPartner());
    }

    @Test(dataProvider = "personData")
    public void testGetFirstName(Man man) {
        String name = man.getFirstName();
        assertEquals(man.getFirstName(), name);
    }

    @Test(dataProvider = "personData")
    public void testSetFirstName(Man man) {
        String prevName = man.getFirstName();
        man.setFirstName("Adam");
        assertEquals(man.getFirstName(), "Adam");
        man.setFirstName(prevName);
    }

    @Test(dataProvider = "personData")
    public void testGetLastName(Man man) {
        String lastName = man.getLastName();
        assertEquals(man.getLastName(), lastName);
    }

    @Test(dataProvider = "personData")
    public void testSetLastName(Man man) {
        String prevName = man.getLastName();
        man.setLastName("Smith");
        assertEquals(man.getLastName(), "Smith");
        man.setLastName(prevName);
    }

    @Test(dataProvider = "personData")
    public void testGetAge(Man man) {
        int previousAge = man.getAge();
        man.setAge(40);
        assertEquals(man.getAge(), 40);
        man.setAge(previousAge);
    }

    @Test(dataProvider = "personData")
    public void testSetAge(Man man) {
        int previousAge = man.getAge();
        man.setAge(40);
        assertEquals(man.getAge(), 40);
        man.setAge(previousAge);
    }

    @Test(dataProvider = "personData")
    public void testGetPartner(Man man) {
        Woman woman = new Woman("Jane", "Smith", 35);
        man.setPartner(woman);
        assertEquals(man.getPartner(), woman);
        man.setPartner(null);
    }

    @Test(dataProvider = "personData")
    public void testSetPartner(Man man)  {
        Woman woman = new Woman("Jane", "Smith", 35);
        man.setPartner(woman);
        assertEquals(man.getPartner(), woman);
        man.setPartner(null);
    }

    @Test(dataProvider = "personData")
    public void testIsHasRegisteredPartnership(Man man) {
        assertFalse(man.isHasRegisteredPartnership());
    }

    @Test(dataProvider = "personData")
    public void testSetHasRegisteredPartnership(Man man) {
        man.setHasRegisteredPartnership(true);
        assertTrue(man.isHasRegisteredPartnership());
        man.setHasRegisteredPartnership(false);
    }

}

