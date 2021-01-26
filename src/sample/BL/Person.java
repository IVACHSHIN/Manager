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
    private int sale = 30;

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public Person(int sale) {
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1920)
            this.year = year;
        else
            throw new IllegalArgumentException("Year must greater than or equal to 0");
    }


    public int getDok() {
        return dok;
    }

    public void setDok(int dok) {
        this.dok = dok;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person(int id, String name, String lastname, int year, int dok, int tel,
                  String email, String tariff, int price) {
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
}