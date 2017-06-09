package data.classes.client;


public class CPF {
    String cpf = "";

    public CPF(String cpf) {
        this.cpf = cpf;
    }

    public boolean valido() {
         int n1 = Integer.parseInt(cpf.substring(0, 1));
        int n2 = Integer.parseInt(cpf.substring(1, 2));
        int n3 = Integer.parseInt(cpf.substring(2, 3));
        int n4 = Integer.parseInt(cpf.substring(3, 4));
        int n5 = Integer.parseInt(cpf.substring(4, 5));
        int n6 = Integer.parseInt(cpf.substring(5, 6));
        int n7 = Integer.parseInt(cpf.substring(6, 7));
        int n8 = Integer.parseInt(cpf.substring(7, 8));
        int n9 = Integer.parseInt(cpf.substring(8, 9));
        int somatorio = n1 * 10;
        somatorio += n2 * 9;
        somatorio += n3 * 8;
        somatorio += n4 * 7;
        somatorio += n5 * 6;
        somatorio += n6 * 5;
        somatorio += n7 * 4;
        somatorio += n8 * 3;
        somatorio += n9 * 2;
        int resultado = Integer.parseInt(String.valueOf(somatorio % 11));
        int d1 = resultado < 2 ? 0 : Integer.parseInt(String.valueOf(11 - resultado));
        somatorio = n1 * 11;
        somatorio += n2 * 10;
        somatorio += n3 * 9;
        somatorio += n4 * 8;
        somatorio += n5 * 7;
        somatorio += n6 * 6;
        somatorio += n7 * 5;
        somatorio += n8 * 4;
        somatorio += n9 * 3;
        somatorio += d1 * 2;
        resultado = Integer.parseInt(String.valueOf(somatorio % 11));
        int d2 = resultado < 2 ? 0 : Integer.parseInt(String.valueOf(11 - resultado));
        return (Integer.parseInt(cpf.substring(9, 10)) == d1 && Integer.parseInt(cpf.substring(10)) == d2);
    }

    @Override
    public String toString() {
        return cpf;
    }
}
