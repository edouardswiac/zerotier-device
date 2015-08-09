package com.github.edouardswiac.ztdevice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.github.edouardswiac.ztdevice.cli.ZeroTierCli;
import org.junit.Test;

public class ZeroTierDeviceIT {

    private final String testingNetwork = "8056c2e21c60be67";
    @Test
    public void checkZeroTier() {
        ZeroTierDevice device = new ZeroTierDevice();
        ZeroTierCli cli = device.getZeroTierCli();
        assertEquals(true, cli.join(testingNetwork));
        String info = cli.info();
        System.out.print(info);
        assertTrue(info.contains("200"));
        assertEquals(true, cli.leave(testingNetwork));
    }
}
