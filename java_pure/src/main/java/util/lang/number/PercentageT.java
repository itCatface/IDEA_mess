package util.lang.number;

import java.text.DecimalFormat;

public class PercentageT {

    /**
     * calculate percentage of two numbers
     */
    public static String percent(double value1, double value2, int decimalSize, boolean replaceWithZero, boolean removePercent) {
        StringBuffer buffString = new StringBuffer();
        buffString.append("#");
        if (decimalSize > 0) {
            buffString.append(".");
        }

        for (int w = 0; w < decimalSize; w++) {
            buffString.append(replaceWithZero ? "0" : "#");
        }

        buffString.append("%");

        if (buffString.length() > 0) {
            String result = new DecimalFormat(buffString.toString()).format(value1 / value2);

            if (removePercent && result.length() > 0) {
                result = result.substring(0, result.length() - 1);
            }

            return result;

        } else {
            return "";
        }
    }


    public static String percent(double value1, double value2, int decimalPointAfterLength, boolean replaceWithZero) {
        return percent(value1, value2, decimalPointAfterLength, replaceWithZero, false);
    }


    public static String percent(double value1, double value2, int decimalPointAfterLength) {
        return percent(value1, value2, decimalPointAfterLength, false, false);
    }


    public static String percent(double value1, double value2) {
        return percent(value1, value2, 0, false, false);
    }
}
