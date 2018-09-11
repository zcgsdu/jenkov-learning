package com.jenkov.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
	
	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger();
		ExchangerRunnable er1 = new ExchangerRunnable(exchanger, "A");
		ExchangerRunnable er2 = new ExchangerRunnable(exchanger, "B");
		new Thread(er1).start();
		new Thread(er2).start();
	}
}


class ExchangerRunnable implements Runnable{

    Exchanger exchanger = null;
    Object    object    = null;

    public ExchangerRunnable(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    public void run() {
        try {
            Object previous = this.object;

            this.object = this.exchanger.exchange(this.object);

            System.out.println(
                    Thread.currentThread().getName() +
                    " exchanged " + previous + " for " + this.object
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}