import java.util.Arrays;
import java.util.Random;

//package implementacao2;

public class BrincandoComOrdenacao {
    
    public static void main(String[] args) {
        //TODO Codifique o experimento pedido. Crie metodos auxiliares para facilitar.
	
	int[] inteiros = new int[2000];
        //int posicao = 0;
        
        //Incializando o vetor com elementos
        
        //for(int i=0; i<inteiros.length; i++)
        for(int i=inteiros.length -1; i>=0; i--)
        {
            int randomNum = new Random().nextInt(inteiros.length); //Gerando numero aleatorios com limite o tamanho da lista
            inteiros[i] = randomNum; //Gerando a lista com a entrada aleatória
            //inteiros[i] = i; //Gerando a lista com a entrada ordenada
            //inteiros[posicao] = i; //Gerando a lista com a entrada ordenada inversamente
            //posicao++;
        }              
            
            System.out.println("Lista com entrada inicia");
            System.out.println(Arrays.toString(inteiros));                       
        
        //Calculando o tempo de execução depois da ordenação e o tempo final
            long tempoAntesB = System.nanoTime();
            bubbleSort(inteiros.clone());
            long tempoDepoisB = System.nanoTime();
            long tempoFinalB = tempoDepoisB - tempoAntesB;
            System.out.println(); // Pulando linha
            System.out.println("Tempo de execursão b:");
            System.out.println(tempoFinalB);
            
            long tempoAntesS = System.nanoTime();
            selectionSort(inteiros.clone());
            long tempoDepoisS = System.nanoTime();
            long tempoFinalS = tempoDepoisS - tempoAntesS;
            System.out.println(); // Pulando linha
            System.out.println("Tempo de execursão S:");
            System.out.println(tempoFinalS);
            
            long tempoAntesI = System.nanoTime();
            insertionSort(inteiros.clone());
            long tempoDepoisI = System.nanoTime();
            long tempoFinalI = tempoDepoisI - tempoAntesI;
            System.out.println(); // Pulando linha
            System.out.println("Tempo de execursão I:");
            System.out.println(tempoFinalI);
            
            long tempoAntesM = System.nanoTime();
            mergeSort(inteiros.clone());
            long tempoDepoisM = System.nanoTime();
            long tempoFinalM = tempoDepoisM - tempoAntesM;
            System.out.println(); // Pulando linha
            System.out.println("Tempo de execursão M:");
            System.out.println(tempoFinalM);
            
            long tempoAntesQ = System.nanoTime();
            quickSort(inteiros.clone());
            long tempoDepoisQ = System.nanoTime();
            long tempoFinalQ = tempoDepoisQ - tempoAntesQ;
            System.out.println(); // Pulando linha
            System.out.println("Tempo de execursão Q:");
            System.out.println(tempoFinalQ);
            
            long tempoAntesC = System.nanoTime();
            countingSort(inteiros);
            long tempoDepoisC = System.nanoTime();
            long tempoFinalC = tempoDepoisC - tempoAntesC;
            System.out.println(); // Pulando linha
            System.out.println("Tempo de execursão C:");
            System.out.println(tempoFinalC);
            
            //System.out.println(); //Pulando linha
            //System.out.println("Lista ordenada");
            //System.out.println(Arrays.toString(inteiros));
            
            
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
        
        //Metodo Auxiliar para o mergeSorte receber como paramentro apenas um Vetor
        public static void mergeSortAux(int[] vetor, int indiceInicio, int indiceFim)
        {
            if((indiceInicio < indiceFim) && (indiceFim >= 0))
            {
                int meio = ((indiceFim + indiceInicio)/2);

                mergeSortAux(vetor, indiceInicio, meio);
                mergeSortAux(vetor, meio +1, indiceFim);

                mergeTheTwoSortedLists(vetor, indiceInicio, meio, indiceFim);

            }
        }


	//ALGORITMO MERGE SORT
	public static void mergeSort(int[] vetor) {
            //TODO ...
            int indiceInicio = 0;
            int indiceFim = vetor.length -1;
            
            mergeSortAux(vetor, indiceInicio, indiceFim);
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
	
        //Metodo auxiliar para o quickSort receber apenas um vetor como parametro.
        public static void quickSortAux(int[] vetor, int esquerda, int direita)
        {
            if(esquerda < direita)
            {
                int pivo = separar(vetor, esquerda, direita);
                quickSortAux(vetor, esquerda, pivo -1);
                quickSortAux(vetor, pivo +1, direita);
            }
        }
        
	//ALGORITMO QUICKSORT
	public static void quickSort(int[] vetor) {
		//TODO ...  
                int esquerda = 0;
                int direita = vetor.length -1;
                
		quickSortAux(vetor, esquerda, direita);
	}
        
        public static int acharDominio(int[] vetor)
        {
            int maior = vetor[0];
            
            for(int i=1; i<vetor.length; i++)
            {
                if(vetor[i] > maior)
                    maior = vetor[i];
            }
            
            return maior;
        }
	

	//ALGORITMO COUNTING SORT
	public static void countingSort(int[] vetor){
		//TODO ...
                int dominio = acharDominio(vetor) +1;
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
