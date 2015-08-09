package com.zerotier.device.cli;

import com.zerotier.device.ZeroTierNotInstalledException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ZeroTierPosix implements ZeroTierCli {
    private final Logger logger = LoggerFactory.getLogger(ZeroTierPosix.class);

    public ZeroTierPosix() {
        try {
            Process p = new ProcessBuilder("command -v zerotier-cli".split(" ")).start();
            int retCode = p.waitFor();
            assert retCode == 0;
        } catch (IOException |AssertionError|InterruptedException e) {
            throw new ZeroTierNotInstalledException(e.getMessage());
        }
    }

    @Override
    public boolean join(String network) {
        try {
            Process p = new ProcessBuilder(String.format("zerotier-cli join %s", network).split(" ")).start();
            int retCode = p.waitFor();
            return retCode == 0;
        } catch (IOException |AssertionError|InterruptedException e) {
            logger.error("error when attempting to join network: {}", network, e);
            return false;
        }
    }

    @Override
    public boolean leave(String network) {
        try {
            Process p = new ProcessBuilder(String.format("zerotier-cli leave %s", network).split(" ")).start();
            int retCode = p.waitFor();
            return retCode == 0;
        } catch (IOException |AssertionError|InterruptedException e) {
            logger.error("error when attempting to leave network {}", network, e);
            return false;
        }
    }

    @Override
    public String info() {
        try {
            Process p = new ProcessBuilder("zerotier-cli info".split(" ")).start();

            int retCode = p.waitFor();
            assert retCode == 0;
            StringBuilder sb = new StringBuilder();
            int c;
            while((c = p.getInputStream().read()) != -1) {
                sb.append((char)c);
            }
            return sb.toString();
        } catch (IOException |AssertionError|InterruptedException e) {
            logger.error("error when attempting to display infos", e);
            return "";
        }
    }
}
