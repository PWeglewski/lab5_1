package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * Created by piotr on 19.05.16.
 */
public class BetterRadar {
    private PatriotBattery battery;

    private Executor executor;

    public BetterRadar(Executor executor, PatriotBattery battery) {
        this.executor = executor;
        this.battery = battery;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < 10; i++) {
                battery.launchPatriot();
            }
        };

        executor.execute(launchPatriotTask);
    }
}
