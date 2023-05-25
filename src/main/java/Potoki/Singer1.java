package Potoki;

public class Singer1 extends Thread {



    private int count = 2;

    public Singer1() {}
    public Singer1(int count) {
        this.count = count;
    }

    @Override
    public void run() {

        currentThread().setName("Певец №1");

        int j = 0;
        while (j < count) {

            Concert.LOGGER.debug("Поток: " + currentThread().getName() + " " + "Певец номер 1 взял микрофон");

            for (int i = 0; i < 3; i++) {
                System.out.println("La_La_____");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (Monitors.MICROPHONE) {
                Concert.LOGGER.debug("Поток: " + currentThread().getName() + " " + "Певец номер 1 закончил петь");
                Monitors.MICROPHONE.notify();
            }

            synchronized (Monitors.MICROPHONE) {
                try {
                    Monitors.MICROPHONE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            j++;
        }
    }
}
