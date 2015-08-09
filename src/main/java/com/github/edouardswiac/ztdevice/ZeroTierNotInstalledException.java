package com.github.edouardswiac.ztdevice;


public class ZeroTierNotInstalledException extends RuntimeException {
    public ZeroTierNotInstalledException() {
        super();
    }

    public ZeroTierNotInstalledException(String message) {
        super(message);
    }
}
