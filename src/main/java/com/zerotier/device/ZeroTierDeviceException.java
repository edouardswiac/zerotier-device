package com.zerotier.device;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ZeroTierDeviceException extends Exception {

    public ZeroTierDeviceException() {
        super();
    }

    public ZeroTierDeviceException(String message) {
        super(message);
    }
}
