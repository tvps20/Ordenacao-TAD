public class FilaComArray implements Fila_IF 
{
    private int[] fila;
    private int cabeca;
    private int calda;
    private int elementos;
    
    public FilaComArray()
    {
        fila = new int[10];
        cabeca = 0;
        calda = -1;
        elementos = 0;
    }
    
    @Override
    public void enqueue(int element) throws Exception {
        if(isFull())
            throw new Exception("Overflow");
        else
        {
            if(calda == fila.length -1)
                calda = -1;
            calda += 1;
            fila[calda] = element;
            elementos++;
        }
    }

/*  //Metodo para fazer os elementos da lista voltarem uma posição
        //Porém como usa um laço seu custo passa a ser O(n).
    public void troca(int[] vetor)
    {
        for(int i=0; i<calda; i++)
            vetor[i] = vetor[i+1];
    }
*/    
    @Override
    public int dequeue() throws Exception {
        if(isEmpty())
            throw new Exception("Underflow");
        else
        {
            int resultado = fila[cabeca++];
            if(cabeca == fila.length)
                cabeca = 0;
            //troca(fila);
            //calda -= 1;
            elementos--;
            return resultado;
        }
    }

    @Override
    public int head() throws Exception {
        if(isEmpty())
            throw new Exception("Fila Vazia");
        else
        {
            return fila[cabeca];
        }
    }

    @Override
    public boolean isEmpty() {
        if(elementos == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean isFull() {
        if(elementos == fila.length)
            return true;
        else
            return false;
    }  
}
