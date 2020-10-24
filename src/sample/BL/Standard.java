package sample.BL;

public class Standard extends Person {
    int sk = 30;
    public Standard(int id, String name, String lastname, int year, int dok, int tel, String email, String tariff, int price) {
        super(id, name, lastname, year, dok, tel, email, tariff, price);
    }

    public void Sprice(int price) {
        price = price - sk * price / 100;
    }
}
