package data.classes;

public class CartaoCredito {
    private Bandeira bandeira;
    private long numero;
    private int cvv;
    private int mesAno[];
    
    private enum Bandeira {
        MASTERCARD, VISA;
        
        @Override
        public String toString() {
            switch (this) {
                case MASTERCARD: return "MASTERCARD";
                default: return "VISA";
            }
        }
    }
    
    public CartaoCredito() {
        
    }
}
