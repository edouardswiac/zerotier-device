package com.zerotier.device;

import com.zerotier.device.cli.ZeroTierCli;
import com.zerotier.device.cli.ZeroTierPosix;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ZeroTierDevice implements ZeroTierCli {
    private final Logger logger = LoggerFactory.getLogger(ZeroTierDevice.class);
    private ZeroTierCli cli = getZeroTierCli();

    public ZeroTierDevice() {
        logger.info("OS: %s (%s) version %s", SystemUtils.OS_NAME, SystemUtils.OS_ARCH, SystemUtils.OS_VERSION);

    }

    @Override
    public boolean join(String network) {
        return cli.join(network);
    }

    @Override
    public boolean leave(String network) {
        return cli.leave(network);
    }

    @Override
    public String info() {
        return cli.info();
    }

    public ZeroTierCli getZeroTierCli() {
        if (SystemUtils.IS_OS_UNIX) {
            return new ZeroTierPosix();
        } else {
            throw new UnknownOSException();
        }
    }

}
