package ga.veee.day23;

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