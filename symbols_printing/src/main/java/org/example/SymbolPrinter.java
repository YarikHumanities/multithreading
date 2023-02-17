package org.example;

public class SymbolPrinter {
    public SymbolPrinter(String symbol) {

        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public void printSymbol(){
        System.out.print(this.symbol);
    }

    private String symbol;
}
