import java.util.Arrays;

//package implementacao2;

public class BrincandoComOrdenacao {
    
    public static void main(String[] args) {
        //TODO Codifique o experimento pedido. Crie metodos auxiliares para facilitar.
	
	int[] inteiros = {23, 8, 4, 3, 2, 1, 1};

		System.out.println(Arrays.toString(inteiros));
		//bubbleSort(inteiros);
		//selectionSort(inteiros);
		//insertionSort(inteiros);
		//mergeSort(inteiros, 0, inteiros.length -1);
		//quickSort(inteiros, 0, inteiros.length -1);
		countingSort(inteiros);
                System.out.println(Arrays.toString(inteiros));

    }
	
	//Metodo de Troca
	public static  void troca(int[] vetor, int i, int j)
	{
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}


	//ALGORITMO BUBBLE SORT
	public static void bubbleSort(int[] vetor){
		//TODO ...
		int tamanhoVetor = vetor.length;

		for(int i=0; i<tamanhoVetor-1; i++)
		{
			for(int j=0; j<tamanhoVetor-1; j++)
			{
				if(vetor[j] > vetor[j+1])
				{
					troca(vetor, j, j+1);
				}
			}
		}
	}
	
	
	//ALGORITMO SELECTION SORT
	public static void selectionSort(int[] vetor) {
		//TODO ...
		int tamanhoVetor = vetor.length;

		for(int i=0; i<tamanhoVetor-1; i++)
		{
			int min = i;
			for(int j=i+1; j<tamanhoVetor; j++)
			{
				if(vetor[j] < vetor[min])
					min = j;
			}
			troca(vetor, i, min);
		}
	}

	
	//ALGORITMO INSERTION SORT
	public static void insertionSort(int[] vetor) {
		//TODO ...
		int tamanhoVetor = vetor.length;

		for(int j=1; j<tamanhoVetor; j++)
		{
			int key = vetor[j];
			int i = j-1;
			while((i >= 0) && (vetor[i] >= key))
			{
				vetor[i+1] = vetor[i];
				i= i-1;
			}
			vetor[i+1] = key;
		}
	}

	public static void mergeTheTwoSortedLists(int[] vetor, int indiceInicio, int meio, int indiceFim)
	{
		int[] auxiliar = new int[vetor.length];
		//Copiando parte ta lista que vai ser ordenada
		for(int i=indiceInicio; i<=indiceFim; i++)
		{
			auxiliar[i] = vetor[i];
		}
		//indices Auxiliares.
		int i = indiceInicio;
		int j = meio +1;
		int k = indiceInicio;
		//junção das listas ordenadas
		while((i<=meio) && (j<=indiceFim))
		{
			if(auxiliar[i] < auxiliar[j])
			{
				vetor[k] = auxiliar[i];
				i++;
			}
			else
			{
				vetor[k] = auxiliar[j];
				j++;
			}

			k++;
		}
		//append de itens que n foram usados na junção
		while(i <= meio)
		{
			vetor[k] = auxiliar[i];
			i++;
			k++;
		}
		//append de intens que n foram usados na junção
		while(j <= indiceFim)
		{
			vetor[k] = auxiliar[j];
			j++;
			k++;
		}

	}


	//ALGORITMO MERGE SORT
	public static void mergeSort(int[] vetor, int indiceInicio, int indiceFim) {
		//TODO ...
		if((indiceInicio < indiceFim) && (indiceFim >= 0))
		{
			int meio = ((indiceFim + indiceInicio)/2);

			mergeSort(vetor, indiceInicio, meio);
			mergeSort(vetor, meio +1, indiceFim);

			mergeTheTwoSortedLists(vetor, indiceInicio, meio, indiceFim);

		}
	}

	public static int separar(int[] vetor, int esquerda, int direita)
	{
		int pivo = vetor[esquerda];
		int i = esquerda + 1;
		int j = direita;

		while(i <= j)
		{
			if(vetor[i] <= pivo)
				i++;
			else if(vetor[j] > pivo)
				j--;
			else
				troca(vetor, i, j);
		}
		troca(vetor, esquerda, j);
		return j; //posição do pivo
	}
	
	//ALGORITMO QUICKSORT
	public static void quickSort(int[] vetor, int esquerda, int direita) {
		//TODO ...
                //int esquerda = 0;
                //int direita = vetor.length - 1;
                
		if(esquerda < direita)
		{
			int pivo = separar(vetor, esquerda, direita);
			quickSort(vetor, esquerda, pivo -1);
			quickSort(vetor, pivo +1, direita);
		}
	}
        
        public static int acharDominio(int[] vetor)
        {
            int maior = 0;
            
            for(int i=0; i<vetor.length; i++)
            {
                if(vetor[i] > maior)
                    maior = vetor[i] + 1;
            }
            
            return maior;
        }
	

	//ALGORITMO COUNTING SORT
	public static void countingSort(int[] vetor){
		//TODO ...
                int dominio = acharDominio(vetor);
		int[] vetorB = new int[vetor.length];
		int[] vetorC = new int[dominio];

		for(int j=0; j<vetor.length; j++)
			vetorC[vetor[j]] = vetorC[vetor[j]] +1;
		for(int i=1; i<dominio; i++)
			vetorC[i] += vetorC[i-1];
		for(int j=vetor.length-1; j>=0; j--)
		{
			vetorB[vetorC[vetor[j]]-1] = vetor[j];
			vetorC[vetor[j]] = vetorC[vetor[j]] -1;
		}
                //Copiando o vetor de saida no vetor de entrada
                for(int i=0; i<vetor.length; i++)
                {
                    vetor[i] = vetorB[i];
                }
	}
    
}
