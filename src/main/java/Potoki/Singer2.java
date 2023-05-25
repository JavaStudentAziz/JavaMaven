package Potoki;

public class Singer2 extends Thread {
    @Override
    public void run() {

        currentThread().setName("Певец №2");

        while (true) {

            synchronized (Monitors.MICROPHONE) {
                try {
                    Monitors.MICROPHONE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Concert.LOGGER.debug("Поток: " + currentThread().getName() + " " + "Певец номер 2 взял микрофон");

            for (int i = 0; i < 3; i++) {
                System.out.println("_____Fa_Fa");
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (Monitors.MICROPHONE) {
                Concert.LOGGER.debug("Поток: " + currentThread().getName() + " " + "Певец номер 2 закончил петь");
                Monitors.MICROPHONE.notify();
            }

        }
    }
}
