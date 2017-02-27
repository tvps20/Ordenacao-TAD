public class FilaComArray implements Fila_IF 
{
    private int[] fila;
    private int cabeca;
    private int calda;
    
    public FilaComArray()
    {
        fila = new int[10];
        cabeca = 0;
        calda = -1;
    }
    
    @Override
    public void enqueue(int element) throws Exception {
        if(isFull())
            throw new Exception("Overflow");
        else
        {
            calda += 1;
            fila[calda] = element;
        }
    }

    public void troca(int[] vetor)
    {
        for(int i=0; i<calda; i++)
            vetor[i] = vetor[i+1];
    }
    
    @Override
    public int dequeue() throws Exception {
        if(isEmpty())
            throw new Exception("Underflow");
        else
        {
            int resultado = fila[0];
            troca(fila);
            calda -= 1;
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
        if(calda == -1)
            return true;
        else
            return false;
    }

    @Override
    public boolean isFull() {
        if(calda == fila.length -1)
            return true;
        else
            return false;
    }  
}
