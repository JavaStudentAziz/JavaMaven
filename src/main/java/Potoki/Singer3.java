package Potoki;

public class Singer3 extends Thread {
    @Override
    public void run() {

        currentThread().setName("Певец №3");

        while (true) {

            synchronized (Monitors.MICROPHONE) {
                try {
                    Monitors.MICROPHONE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Concert.LOGGER.debug("Поток: " + currentThread().getName() + " " + "Певец номер 3 взял микрофон");

            for (int i = 0; i < 3; i++) {
                System.out.println("__Na_Na__");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (Monitors.MICROPHONE) {
                Concert.LOGGER.debug("Поток: " + currentThread().getName() + " " + "Певец номер 3 закончил петь");
                Monitors.MICROPHONE.notify();
            }
        }
    }
}
