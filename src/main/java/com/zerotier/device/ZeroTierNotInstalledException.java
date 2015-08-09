package com.zerotier.device;


public class ZeroTierNotInstalledException extends RuntimeException {
    public ZeroTierNotInstalledException() {
        super();
    }

    public ZeroTierNotInstalledException(String message) {
        super(message);
    }
}
