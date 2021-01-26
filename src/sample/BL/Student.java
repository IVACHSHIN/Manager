package sample.BL;

public class Student extends Person {
    protected int studSale = 30;

    public int getStudSale() {
        return studSale;
    }

    public void setStudSale(int studSale) {
        this.studSale = studSale;
    }

    public Student(int id, String name, String lastname, int year, int dok, int tel, String email, String tariff, int price, int studSale) {
        super(id, name, lastname, year, dok, tel, email, tariff, price);
        this.studSale = studSale;
    }
}

