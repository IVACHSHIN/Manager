package sample.BL;

public class Standard extends Person {
    int stSale = 10;

    public int getStSale() {
        return stSale;
    }

    public void setStSale(int stSale) {
        this.stSale = stSale;
    }

    public Standard(int id, String name, String lastname, int year, int dok, int tel, String email, String tariff, int price, int stSale) {
        super(id, name, lastname, year, dok, tel, email, tariff, price);
        this.stSale = stSale;

    }
}
































