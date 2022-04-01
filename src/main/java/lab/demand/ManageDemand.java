package lab.demand;

import java.util.List;

public class ManageDemand {

    private Tax tax;

    public ManageDemand(Tax tax) {
        this.tax = tax;
    }

    public double calculateTotal(List<Order> orders){
        // Calculate Taxes
        // Calculate Total
        double taxes = 0.0;
        double quantities = 0.0;
        for (Order order : orders) {
            taxes += this.tax.calculateTax(order.getCountry());
            quantities += order.getQuantity();
        }
        return quantities * taxes;
    }

    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, double defaultAdditionalColombia, double defaultAdditionalPeru, double defaultAdditionalBrazil){
        // Calculate additionals by country
        double taxes = 0.0;
        double quantities = 0.0;
        //Calculate taxes and quantities
        for (Order order : orders) {
            // Con la linea 32 no utilizamos el string currCountry
            taxes+= (order.getCountry().equals("BR"))? defaultAdditionalBrazil: (order.getCountry().equals("PE"))? defaultAdditionalPeru : defaultAdditionalColombia;
            quantities +=order.getQuantity();
        }
        return quantities * taxes;
    }

}
