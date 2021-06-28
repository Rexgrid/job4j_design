package ru.job4j.io.serialization;

public class Device {

    private final String deviceName;

    public Device(String dev) { this.deviceName = dev; }

    @Override
    public String toString() {
        return "Device{"
                + "device='" + deviceName + '\''
                +'}';
    }
}
