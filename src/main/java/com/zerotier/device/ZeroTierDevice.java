package com.zerotier.device;

import com.zerotier.device.cli.ZeroTierCli;
import com.zerotier.device.cli.ZeroTierPosix;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ZeroTierDevice {
    private final Logger logger = LoggerFactory.getLogger(ZeroTierDevice.class);

    public ZeroTierDevice() {
        logger.info("OS: %s (%s) version %s", SystemUtils.OS_NAME, SystemUtils.OS_ARCH, SystemUtils.OS_VERSION);
    }

    public ZeroTierCli getZeroTierCli() {
        if (SystemUtils.IS_OS_UNIX || SystemUtils.IS_OS_LINUX) {
            return new ZeroTierPosix();
        } else {
            throw new UnknownOSException();
        }
    }

}
