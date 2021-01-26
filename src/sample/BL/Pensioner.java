package sample.BL;

public class Pensioner extends Person {
    protected int penSale = 50;

    public int getPenSale() {
        return penSale;
    }

    public void setPenSale(int penSale) {
        this.penSale = penSale;
    }

    public Pensioner(int id, String name, String lastname, int year, int dok, int tel, String email, String tariff, int price, int penSale) {
        super(id, name, lastname, year, dok, tel, email, tariff, price);
        this.penSale = penSale;
    }
}
