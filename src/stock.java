import java.util.*;

public class stock {
    String abbreviation;
    double price;
    int number;
    double dividend;
    public stock(){
    }

    public void setAbbreviation(String newAbbreviation){
        this.abbreviation=newAbbreviation;
    }
    public void setPrice (double newPrice){
        this.price = newPrice;
    }

    public void setNumber(int newNumber) {
        this.number = newNumber;
    }

    public void setDividend(double newDividend) {
        this.dividend = newDividend;
    }

    public double getDividend() {
        return dividend;
    }

    public int getNumber() {
        return number;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public double getPrice() {
        return price;
    }

    public double totalDividend (){

        return number * dividend;
    }
}


