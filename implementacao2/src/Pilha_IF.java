package implementacao2;

public interface Pilha_IF {
	public void push(int element) throws Exception;
	public int pop() throws Exception;
	public int top() throws Exception;
	public boolean isEmpty();
	public boolean isFull();
}
