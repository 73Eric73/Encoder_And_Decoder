public class Encoder {

    public static String Encode(String codeUser) {

        StringBuilder userInput = new StringBuilder();
        StringBuilder binaryMessage = new StringBuilder();
        StringBuilder encodeMessage = new StringBuilder();

        userInput.append(codeUser);

        for (int i = 0; i < userInput.length(); i++) {
            int theChar = userInput.charAt(i);
            int charInBinary = Integer.parseInt(Integer.toBinaryString(theChar));
            if (charInBinary / 100_000 == 1) binaryMessage.append('0');
            binaryMessage.append(charInBinary);
        }

        for (int i = 0; i < binaryMessage.length(); i++) {
            if (i == 0) {
                if (binaryMessage.charAt(i) == '1') {
                    encodeMessage.append("0 0");
                } else {
                    encodeMessage.append("00 0");
                }
            } else {
                if (binaryMessage.charAt(i) != binaryMessage.charAt(i - 1)) {
                    if (binaryMessage.charAt(i) == '1') {
                        encodeMessage.append(" 0 0");
                    } else {
                        encodeMessage.append(" 00 0");
                    }
                } else {
                    if (binaryMessage.charAt(i) == '1' && binaryMessage.charAt(i) - 1 != '1') {
                        encodeMessage.append("0");
                    } else {
                        encodeMessage.append("0");
                    }
                }
            }
        }

        return encodeMessage.toString();
    }

}
