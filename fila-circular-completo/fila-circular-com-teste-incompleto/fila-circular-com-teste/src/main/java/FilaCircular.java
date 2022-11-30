public class FilaCircular {
  int tamanho, inicio, fim;
  String[] fila;

  // Construtor - Recebe a capacidade da fila (tamanho total do vetor)
  public FilaCircular(int capacidade) {
    // Cria o vetor para armazenar a fila e inicializa o tamanho
    fila = new String[capacidade];
    tamanho = 0;
    inicio = 0;
    fim = 0;
  }

  // Método isEmpty() - Retorna true se a fila está vazia e false caso contrário
  public boolean isEmpty() {
    return tamanho == 0;
  }

  // Método isFull() - Retorna true se a fila está cheia e false caso contrário
  public boolean isFull() {
    return tamanho == fila.length;
  }

  // Método insert - Recebe informação a ser inserida na fila
  public void insert(String info) {
    if (isFull()) {
      throw new IllegalStateException("Fila cheia");
    }
    else {
      fila[fim] = info;
      fim = (fim + 1) % fila.length;
      tamanho++;
    }
  }

  // Método peek() - Retorna o primeiro da fila, sem remover
  public String peek() {
    return fila[inicio];
  }

  // Método poll() - Retorna o primeiro da fila, removendo-o
  public String poll() {
    String primeiro = peek();
    if (!isEmpty()) {
      fila[inicio] = null;   // limpa o elemento removido
      inicio = (inicio+1) % fila.length;
      tamanho--;
    }
    return primeiro;
  }

  // Método exibe() - exibe os elementos da fila
  public void exibe() {
    if (isEmpty()) {
      System.out.println("Fila vazia");
    }
    else {
      for (int ind=inicio, cont=0; cont<tamanho; ind=(ind+1)%fila.length,cont++) {
        System.out.println(fila[ind]);
      }
    }
  }

  public int getTamanho() {
    return tamanho;
  }

  public int getInicio() {
    return inicio;
  }

  public int getFim() {
    return fim;
  }

  // Cria um vetor e percorre a fila adicionando os elementos no vetor (
  // Retorna o vetor criado e não a fila
  public String[] getFila(){
    String[] vetor = new String[tamanho];

    for (int ind=inicio, cont=0, indVet=0; cont<tamanho; ind=(ind+1)%fila.length,cont++) {
      vetor[indVet++] = fila[ind];
    }

    return vetor;
  }

}
