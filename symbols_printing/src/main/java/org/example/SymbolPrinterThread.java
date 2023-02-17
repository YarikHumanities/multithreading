package org.example;

public class SymbolPrinterThread extends Thread {
    private SymbolPrinter printer;
    public SymbolPrinterThread(SymbolPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run(){
            for (int i = 0; i < 100; i++) {

                for (int j = 0; j < 10; j++) {

                    this.printer.printSymbol();

                }

                System.out.println();
            }
    }
}
