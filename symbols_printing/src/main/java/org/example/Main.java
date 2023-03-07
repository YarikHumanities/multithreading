package org.example;

public class Main {
    public static void main(String[] args) {
//        SymbolPrinterThread thread_1 = new SymbolPrinterThread(new SymbolPrinter("-"));
//        SymbolPrinterThread thread_2 = new SymbolPrinterThread(new SymbolPrinter("/"));
//        thread_1.start();
//        thread_2.start();
        Sync permission = new Sync();
        Thread first = new Thread(new SymbolSync("-", permission, true));
        Thread second = new Thread(new SymbolSync("|", permission, false));
        first.start();
        second.start();
    }
}