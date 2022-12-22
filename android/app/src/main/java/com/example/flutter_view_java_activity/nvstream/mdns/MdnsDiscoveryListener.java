package com.example.flutter_view_java_activity.nvstream.mdns;

public interface MdnsDiscoveryListener {
    void notifyComputerAdded(MdnsComputer computer);
    void notifyComputerRemoved(MdnsComputer computer);
    void notifyDiscoveryFailure(Exception e);
}
