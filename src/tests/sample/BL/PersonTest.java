package sample.BL;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person(1,"Кристина","Григорьева",1999,230120,
                6132137,"grigorivak@mail.ru","Студент",5000);
    }

    @Test
    public void getId() {
    }

    @Test
    public void setId() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getLastname() {
    }

    @Test
    public void setLastname() {
    }

    @Test
    public void getYear() {
    }

    @Test
    public void setYearInvalid() {
        try {
            person.setYear(-100);
            fail("negative Year in setYear() should trigger an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Negative Year: " + e.getMessage());
        }
        catch (Exception e) {
            fail("exception throw for setTear with negative argument");
        }
    }

    @Test
    public void setYear() throws IllegalAccessException {
        person.setYear(2934);
        int expResult = 2934;
        assertEquals(expResult, person.getYear());


    }

    @Test
    public void getDok() {
    }

    @Test
    public void setDok() {
    }

    @Test
    public void getTel() {
    }

    @Test
    public void setTel() {
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void setEmail() {
    }

    @Test
    public void getTariff() {
    }

    @Test
    public void setTariff() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void setPrice() {
    }
}