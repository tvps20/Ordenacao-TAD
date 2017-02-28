public class PilhaComFilas implements Pilha_IF 
{
    private FilaComArray fila1;
    private FilaComArray fila2;
    private int top;
    
    public PilhaComFilas()
    {
        fila1 = new FilaComArray();
        fila2 = new FilaComArray();
        top = -1;
    }

    @Override
    public void push(int element) throws Exception {
        if(isFull())
            throw new Exception("Overflow");
        else
        {
            top += 1;
            fila1.enqueue(element);
        }
    }

    @Override
    public int pop() throws Exception {
        if(isEmpty())
            throw new Exception("Underflow");
        else
        {
            int elementoTop = 0;
            for(int i=0; i<=top; i++)
               fila2.enqueue(elementoTop = fila1.dequeue());
            for(int i=0; i<=top; i++)
            {
                int elementoAtual = fila2.dequeue();
                if(elementoAtual != elementoTop)
                    fila1.enqueue(elementoAtual);
            }
            top--;
            return elementoTop;
        }
    }

    @Override
    public int top() throws Exception {
        if(isEmpty())
            throw new Exception("Pilha Vazia");
        else
        {
            int elementoTop = 0;
            for(int i=0; i<=top; i++)
            {
                fila2.enqueue(elementoTop = fila1.dequeue());
                fila1.enqueue(fila2.dequeue());
            }
            
            return elementoTop;
        }
    }

    @Override
    public boolean isEmpty() {
        return fila1.isEmpty();
    }

    @Override
    public boolean isFull() {
        return fila1.isFull();
    }
    
}
