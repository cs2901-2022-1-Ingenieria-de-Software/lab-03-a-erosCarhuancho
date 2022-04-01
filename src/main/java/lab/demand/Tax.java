package lab.demand;

public class Tax {
    
    public double calculateTax(String country) {
        return (country.equals("BR"))? 0.12: (country.equals("PE"))? 0.18 : 0.0;
    }

}
