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
		
		System.out.print(tree.quantNode + "oi");
		
		
//		BinaryTree tree = new BinaryTree();
//		tree.root = new Node(32); 
//		tree.root.left = new Node(13); 
//		tree.root.left.left = new Node(5);
//		tree.root.left.right = new Node(20); 
//		tree.root.right = new Node(41); 
//		tree.root.right.right = new Node(60); 
//		tree.inserir(tree.root, 37);
//		tree.root = new Node(5); 
//		tree.root.left = new Node(3);
//		tree.root.right = new Node(8); 
//		tree.root.right.left = new Node(6);
//		tree.root.right.right = new Node(9); 
//		tree.calcularAltura(tree.root);
//		tree.posicaoSimetricaRecursiva(tree.root, 0);
		
//		System.out.print(tree.pre_ordem() + " preordem \n");
		
//		System.out.print(tree.media(32) + " media\n");
		
//		System.out.print(tree.quantNode + "\n");
//		System.out.print(tree.mediana() + " mediana\n");
		
//		System.out.print(tree.posicao(60) + " posicao\n");
//		System.out.print(tree.enesimoElemento(6) + " enesimo\n");
//		System.out.print(tree.root.altura + " altura\n");
//		System.out.print(tree.ehCheia() + " cheia\n");
//		System.out.print(tree.ehCompleta() + " completa\n");
//		tree.imprimirArvore(1);
//		tree.Deletar(tree.root, 31);
//		tree.calcularAltura(tree.root);
//		tree.posicaoSimetricaRecursiva(tree.root, 0);
//		tree.imprimirArvore(1);
		
//		tree.posicaoSimetricaRecursiva(tree.root, 0);
//		tree.ordemSimetricaRecursiva();
		
		

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

}
