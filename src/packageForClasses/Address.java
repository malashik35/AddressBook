package packageForClasses;

/*класс, хранящий адрес одного человека, состоящий из улицы, дома, квартиры*/
public class Address {
    String street;
    int house;
    int flat;

    //конструктор - заполнение полей при создании экземпляра объекта
    public Address(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return house == address.house &&
                flat == address.flat &&
                street.equals(address.street);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + house;
        result = 31 * result + flat;
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", house=" + house +
                ", flat=" + flat +
                '}';
    }
}