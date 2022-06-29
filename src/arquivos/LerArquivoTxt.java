package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {
		
		/*Entrada de dados*/
		FileInputStream entradaArquivo = new FileInputStream(new File("E:\\workspace-JDEV\\arquivos\\src\\arquivos\\arquivo.txt"));
		
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		/*Para ler o arquivo preciso de um While*/
		
		/*criando a lista de pessoas*/
		List<Pessoa> pessoas = new ArrayList<>();
		
		while (lerArquivo.hasNext()) { /*enquanto o ler arquivos tiver dados*/
			
			String linha = lerArquivo.nextLine();
			
			if(linha != null && !linha.isEmpty()) {// se linha for diferente de nula e linha for diferente de vazio
				
				String dados[] = linha.split("\\,");/*separação de dados por ;*/
				
				Pessoa pessoa = new Pessoa(); //criando um objeto pessoa para cada linha
				pessoa.setNome(dados[0]); //pegando o nome e colocando na primeira posição do array
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
				pessoas.add(pessoa);// adicionando a pessoa que foi criada a lista de pessoas
			}
		}
		
		for (Pessoa pessoa : pessoas) {
			
			System.out.println(pessoa);
		}
	}
}
