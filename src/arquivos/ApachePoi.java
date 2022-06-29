package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		
		File file = new File("E:\\workspace-JDEV\\arquivos\\src\\arquivos\\arquivoExcel_xls.xls");
		
		if(!file.exists()) {//se o arquivo nao existe
			file.createNewFile(); //cria um novo arquivo
		}
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Ricardo Morais");
		pessoa1.setIdade(66);
		pessoa1.setEmail("pessoa1@gmail.com");
		
		pessoas.add(pessoa1);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Francisco Moura");
		pessoa2.setEmail("pessoa2@yahoo.com");
		pessoa2.setIdade(35);
		
		pessoas.add(pessoa2);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Gustavo Guanabara");
		pessoa3.setEmail("pessoa3@bol.com");
		pessoa3.setIdade(44);
		
		pessoas.add(pessoa3);
		
		/*criando o objeto do apache poi*/
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // usado para escrever a planilha
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("Planilha de Pessoas - Teste"); // criar a planilha
		
		int numLinhas = 0;
		
		/*para cada pessoa é criado uma linha*/
		for (Pessoa p : pessoas) { // varrer a lista de pessoas para criar as linhas
			Row linha = linhaPessoa.createRow(numLinhas ++); /*criando a linha na planilha*/
			
			int celula = 0;
			/*para cada atributo da pessoa é criado uma celula*/
			
			/*criando celula para nome - celula 1*/
			Cell celNome = linha.createCell(celula ++);
			celNome.setCellValue(p.getNome());
			
			/*criando celula para email - celula 2*/
			Cell celEmail = linha.createCell(celula ++);
			celEmail.setCellValue(p.getEmail());
			
			/*criando celula para idade - celula 3*/
			Cell celIdade = linha.createCell(celula ++);
			celIdade.setCellValue(p.getIdade());
			
		}/*terminou de montar a planilha*/
		
		/*fazer a saida*/
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida); /*escreve a planilha em arquivo*/
		saida.flush();
		saida.close();
		
		System.out.println("A planilha foi criada.");
	}

}
