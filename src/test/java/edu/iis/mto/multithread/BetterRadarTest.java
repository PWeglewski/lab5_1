package edu.iis.mto.multithread;

import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by piotr on 19.05.16.
 */
public class BetterRadarTest {
    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() throws Exception {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = runnable -> runnable.run();
        BetterRadar radar = new BetterRadar(executor, batteryMock);
        radar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }
}