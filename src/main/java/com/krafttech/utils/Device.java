package com.krafttech.utils;

public enum Device {
    PIXEL_2("Pixel_2", "emulator-5554", "11.0","Android"),

    PIXEL_2_XL("Pixel_2_XL", "emulator-5556", "11.0","Android");
    public String version;

    public String deviceName;

    public String udid;

    public String platform;

    Device(String deviceName, String udid, String version, String platform) {
        this.deviceName = deviceName;
        this.udid = udid;
        this.version = version;
        this.platform = platform;
    }
}
