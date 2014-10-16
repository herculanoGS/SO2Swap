package swap;

public class Fifo {
    
    
    NodoFIFO primeiro,ultimo;
    int totalNos;
    String valores;
    int tamanhoFrames;
    int acerto = 0;
    int falta = 0;

    public Fifo(){
        primeiro = ultimo = null;
        totalNos = 0;
    }

    public int getTotalNos(){
        return totalNos;
    }

    public boolean checkIfListaVazia(){
        if (getTotalNos() == 0){
            return true;
       }
       return false;
    }
    public void setTamanhoPaginas(int frame)
    {
        tamanhoFrames = frame;
    }
    public boolean checkIfListaCheio(){
    if (getTotalNos() == tamanhoFrames)
        return true;
    return false;
}
    public void inserirNoInicio(NodoFIFO n) {
         if (!checkIfListaCheio()){
             

            if ( checkIfListaVazia() ){
                primeiro = ultimo = n;
            }
            else{
                n.prox = primeiro;
                primeiro = n;
            }
            totalNos++;
    }
         else {
              n.prox = primeiro;
                primeiro = n;
         }
    }

    public void inserirNoFim(NodoFIFO n){
        // caso não existam nós inseridos,
        // insere o primeiro nó (n) na lista
        if (!checkIfListaCheio()){
            
            if ( checkIfListaVazia() ){
                primeiro = ultimo = n;
                totalNos++;
            }
            else{
                ultimo.prox = n;
                ultimo = n;
                totalNos++;
            }
            
      }
        else
        {
            NodoFIFO noNew;
            noNew = primeiro.prox;
            primeiro = noNew;
            ultimo.prox = n;
            ultimo = n;
            
        }
            
    }
    
    
    public boolean verificarPagina(NodoFIFO n){

   
         NodoFIFO noAux = (primeiro);
        while (noAux != null){
            if (noAux.pagina == n.pagina)
            {
                return true;
            }
            else 
            {
                noAux = noAux.prox;
            }} 

        
    
        return false;
}
    
    public void excluirNodo(NodoFIFO n){
        NodoFIFO noAtual;
        NodoFIFO noAnterior;
        noAtual = noAnterior = primeiro;
        int contador = 1;

        if (checkIfListaVazia() == false){
            while (contador <= getTotalNos() &&  noAtual.pagina != n.pagina){
                noAnterior = noAtual;
                noAtual = noAtual.prox;
                contador++;
            } 

        if(noAtual.pagina == n.pagina){
            if ( getTotalNos() == 1){
                primeiro = ultimo = null;
                }
            else{
               if (noAtual == primeiro){
                   primeiro = noAtual.prox;
                    }
               else{
                   noAnterior.prox = noAtual.prox;
                    }
                }
           totalNos--;
        }
        
    }
}

    public String exibirLista(){
        
    NodoFIFO temp = primeiro;
    String val = "";
    
    int contador = 1;
    if ( checkIfListaVazia() == false ){
        while (contador <= getTotalNos()){
            val += Integer.toString(temp.pagina)+" "+ temp.bit+"  -  ";
            temp = temp.prox;
            contador++;
        }
    }
    valores = val;
 
    return valores;
   
    }
    
    public void FIFO(NodoFIFO n){
        if (checkIfListaVazia() == true){
            inserirNoFim(n);
            falta++;
            
            
       }
        else{
             if ( verificarPagina(n) == false)
                {
                    inserirNoFim(n);
                    falta++;
                    
                }
             else
             {
                 acerto++;
                 
             }
                 
        } 
    }
}
