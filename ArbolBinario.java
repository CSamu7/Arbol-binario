package informatica;

public class ArbolBinario {
	
	private Nodo nodoRaiz; //Definimos el nodo raiz del arbol
	
	public ArbolBinario() { //Creamos un constructor estandar, por si el usuario no quiere definir cuanto va a valer el nodo raíz.

	}; 
	
	public ArbolBinario(int numero) { //Creamos otro constructor, por si el usuario quiere definir cuanto va a valer el nodo raiz
		nodoRaiz = new Nodo(numero);
	}

	public Nodo insertarNodo(int numero, Nodo nodoRaiz) { //Metodo que usaremos para la recursión
		if(nodoRaiz == null) {
			return new Nodo(numero); //Si el nodo de la raiz no tiene un numero, que se le agregue un Nodo
		}
		if(nodoRaiz.getNumero() > numero) {
			nodoRaiz.setNodoIzquierdo(insertarNodo(numero, nodoRaiz.getNodoIzquierdo())); //Que se inserte el nodo izquierdo has
		}
		if(nodoRaiz.getNumero() < numero) {
			nodoRaiz.setNodoDerecho(insertarNodo(numero, nodoRaiz.getNodoDerecho()));
		}else {
			return nodoRaiz;
		}
		return nodoRaiz;
	}
	
	public void insertarNodo(int numero) { //Metodo que usara el usuario para agregar el nodo
		nodoRaiz = insertarNodo(numero, nodoRaiz); //Aplicamos el metodo de la recursión
	}
	
	public void mostrarInorden(Nodo nodoRaiz) {
		if(nodoRaiz != null) {
			mostrarInorden(nodoRaiz.getNodoIzquierdo()); 
			System.out.println(""+nodoRaiz.getNumero());
			mostrarInorden(nodoRaiz.getNodoDerecho());
		}
	}
	
	public void mostrarInorden() {
		mostrarInorden(nodoRaiz);
	}
	
	public void mostrarPreorden(Nodo nodoRaiz) {
		if(nodoRaiz != null) {
			System.out.println(""+nodoRaiz.getNumero());
			mostrarPreorden(nodoRaiz.getNodoIzquierdo());
			mostrarPreorden(nodoRaiz.getNodoDerecho());
		}
	}
	
	public void mostrarPreorden() {
		mostrarPreorden(nodoRaiz);
	}
	
	public void mostrarPostorden(Nodo nodoRaiz) {
		if(nodoRaiz != null) {
			mostrarPreorden(nodoRaiz.getNodoIzquierdo());
			mostrarPreorden(nodoRaiz.getNodoDerecho());
			System.out.println(""+nodoRaiz.getNumero());
		}
	}
	
	public void mostrarPostorden() {
		mostrarPostorden(nodoRaiz);
	}
	
	public boolean buscarNumero(int numero, Nodo nodoRaiz) {
		if(nodoRaiz == null) {
			return false;
		}
		if(nodoRaiz.getNumero() == numero) {
			return true;
		}
		return numero < nodoRaiz.getNumero()
				? buscarNumero(numero, nodoRaiz.getNodoIzquierdo())
				: buscarNumero(numero, nodoRaiz.getNodoDerecho());
	}
	
	public void buscarNumero(int numero) {
		if(buscarNumero(numero, nodoRaiz)) {
			System.out.println("Se encontro el numero "+numero+" en el arbol"); 
		}else {
			System.out.println("No se encontro el numero "+numero+" en el arbol"); 
		}
	}
	
	public Nodo eliminarNumero(int numero, Nodo nodoRaiz) {
		if(nodoRaiz == null) {
			return nodoRaiz; 
		}
		
		if(nodoRaiz.getNumero() > numero) {
			nodoRaiz.setNodoIzquierdo(eliminarNumero(numero, nodoRaiz.getNodoIzquierdo()));
		}else if(nodoRaiz.getNumero() < numero) {
			nodoRaiz.setNodoDerecho(eliminarNumero(numero, nodoRaiz.getNodoDerecho()));
		}else {
			if(nodoRaiz.getNodoIzquierdo() == null && nodoRaiz.getNodoDerecho() == null) {
				return null;
			}else if(nodoRaiz.getNodoIzquierdo() == null ) {
				return nodoRaiz.getNodoDerecho();
			}else if(nodoRaiz.getNodoDerecho() == null) {
				return nodoRaiz.getNodoIzquierdo();
			}else {
				int minimoValorDelArbol = minimoValor(nodoRaiz.getNodoDerecho());
				nodoRaiz.setNumero(minimoValorDelArbol);
				nodoRaiz.setNodoDerecho(eliminarNumero(minimoValorDelArbol, nodoRaiz.getNodoDerecho()));
			}
		}
		
		return nodoRaiz;
	}
	
	public void eliminarNumero(int numero) {
		eliminarNumero(numero, nodoRaiz);
	}
	
	public int minimoValor(Nodo nodoRaiz) {
		if(nodoRaiz.getNodoIzquierdo() != null) {
			return minimoValor(nodoRaiz.getNodoIzquierdo());
		}
		return nodoRaiz.getNumero();
	}
}
