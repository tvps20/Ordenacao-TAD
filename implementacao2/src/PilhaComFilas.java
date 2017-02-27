public class PilhaComFilas implements Pilha_IF 
{
    private FilaComArray pilha = new FilaComArray();

    @Override
    public void push(int element) throws Exception {

    }

    @Override
    public int pop() throws Exception {
        return 0;
    }

    @Override
    public int top() throws Exception {
        return 0;       
    }

    @Override
    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    @Override
    public boolean isFull() {
        return pilha.isFull();
    }
    
}
