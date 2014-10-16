package swap;

public class NodoFIFO {
    int pagina;
    String bit;
    NodoFIFO prox;

    public NodoFIFO(int p, String b){
        this.pagina = p;
        this.bit = b;
        prox = null;
    }
}

