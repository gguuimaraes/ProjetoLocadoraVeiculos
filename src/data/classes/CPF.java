package data.classes;


public class CPF {

    private byte n1, n2, n3, n4, n5, n6, n7, n8, n9;
    private byte digit1, digit2;

    public CPF(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("O valor fornecido deve conter 11 digitos.");
        }
        n1 = Byte.parseByte(cpf.substring(0, 1));
        n2 = Byte.parseByte(cpf.substring(1, 2));
        n3 = Byte.parseByte(cpf.substring(2, 3));
        n4 = Byte.parseByte(cpf.substring(3, 4));
        n5 = Byte.parseByte(cpf.substring(4, 5));
        n6 = Byte.parseByte(cpf.substring(5, 6));
        n7 = Byte.parseByte(cpf.substring(6, 7));
        n8 = Byte.parseByte(cpf.substring(7, 8));
        n9 = Byte.parseByte(cpf.substring(8, 9));
        digit1 = Byte.parseByte(cpf.substring(9, 10));
        digit2 = Byte.parseByte(cpf.substring(10, 11));
    }

    public byte calcPrimeiroDigito() {
        int somatorio = n1 * 10;
        somatorio += n2 * 9;
        somatorio += n3 * 8;
        somatorio += n4 * 7;
        somatorio += n5 * 6;
        somatorio += n6 * 5;
        somatorio += n7 * 4;
        somatorio += n8 * 3;
        somatorio += n9 * 2;
        byte resultado = Byte.parseByte(String.valueOf(somatorio % 11));
        return resultado < 2 ? 0 : Byte.parseByte(String.valueOf(11 - resultado));
    }

    public byte calcSegundoDigito() {
        int somatorio = n1 * 11;
        somatorio += n2 * 10;
        somatorio += n3 * 9;
        somatorio += n4 * 8;
        somatorio += n5 * 7;
        somatorio += n6 * 6;
        somatorio += n7 * 5;
        somatorio += n8 * 4;
        somatorio += n9 * 3;
        somatorio += digit1 * 2;
        byte resultado = Byte.parseByte(String.valueOf(somatorio % 11));
        return resultado < 2 ? 0 : Byte.parseByte(String.valueOf(11 - resultado));
    }

    public boolean isValid() {
        return digit1 == calcPrimeiroDigito() && digit2 == calcSegundoDigito();
    }

    @Override
    public String toString() {
        return String.format("%d%d%d%d%d%d%d%d%d%d%d", n1, n2, n3, n4, n5, n6, n7, n8, n9, digit1, digit2);
    }

    public String toString(boolean with_mask) {
        if (with_mask) {
            return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", n1, n2, n3, n4, n5, n6, n7, n8, n9, digit1, digit2);
        }
        return toString();
    }
}
