package org.example;

public class SymbolSync implements Runnable {
    private String symbol;
    private Sync sync;
    private boolean controlValue;

    public SymbolSync(String symbol, Sync sync, boolean controlValue) {
        this.symbol = symbol;
        this.sync = sync;
        this.controlValue = controlValue;
    }

    @Override
    public void run(){
        while (true){
            sync.waitAndChange(controlValue, symbol);
            if(sync.isStop()){
                return;
            }
        }
    }
}
