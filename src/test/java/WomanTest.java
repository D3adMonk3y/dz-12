
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class WomanTest {

    private static String RETIRED_MSG = "Woman %s with age %d should be retired";
    private static String NOT_RETIRED_MSG = "Woman %s with age %d should be retired";

    @DataProvider(name = "personData")
    public Object[][] getPersonData() {
        return new Object[][] {
                { new Woman("Jane", "Doe", 23) },
                { new Woman("Alice", "Johnson", 30) }
        };
    }

    @Test
    @Parameters("womanRetireAge")
    public void testIsRetired(int womanRetireAge) {

        SoftAssert softAssert = new SoftAssert();

        Woman woman1 = new Woman("Alice", "Johnson", 50);
        softAssert.assertFalse(woman1.isRetired(), String.format(NOT_RETIRED_MSG, woman1.getFirstName(), woman1.getAge()));

        woman1.setAge(womanRetireAge);
        softAssert.assertFalse(woman1.isRetired(), String.format(NOT_RETIRED_MSG, woman1.getFirstName(), woman1.getAge()));
        woman1.setAge(womanRetireAge + 1);
        softAssert.assertTrue(woman1.isRetired(), String.format(RETIRED_MSG, woman1.getFirstName(), woman1.getAge()));

        softAssert.assertAll();

    }

    @Test
    public void testRegisterPartnership() {
        Man man = new Man("John", "Doe", 30);
        Woman woman = new Woman("Jane", "Smith", 28);

        woman.registerPartnership(man);

        assertTrue(woman.isHasRegisteredPartnership());
        assertEquals(man, woman.getPartner());
        assertTrue(man.isHasRegisteredPartnership());
        assertEquals(woman, man.getPartner());
    }
    @Test(dataProvider = "personData")
    public void testGetFirstName(Woman woman) {
        String name = woman.getFirstName();
        assertEquals(woman.getFirstName(), name);
    }

    @Test(dataProvider = "personData")
    public void testSetFirstName(Woman woman) {
        String oldName = woman.getFirstName();
        woman.setFirstName("Alice");
        assertEquals(woman.getFirstName(), "Alice");
        woman.setFirstName(oldName);
    }

    @Test(dataProvider = "personData")
    public void testGetLastName(Woman woman) {
        String lastName = woman.getLastName();
        assertEquals(woman.getLastName(), lastName);
    }

    @Test(dataProvider = "personData")
    public void testSetLastName(Woman woman) {
        String oldName = woman.getLastName();
        woman.setLastName("Johnson");
        assertEquals(woman.getLastName(), "Johnson");
        woman.setLastName(oldName);
    }

    @Test(dataProvider = "personData")
    public void testGetAge(Woman woman) {
        int prevAge = woman.getAge();
        woman.setAge(30);
        assertEquals(woman.getAge(), 30);
        woman.setAge(prevAge);
    }

    @Test(dataProvider = "personData")
    public void testSetAge(Woman woman) {
        int prevAge = woman.getAge();
        woman.setAge(30);
        assertEquals(woman.getAge(), 30);
        woman.setAge(prevAge);
    }

    @Test(dataProvider = "personData")
    public void testGetPartner(Woman woman) {
        Woman woman2 = new Woman("Alice", "Johnson", 28);
        woman.setPartner(woman2);
        assertEquals(woman.getPartner(), woman2);
        woman.setPartner(null);
    }

    @Test(dataProvider = "personData")
    public void testSetPartner(Woman woman) {
        Man man = new Man("John", "Johnson", 28);
        woman.setPartner(man);
        assertEquals(woman.getPartner(), man);
        woman.setPartner(null);
    }

    @Test(dataProvider = "personData")
    public void testIsHasRegisteredPartnership(Woman woman) {
        assertFalse(woman.isHasRegisteredPartnership());
    }

    @Test(dataProvider = "personData")
    public void testSetHasRegisteredPartnership(Woman woman) {
        woman.setHasRegisteredPartnership(true);
        assertTrue(woman.isHasRegisteredPartnership());
        woman.setHasRegisteredPartnership(false);
    }


}
