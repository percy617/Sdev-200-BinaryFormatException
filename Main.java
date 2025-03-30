public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(BinaryConverter.bin2Dec("1011")); // Valid binary
            System.out.println(BinaryConverter.bin2Dec("4267")); // Invalid binary
        } catch (BinaryFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

class BinaryConverter {
    public static int bin2Dec(String binary) throws BinaryFormatException {
        int decimal = 0;
        int base = 1; // 2^0

        // Check if the binary string is valid
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digit = binary.charAt(i);
            if (digit == '1') {
                decimal += base;
            } else if (digit == '0') {
                // do nothing
            } else {
                throw new BinaryFormatException("Invalid binary format: " + binary);
            }
            base *= 2; // Increase the base (2^n)
        }
        return decimal;
    }
}

class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}