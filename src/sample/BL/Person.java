package sample.BL;

public class Person {
    private int id;
    private String name;
    private String lastname;
    private int year;
    private int dok;
    private int tel;
    private String email;
    private String tariff;
    private int price;



    public Person(int id, String name, String lastname, int year,
                  int dok, int tel, String email, String tariff,
                  int price) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.year = year;
        this.dok = dok;
        this.tel = tel;
        this.email = email;
        this.tariff = tariff;
        this.price = price;


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getYear() {
        return year;
    }

    public int getDok() {
        return dok;
    }

    public int getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getTariff() {
        return tariff;
    }

    public int getPrice() {
        return price;
    }
}