package data.classes.vehicle;

public class Veiculo {

    private String placa;
    private Modelo modelo;
    private int ano;
    private Situacao situacao;
    
    private enum Situacao {
        DISPONIVEL, LOCADO, SINISTRADO, VENDIDO, INATIVO;
        
        @Override
        public String toString() {
            switch (this) {
                case DISPONIVEL:
                    return "DISPONIVEL";
                case LOCADO:
                    return "LOCADO";
                case SINISTRADO:
                    return "SINISTRADO";
                case VENDIDO:
                    return "VENDIDO";
                default:
                    return "INATIVO";
            }
        }
    }

}
