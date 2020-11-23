package tsp.smartaddon.util;

/**
 * Simple Number Utilities
 *
 * @author TheSilentPro
 */
public class SmartNumberUtils {

    /**
     * Converts seconds to Minecraft ticks
     *
     * @param seconds Seconds to convert
     * @return Seconds in ticks
     */
    public static int toTicks(int seconds) {
        return seconds * 20;
    }

    /**
     * Converts a number to Machine number
     *
     * @param i Number to convert
     * @return Number as machine number
     */
    public static int toMachineNumber(int i) {
        return i - 1;
    }

}
