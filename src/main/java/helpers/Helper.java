package helpers;

public class Helper {
    public static int getAmoundFromText(String text) {

        int index = text.indexOf("$");
        String textAmount = text.substring(index + 1);
        return Integer.parseInt(textAmount);
    }
}
