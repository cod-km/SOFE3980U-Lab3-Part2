package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
    private String number = "0";  // string containing the binary value '0' or '1'

    /**
     * A constructor that generates a binary object.
     *
     * @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored. Trailing zeros will be excluded and empty string will be considered as zero.
     */
    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0"; // Default to "0" for null or empty input
            return;
        }

        // Validate the binary string (only '0' or '1' allowed)
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0"; // Default to "0" for invalid input
                return;
            }
        }

        // Remove leading zeros
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }

        // If all digits are '0', ensure number is "0"
        this.number = (beg == number.length()) ? "0" : number.substring(beg);

        // Ensure empty strings are replaced with "0"
        if (this.number.isEmpty()) {
            this.number = "0";
        }
    }

    /**
     * Return the binary value of the variable
     *
     * @return the binary value in a string format.
     */
    public String getValue() {
        return this.number;
    }

    /**
     * Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
     *
     * @param num1 The first addend object
     * @param num2 The second addend object
     * @return A binary variable with a value of <i>num1+num2</i>.
     */
    public static Binary add(Binary num1, Binary num2) {
        // the index of the first digit of each number
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        // initial variable
        int carry = 0;
        String num3 = "";  // the binary value of the sum
        while (ind1 >= 0 || ind2 >= 0 || carry != 0) { // loop until all digits are processed
            int sum = carry; // previous carry
            if (ind1 >= 0) { // if num1 has a digit to add
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
                ind1--; // update ind1
            }
            if (ind2 >= 0) { // if num2 has a digit to add
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int and add it to sum
                ind2--; // update ind2
            }
            carry = sum / 2; // the new carry
            sum = sum % 2;  // the resultant digit
            num3 = ((sum == 0) ? "0" : "1") + num3; // convert sum to string and append it to num3
        }
        Binary result = new Binary(num3);  // create a binary object with the calculated value.
        return result;
    }

    /**
     * Perform a binary OR operation between two Binary numbers.
     *
     * @param num1 The first operand object
     * @param num2 The second operand object
     * @return A binary result of <i>num1 | num2</i>.
     */
    public static Binary OR(Binary num1, Binary num2) {
        int maxLength = Math.max(num1.number.length(), num2.number.length());
        String bin1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0');
        String bin2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0');
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            result.append((bin1.charAt(i) == '1' || bin2.charAt(i) == '1') ? "1" : "0");
        }

        return new Binary(result.toString());
    }

    /**
     * Perform a binary AND operation between two Binary numbers.
     *
     * @param num1 The first operand object
     * @param num2 The second operand object
     * @return A binary result of <i>num1 & num2</i>.
     */
    public static Binary AND(Binary num1, Binary num2) {
        int maxLength = Math.max(num1.number.length(), num2.number.length());
        String bin1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0');
        String bin2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0');
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            result.append((bin1.charAt(i) == '1' && bin2.charAt(i) == '1') ? "1" : "0");
        }

        return new Binary(result.toString());
    }

    /**
     * Perform a binary multiplication (AND-like) operation between two Binary numbers.
     *
     * @param num1 The first operand object
     * @param num2 The second operand object
     * @return A binary result of <i>num1 * num2</i>.
     */
    public static Binary multiply(Binary num1, Binary num2) {
        Binary result = new Binary("0");
        String num2Value = num2.number;

        for (int i = num2Value.length() - 1, shift = 0; i >= 0; i--, shift++) {
            if (num2Value.charAt(i) == '1') {
                String shiftedValue = num1.number + "0".repeat(shift);
                result = Binary.add(result, new Binary(shiftedValue));
            }
        }

        return result;
    }

}
