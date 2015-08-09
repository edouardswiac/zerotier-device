package com.github.edouardswiac.ztdevice;


public class ZeroTierNotInstalledException extends Exception {
    public ZeroTierNotInstalledException() {
        super();
    }

    public ZeroTierNotInstalledException(String message) {
        super(message);
    }
}
