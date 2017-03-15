package pl.sdacademy.model;

/**
 * Created by RENT on 2017-03-15.
 */
public class Company {

    private int id;
    private Address address;
    private String NIP;
    private String name;

    public Company() {
    }

    public Company(int id, Address address, String NIP, String name) {
        this.id = id;
        this.address = address;
        this.NIP = NIP;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", NIP=" + NIP +
                ", name='" + name + '\'' +
                '}';
    }
}
