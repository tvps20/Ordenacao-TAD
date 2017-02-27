public class PilhaComArray implements Pilha_IF 
{
    int[] pilha;
    int top;
    
    public PilhaComArray()
    {
        pilha = new int[10];
        top = -1;
    }
    
    @Override
    public void push(int element) throws Exception {
        if(isFull())
            throw new Exception("Overflow");
        else
        {
            top += 1;
            pilha[top] = element;
        }
    }

    @Override
    public int pop() throws Exception {
        if(isEmpty())
            throw new Exception("Underflow");
        else
        {
            top -= 1;
            return pilha[top +1];
        }
    }

    @Override
    public int top() throws Exception {
        if(isEmpty())
            throw new Exception("Underflow");
        else
            return pilha[top];
    }

    @Override
    public boolean isEmpty() {
        if(top == -1)
            return true;
        else
            return false;
    }

    @Override
    public boolean isFull() {
        if(top == pilha.length -1)
            return true;
        else
            return false;
    }   
}
