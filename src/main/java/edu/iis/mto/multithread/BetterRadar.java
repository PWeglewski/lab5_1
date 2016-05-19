package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

/**
 * Created by piotr on 19.05.16.
 */
public class BetterRadar {
    private PatriotBattery battery;

    private ExecutorService executor;

    public BetterRadar(ExecutorService executor) {
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    battery.launchPatriot();
                }
            }
        };

        executor.execute(launchPatriotTask);
    }
}
