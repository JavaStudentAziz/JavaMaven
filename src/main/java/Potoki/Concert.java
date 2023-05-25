package Potoki;

import org.apache.log4j.Logger;

public class Concert extends Thread{

    public static final Logger LOGGER = Logger.getLogger(Concert.class);

    public static void main(String[] args) throws InterruptedException {

        currentThread().setName("КОНЦЕРТ");

        LOGGER.debug("Поток: " + currentThread().getName() + " " + "Концер начался!");
        System.out.println("Concert begins");

        Singer1 singer1 = new Singer1();
        singer1.setDaemon(true);

        Singer2 singer2 = new Singer2();
        singer2.setDaemon(true);

        Singer3 singer3 = new Singer3();
        singer3.setDaemon(true);

        singer1.start();
        singer2.start();
        singer3.start();

        while (singer1.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        LOGGER.debug("Поток: " + currentThread().getName() + " " + "Концерт закончился");
        System.out.println("Concert ends");
    }
}
