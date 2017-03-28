import org.junit.Before;
import org.junit.Test;
import packageForClasses.Address;
import packageForClasses.AddressBook;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
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
        personAddress.addNewRecord("Dorosh", "Lenina", 9, 88);
    }

    @Test
    public void addNewRecord() throws Exception {
        personAddress.addNewRecord("Malakhov", "Lazurnaya", 19, 23);
        assertEquals(new Address("Lazurnaya", 19, 23), personAddress.getAddress("Malakhov"));
        personAddress.removePerson("Malakhov");
    }

    @Test
    public void removePerson() throws Exception {

        assertEquals("Удалено", personAddress.removePerson("Ivanov"));
        assertTrue(personAddress.getAddress("Petrov").equals(personAddress.getAddress("Petrov")));
        assertTrue(personAddress.getAddress("Sidorov").equals(personAddress.getAddress("Sidorov")));
        assertTrue(personAddress.getAddress("Dorosh").equals(personAddress.getAddress("Dorosh")));
        personAddress.addNewRecord("Ivanov", "Popova", 78, 15);


        assertEquals("Такого человека нет", personAddress.removePerson("Malakhov"));
        assertTrue(personAddress.getAddress("Ivanov").equals(personAddress.getAddress("Ivanov")));
        assertTrue(personAddress.getAddress("Sidorov").equals(personAddress.getAddress("Sidorov")));
        assertTrue(personAddress.getAddress("Petrov").equals(personAddress.getAddress("Petrov")));
        assertTrue(personAddress.getAddress("Dorosh").equals(personAddress.getAddress("Dorosh")));
    }


    @Test
    public void changeRecord() throws Exception {
        assertEquals("Изменено", personAddress.changeRecord("Sidorov", "Baltiyskaya", 35, 1));
        personAddress.changeRecord("Sidorov", "Lenina", 9, 99);

        assertEquals("Изменено", personAddress.changeRecord("Petrov", "Popova", 56, 77));
        personAddress.changeRecord("Petrov", "Isakova", 1, 88);

        assertEquals("Такого человека нет", personAddress.changeRecord("Malakhov", "Nevskiy", 1, 1));

    }

    @Test
    public void getPeopleByStreet() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Ivanov");
        List<String> peopleOnPopova = personAddress.getPeopleByStreet("Popova");
        assertEquals(list, peopleOnPopova);

        List<String> list1 = new ArrayList<>();
        List<String> peopleOnKharchenko = personAddress.getPeopleByStreet("Kharchenko");
        assertEquals(list1, peopleOnKharchenko);

        List<String> list2 = new ArrayList<>();
        list2.add("Dorosh");
        list2.add("Sidorov");
        List<String> peopleOnLenina = personAddress.getPeopleByStreet("Lenina");
        assertEquals(list2, peopleOnLenina);
    }

    @Test
    public void getPeopleByHouse() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Ivanov");
        List<String> peopleOnPopova78 = personAddress.getPeopleByHouse("Popova", 78);
        assertEquals(list, peopleOnPopova78);

        List<String> list1 = new ArrayList<>();
        List<String> peopleOnKharchenko16 = personAddress.getPeopleByHouse("Kharchenko", 16);
        assertEquals(list1, peopleOnKharchenko16);

        List<String> list2 = new ArrayList<>();
        list2.add("Dorosh");
        list2.add("Sidorov");
        List<String> peopleOnLenina9 = personAddress.getPeopleByHouse("Lenina", 9);
        assertEquals(list2, peopleOnLenina9);
    }
}