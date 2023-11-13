package arvore;

public class Node {
	
	public Node() {
		
	}

	public Node(int valor) {
		this.data = valor;
		this.left = this.right = null;
		this.altura = 1;
	}
	int data;
	public int altura;
	Node left, right;
	int posicaoSimetrica;
	
	
	public void calcularAltura(Node node) {
        int alturaEsq, alturaDir;

        if (node.left != null) alturaEsq = node.left.altura;
        else alturaEsq = 0;

        if (node.right != null) alturaDir = node.right.altura;
        else alturaDir = 0;

        if (alturaEsq > alturaDir) node.altura = alturaEsq + 1;
        else node.altura = alturaDir + 1;
    }
	
	public void setPosicaoSimetrica(int n) {
		this.posicaoSimetrica = n;
	}
	
}
