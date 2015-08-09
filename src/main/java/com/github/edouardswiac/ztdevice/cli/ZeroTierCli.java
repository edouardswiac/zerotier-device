package com.github.edouardswiac.ztdevice.cli;

/**
 * Created by eswiac on 8/8/15.
 */
public interface ZeroTierCli {
    boolean join(String network);
    boolean leave(String network);
    String info();
}
