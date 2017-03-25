/*
    Build encrypted string: Take every second char from the string, then the other chars, that are not every 2nd char, and concat them as new string.
    
    Do this n times!

    E.g.

    "This is a test!", 1 -> "hsi etTi sats!"
    "This is a test!", 2 -> "hsi etTi sats!" -> "s eT ashi tist!"
*/

public class AlternatingSplitEncryption {
    public static String encrypt(final String text, int n) {
        if (n <= 0 || text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (i % 2 == 1) {
                first.append(c);
            } else {
                second.append(c);
            }
        }
        return encrypt(first.append(second).toString(), --n);
    }

    public static String decrypt(final String encryptedText, int n) {
        if (n <= 0 || encryptedText == null || encryptedText.isEmpty()) {
            return encryptedText;
        }

        StringBuilder text = new StringBuilder();
        final int half = encryptedText.length() / 2;
        for (int i = 0; i < half; i++) {
            text.append(encryptedText.charAt(half+i)).append(encryptedText.charAt(i));
        }

        if (encryptedText.length() % 2 == 1) {
            text.append(encryptedText.charAt(encryptedText.length() - 1));
        }

        return decrypt(text.toString(), --n);
    }

    
}