package ga.veee.day17.Billing;

public enum Currencies {

    USD("$"),
    INR("₹");

    private final String symbol;

    Currencies(String symbol) {
        this.symbol = symbol;
    }

    String Symbol(){
        return this.symbol;
    }

}
