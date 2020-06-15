public class Converter {
    private int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
            1};
    private String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"};

    public int romanToArabic(String romanNumeral) {
        int result = 0;
        int i = 0;

        if (!romanNumeral.matches("^[MDCLXVI]+$")) {
            throw new IllegalArgumentException(romanNumeral + " cannot be converted to a"
                    + " Roman Numeral.");
        }

        while (i < roman.length) {
            if (romanNumeral.startsWith(roman[i])) {
                result += arab[i];
                romanNumeral = romanNumeral.substring(roman[i].length());
            } else {
                i++;
            }
        }

        return result;
    }

    public String arabicToRoman(int arabicNumeral) {

        if ((arabicNumeral <= 0) || (arabicNumeral > 4000)) {
            throw new IllegalArgumentException(
                    arabicNumeral + " is not in " + "range 0-4000");
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < arab.length) {
            if (arabicNumeral >= arab[i]) {
                result.append(roman[i]);
                arabicNumeral -= arab[i];
            } else {
                i++;
            }
        }
        return result.toString();
    }
}

