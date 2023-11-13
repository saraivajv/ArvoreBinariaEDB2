package arvore;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class Main {

	public static void main(String[] args) throws IOException {
		
		List<String> initialTree;
		List<String> comandos;
		
		
		initialTree = readF("src/files/arvoreinicial");
		comandos = readF("src/files/comandos");
		
		List<Integer> initialTreeInt = new ArrayList<>();
		
		for (String n : initialTree) {
			initialTreeInt.add(Integer.parseInt(n));
        }
		
		BinaryTree tree = new BinaryTree(initialTreeInt);
		
		for(String linha: comandos) {
			String[] split = linha.split(" ");
            String comando = split[0];
            String argumento = "";
            
            try {
                argumento = split[1];
            } catch (Exception e) {
                
            }
            
            entradaComando(comando, argumento, tree);
		}

	}
	
	public static List<String> readF(String fileName) throws IOException{
		File file = new File(fileName);
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    
	    List<String> saida = new ArrayList<>();

        while((line = br.readLine()) != null){
        	saida.add(line);
        }

        br.close();
        fr.close();
        
        return saida;
	}
	
	private static void entradaComando(String comando, String argumento, BinaryTree tree) {
        switch (comando) {
            case "INSIRA":
                tree.inserir(tree.root, Integer.parseInt(argumento));
                tree.posicaoSimetricaRecursiva(tree.root, 0);
                tree.calcularAltura(tree.root);
                break;
            case "REMOVA":
                tree.Deletar(tree.root, Integer.parseInt(argumento));
                tree.posicaoSimetricaRecursiva(tree.root, 0);
                tree.calcularAltura(tree.root);
                break;
            case "BUSCAR":
                tree.Busca(tree.root, Integer.parseInt(argumento), 0);
                break;
            case "ENESIMO":
                System.out.println(tree.enesimoElemento(Integer.parseInt(argumento)));
                break;
            case "POSICAO":
            	System.out.println(tree.posicao(Integer.parseInt(argumento)));
                break;
            case "MEDIANA":
            	System.out.println(tree.mediana());
                break;
            case "MEDIA":
            	System.out.println(tree.media(Integer.parseInt(argumento)));
                break;
            case "CHEIA":
            	boolean b = tree.ehCheia();
            	if(b == true) System.out.println("A árvore é cheia");
            	else System.out.println("A árvore não é cheia");
                break;
            case "COMPLETA":
            	boolean b2 = tree.ehCompleta();
            	if(b2 == true) System.out.println("A árvore é completa");
            	else System.out.println("A árvore não é completa");
                break;
            case "PREORDEM":
            	System.out.println(tree.pre_ordem());
                break;
            case "IMPRIMA":
                tree.imprimirArvore(Integer.parseInt(argumento));
                break;
        
            default:
                break;
        }
    }

}
