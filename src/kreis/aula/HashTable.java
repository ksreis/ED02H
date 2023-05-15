package kreis.aula;

	import java.util.ArrayList;
	import java.util.List;

	public class HashTable {
	    private List<List<Integer>> table;

	    public HashTable(int size) {
	        table = new ArrayList<>();
	        for (int i = 0; i < size; i++) {
	            table.add(new ArrayList<>());
	        }
	    }

	    public void insert(int number, int size) {
	        int position = hash(number, size);
	        table.get(position).add(number);
	    }

	    private int hash(int numero, int tamanhoTabela) {
	    if (numero % 2 == 0) {
	        return numero % (tamanhoTabela / 2);
	    } else {
	        return numero % (tamanhoTabela / 2) + tamanhoTabela / 2;
		}
	 }

		public List<Integer> get(int number, int size) {
	        int position = hash(number, size);
	        return table.get(position);
	    }

	    public static void main(String[] args) {
	        int size = 10; // Tamanho da tabela de espalhamento
	        HashTable hashTable = new HashTable(size);

	        // Vetor de teste com números aleatórios
	        int[] vetor = {5, 12, 8, 3, 7, 16, 10, 21, 14, 9};

	        // Inserir números na tabela de espalhamento
	        for (int number : vetor) {
	            hashTable.insert(number, size);
	        }

	        // Exemplo de consulta de números pares
	        int par = 12;
	        List<Integer> pares = hashTable.get(par, size / 2);
	        System.out.println("Números pares: " + pares);

	        // Exemplo de consulta de números ímpares
	        int impar = 9;
	        List<Integer> impares = hashTable.get(impar, size / 2);
	        System.out.println("Números ímpares: " + impares);
	    
	}
}
