
public class DeviceFactory {

    public static SmartDevice createDevice(String deviceType) {
        switch (deviceType.toLowerCase()) {
            case "light":
                return new SmartLight();
            case "thermostat":
                return new SmartThermostat();
            case "camera":
                return new SmartSecurityCamera();
            default:
                throw new IllegalArgumentException("Invalid device type: " + deviceType);
        }
    }
}
