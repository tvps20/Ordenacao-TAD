public class FilaComPilhas implements Fila_IF 
{
    PilhaComArray pilha1;
    PilhaComArray pilha2;
    int elementos;
    
    public FilaComPilhas()
    {
        pilha1 = new PilhaComArray();
        pilha2 = new PilhaComArray();
        elementos = 0;
    }

    @Override
    public void enqueue(int element) throws Exception {
        if(isFull())
            throw new Exception("Overflow");
        else
        {
            elementos++;
            pilha1.push(element);
        }
    }

    @Override
    public int dequeue() throws Exception {
        if(isEmpty())
            throw new Exception("Underflow");
        else
        {
            int elementoTop = 0;
            for(int i=0; i< elementos; i++)
                pilha2.push(elementoTop = pilha1.pop());
            for(int i=0; i< elementos; i++)
            {
                int elementoAtual = pilha2.pop();
                if(elementoAtual != elementoTop)
                    pilha1.push(elementoAtual);
            }
            elementos--;
            return elementoTop;
        }
    }

    @Override
    public int head() throws Exception {
        if(isEmpty())
            throw new Exception("Fila Vazia");
        else
            for(int i=0; i<elementos; i++)
                pilha2.push(pilha1.pop());
        
            int elementoTop = pilha2.top();
            
            for(int i=0; i< elementos; i++)
                pilha1.push(pilha2.pop());
            
            return elementoTop;
        
    }

    @Override
    public boolean isEmpty() {
        return pilha1.isEmpty();
    }

    @Override
    public boolean isFull() {
        return pilha1.isFull();
    }
}
