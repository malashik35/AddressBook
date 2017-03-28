package packageForClasses;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AddressBook {
    //map, хранящий пары фамилия - адрес //ключ - фамилия, значение - адрес
    private Map<String, Address> personAddress;

    //конструктор класса заполняет поля класса при создании экземпляра
    public AddressBook() {
        personAddress = new ConcurrentHashMap<>(); //создаём пустой map
    }

    //метод добавления нового человека в записную книгу
    public void addNewRecord(final String name, final String street, final int house, final int flat) {
        personAddress.put(name, new Address(street, house, flat));
        //доабвляем запись фамилия - адрес, создавая новый эземпляр класса Address
        // (для этого вызываем конструктор класса Address, передавая ему эти значения полей
    }

    //метод удаления человека
    public String removePerson(final String name) {
        Address address = personAddress.get(name);
        if (address == null) {
            return "Такого человека нет";
        } else {
            for (Map.Entry<String, Address> name1 : personAddress.entrySet()) {
                if (Objects.equals(name, name1.getKey())) { //если такой человек есть
                    personAddress.remove(name);
                }
            }
        }
        return "Удалено";
    }

    //изменение адреса человека
    public String changeRecord(final String name, final String newStreet, final int newHouse, final int newFlat) {
        Address address = personAddress.get(name);
        if (address == null) {
            return "Такого человека нет";
        }
            else{
            for (Map.Entry<String, Address> name1 : personAddress.entrySet()) {
                if (Objects.equals(name, name1.getKey())) { //если такой человек есть
                    address.setStreet(newStreet);
                    address.setHouse(newHouse);
                    address.setFlat(newFlat);

                }
            }
            return "Изменено";
        }
    }

    //получение адреса человека
    //если такого человека нет, вернёт null
    public Address getAddress(final String name) {
        return personAddress.get(name);
    }

    //получение списка людей, живущих на заданной улице
    public List<String> getPeopleByStreet(final String street) {
        //пустой список людей
        List<String> people = new ArrayList<>();

        //entrySet - содержимое адресной книги
        for (Map.Entry<String, Address> record : personAddress.entrySet()) {
            if (record.getValue().getStreet().equals(street)) { //если улица совпадает
                people.add(record.getKey());
            }
        }
        return people;
    }

    //получение списка людей, живущих в заданном доме
    public List<String> getPeopleByHouse(final String street, final int house) {
        //пустой список людей
        List<String> people = new ArrayList<>();
        //entrySet - содержимое адресной книги
        //пока есть следующая запись в списке
        for (Map.Entry<String, Address> record : personAddress.entrySet()) {
            Address address = record.getValue();
            if (address.getStreet().equals(street) && address.getHouse() == house) {//если улица и дом совпадают
                people.add(record.getKey());
            }
        }
        return people;
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (this == o) return true;
            if (!(o instanceof AddressBook)) return false;
            AddressBook that = (AddressBook) o;
            return personAddress.equals(that.personAddress);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return personAddress.hashCode();
    }

    @Override
    public String toString() {
        return "AddressBook{" + personAddress + '}';
    }
}

