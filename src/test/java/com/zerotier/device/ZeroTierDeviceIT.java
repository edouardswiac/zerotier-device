package com.zerotier.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ZeroTierDeviceIT {

    private final String testingNetwork = "8056c2e21c60be67";
    @Test
    public void checkZeroTier() {
        ZeroTierDevice device = new ZeroTierDevice();
        assertEquals(true, device.join(testingNetwork));
        String info = device.info();
        assertTrue(info.contains("200"));
        assertEquals(true, device.leave(testingNetwork));
    }
}
