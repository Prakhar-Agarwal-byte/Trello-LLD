package utils;

import java.util.UUID;

public class Utils {
    public static String getUrl(String prefix, UUID id) {
        return "https://" + prefix + "-" + id.toString() + ".com";
    }
}
