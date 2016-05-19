package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.*;

/**
 * Created by piotr on 19.05.16.
 */
public class BetterRadarTest {
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 100)
    public void launchPatriotOnceWhenNoticesAScudMissle() throws Exception {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = runnable -> runnable.run();
        BetterRadar radar = new BetterRadar(executor, batteryMock);
        radar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }
}