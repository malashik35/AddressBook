import org.junit.Before;
import org.junit.Test;
import packageForClasses.Address;
import packageForClasses.AddressBook;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddressBookTests {
    //тестирование
    //создание новой пустой адресной книги
    private AddressBook personAddress = new AddressBook();

    @Before
    public void setUpAddressBook() {
        personAddress.addNewRecord("Ivanov", "Popova", 78, 15);
        personAddress.addNewRecord("Petrov", "Isakova", 1, 88);
        personAddress.addNewRecord("Sidorov", "Lenina", 9, 99);
    }

    @Test
    public void addNewRecord() throws Exception {
        personAddress.addNewRecord("Malakhov", "Lazurnaya", 19, 23);
        assertEquals(new Address("Lazurnaya", 19, 23), personAddress.getAddress("Malakhov"));
    }

    @Test
    public void removePerson() throws Exception {
        personAddress.removePerson("Ivanov");
        assertEquals(null, personAddress.getAddress("Ivanov"));

        personAddress.removePerson("Sidorov");
        assertEquals(null, personAddress.getAddress("Sidorov"));
    }

    @Test
    public void changeRecord() throws Exception {
        personAddress.changeRecord("Sidorov", "Baltiyskaya", 35, 1);
        assertEquals(new Address("Baltiyskaya", 35, 1), personAddress.getAddress("Sidorov"));

        personAddress.changeRecord("Petrov", "Popova", 56, 77);
        assertEquals(new Address("Popova", 56, 77), personAddress.getAddress("Petrov"));
    }

    @Test
    public void getPeopleByStreet() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Ivanov");

        List<String> peopleOnPopova = personAddress.getPeopleByStreet("Popova");
        assertEquals(list, peopleOnPopova);
    }

    @Test
    public void getPeopleByHouse() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Ivanov");

        List<String> peopleOnPopova78 = personAddress.getPeopleByHouse("Popova", 78);
        assertEquals(list, peopleOnPopova78);
    }
}