package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		Pessoa pessoa3 = new Pessoa();
		Pessoa pessoa4 = new Pessoa();
		
		
		pessoa1.setEmail("pessoa1@hotmail.com");
		pessoa1.setIdade(33);
		pessoa1.setNome("Raimundo sousa");
		
		pessoa2.setEmail("pessoa2@hotmail.com");
		pessoa2.setIdade(24);
		pessoa2.setNome("Cladio Lopez");
		
		pessoa3.setEmail("pessoa3.@hotmail.com");
		pessoa3.setIdade(15);
		pessoa3.setNome("Maria Ribeiro");
		
		pessoa4.setNome("Vierinha Ferreira");
		pessoa4.setEmail("fr@gmail.com");
		pessoa4.setIdade(15);
		
		
		
		/*colocando tudo na lista de pessoas*/
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		File arquivo = new File("E:\\workspace-JDEV\\arquivos\\src\\arquivos\\arquivo.txt");
		FileWriter escreverNoArquivo = new FileWriter(arquivo); // objeto para escrever o arquivo

		if(!arquivo.exists()) { // se o arquivo nao existir, cria um novo
			arquivo.createNewFile();
		}
		else {
			System.out.println("Arquivo Existente atualizado");
		}
		
		for (Pessoa p : pessoas) {
			escreverNoArquivo.write("Nome: " + p.getNome() + ", E-Mail: " + p.getEmail() + ", Idade: " + p.getIdade() + " anos\n");
		}
		
		
		
		
//		for(int i = 1; i <= 10; i++) {
//			escreverNoArquivo.write("texto da linha " + i + " \n");
//		}
		escreverNoArquivo.flush();
		escreverNoArquivo.close(); // fechando o arquivo
	}
}
