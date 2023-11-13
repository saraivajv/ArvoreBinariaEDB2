package arvore;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	Node root;
	int quantNode;
	public int i;
	public int j = 0;
	public boolean b;
	
	public BinaryTree(List<Integer> listan) {
        for (Integer n : listan) {
            inserir(this.root, n);
        }
        this.calcularAltura(this.root);
        this.posicaoSimetricaRecursiva(this.root, 0);
    }
	
	public void ordemSimetricaRecursiva() {
		ordemSimetricaRecursiva(this.root);
	}
	
	public void ordemSimetricaRecursiva(Node node) {
		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			ordemSimetricaRecursiva(node.left);
		}
		
		System.out.print(node.data + " ");
		
		if(node.right != null) {
			ordemSimetricaRecursiva(node.right);
		}
	}
	
	public int posicaoSimetricaRecursiva(Node node, int cont) {
		if(node.left != null) {
			cont = posicaoSimetricaRecursiva(node.left, cont);
		}
		
		cont++;
		node.setPosicaoSimetrica(cont);
		
		if(node.right != null) {
			cont = posicaoSimetricaRecursiva(node.right, cont);
		}
		this.quantNode = cont;
		
		this.b = false;
		return cont;
	}
	
	public int posicao(int x) {
		Node node = this.root;
		if(node.data == x) {
			return node.posicaoSimetrica;
		}
		while(node.data != x) {
			if(x < node.data && node.left != null) {
				node = node.left;
			}
			if(x > node.data && node.right != null) {
				node = node.right;
			}
		}
		return node.posicaoSimetrica;
	}
	
	public int enesimoElemento(int n) {
		Node node = this.root;
		if(node.posicaoSimetrica == n) {
			return node.data;
		}
		while(node.posicaoSimetrica != n) {
			if(n < node.posicaoSimetrica && node.left != null) {
				node = node.left;
			}
			if(n > node.posicaoSimetrica && node.right != null) {
				node = node.right;
			}
		}
		return node.data;
	}
	
	public int mediana() {
		int n1, n2;
		int n = 0;;
		if(this.quantNode % 2 == 0) {
			n1 = enesimoElemento(this.quantNode/2);
			n2 = enesimoElemento(1 + this.quantNode/2);
			if(n1 <= n2) {
				n = n1;
				return n;
			}
			else if(n2 <= n1) {
				n = n2;
				return n;
			}
		}
		else {
			n = enesimoElemento(1 + this.quantNode/2);
			return n;
		}
		
		return n;
	}
	
	public double getNodeSoma(Node node, double soma) {
		
		if(node.left != null) {
			soma = getNodeSoma(node.left, soma);
		}
		this.i++;
		soma += node.data;
		
		if(node.right != null) {
			soma = getNodeSoma(node.right, soma);
		}
		
		return soma;
	}
	
	public double media(int x) {
		Node aux = this.BuscaMedia(this.root, x, 0);
		double media = 0;
		media = getNodeSoma(aux, 0);
		media = media/this.i;
		this.i = 0;
		return media;
	}
	
	public String pre_ordem() {
		String s = "";
		return pre_ordem(this.root, s);
	}
	
	public String pre_ordem(Node node, String s) {
		if(node != null){
			s += (node.data + " ");
			if(node.left != null) {
				s = pre_ordem(node.left, s);
			}
			if(node.right != null) {
				s = pre_ordem(node.right, s);
			}
			return s;
		}
		return s;
	}
		
	public void calcularAltura(Node node) {
        if (node.left != null) calcularAltura(node.left);
        if (node.right != null) calcularAltura(node.right);
        node.calcularAltura(node);
    }
	
	
	public boolean ehCheia() {
		return ehCheia(this.root, false);
	}
	
	
	public boolean ehCheia(Node node, boolean status) {
		if(node.altura == 1) {
			return true;
		}
		else if(node.right == null || node.left == null) {
			return false;
		}
		
		status = ehCheia(node.left, status);
		
		if(status == false) {
			return status;
		}
		
		status = ehCheia(node.right, status);
		
		return status;
	}
	
	public boolean ehCompleta() {

		if(this.root.altura == 1 + Math.floor(Math.log(this.quantNode)/Math.log(2))) {
			return true;
		}
		return false;
	}
	
	public void imprimirArvore(int i) {
		if(i == 1) {
			imprimirTraco(this.root, 0);
		}
		if(i == 2) {
			imprimirParentese(this.root);
		}
		System.out.println();
	}
	
	public void imprimirTraco(Node node, int level) {
		if(node != null){
			for(int i = 0; i < level; i++) {
				System.out.print("   ");
			}
				System.out.print(node.data);
				for(int i = 10; i > level; i--) {
					if(node.data < 10 && i == level+1) {
						System.out.print("-");
					}
					System.out.print("---");
				}
				System.out.println();
				if(node.left != null) {
					imprimirTraco(node.left, level + 1);
				}
				if(node.right != null) {
					imprimirTraco(node.right, level + 1);
				}
		}
	}
	
	public void imprimirParentese(Node node) {
		if(node != null){
			System.out.print("(" + node.data);
			if(node.left != null) {
				imprimirParentese(node.left);
			}
			if(node.right != null) {
				imprimirParentese(node.right);
			}
			System.out.print(")");
		}
	}
	
	
	public void inserir(Node node, int valor) {
        if (this.root == null) {
            this.root = new Node(valor);
            if(j > 5) {
            	System.out.printf("%d adicionado\n", valor);
            }
            this.j++;
            return;
        }

        if (valor < node.data) {
            if (node.left != null) {
            	inserir(node.left, valor);
            }
            else {
            	node.left = new Node(valor);
            	if(j > 5) {
            		System.out.printf("%d adicionado\n", valor);
            	}
            	this.j++;
            }
            
        } else if (valor > node.data) {
            if (node.right != null) {
            	inserir(node.right, valor);
            }
            else {
            	node.right = new Node(valor);
            	if(j > 5) {
            		System.out.printf("%d adicionado\n", valor);
            	}
            	this.j++;
            }
        } else {
            System.out.printf("%d já está na árvore, não pode ser inserido", valor);
            System.out.println();
            return;
        }
    }
	
	
	
	public Node Busca(Node node, int valor, int f) {
		Node aux = new Node();
		if(node != null) {
			if(node.data == valor) {
				f = 1;
				//consertar
				System.out.print("Chave encontrada\n");
				return node;
			}
			else if(valor < node.data) {
				if(node.left == null) {
					f = 2;
					System.out.print("Chave não encontrada\n");
					return node.left;
				}
				else {
					node = node.left;
				}
			}
			else if(valor > node.data) {
				if(node.right == null) {
					f = 3;
					System.out.print("Chave não encontrada\n");
					return node.right;
				}
				else {
					node = node.right;
				}
			}
			if(f == 0) {
				aux = Busca(node, valor, f);
			}
		}
		return aux;
	}
	
	public Node BuscaMedia(Node node, int valor, int f) {
		Node aux = new Node();
		if(node != null) {
			if(node.data == valor) {
				f = 1;
				return node;
			}
			else if(valor < node.data) {
				if(node.left == null) {
					f = 2;
					return node.left;
				}
				else {
					node = node.left;
				}
			}
			else if(valor > node.data) {
				if(node.right == null) {
					f = 3;
					return node.right;
				}
				else {
					node = node.right;
				}
			}
			if(f == 0) {
				aux = BuscaMedia(node, valor, f);
			}
		}
		return aux;
	}
	
	public Node Deletar(Node node, int valor) {
		if(node == null) {
			return node;
		}
		if(valor < node.data) {
			node.left = Deletar(node.left, valor);
		}
		else if(valor > node.data) {
			node.right = Deletar(node.right, valor);
		}
		else {
			if(node.left == null) {
				return node.right;
			}
			else if(node.right == null) {
				return node.left;
			}
			
			node.data = sucessorOrdemSimetrica(node.right);
			node.right = Deletar(node.right, node.data);
		}
		if(node.data == this.root.data && this.b == false){
			System.out.print(valor + " removido\n");
		}
		if(node.right == null && node.left == null) {
			System.out.print(valor + " não está na árvore, não pode ser removido\n");
			this.b = true;
		}
		return node;
	}
	
	 public int sucessorOrdemSimetrica(Node node) {
	        int minimo = node.data;
	        while (node.left != null) {
	        	minimo = node.left.data;
	        	node = node.left;
	        }
	        return minimo;
	    }
	
}
