package informatica;

public class ArbolBinario {
	
	private Nodo nodoRaiz; //Definimos el nodo raiz del arbol, esto nos ayudara para la recursion.
	
	public ArbolBinario() { //Creamos un constructor estandar, por si el usuario no quiere definir cuanto va a valer el nodo raíz.

	}; 
	
	public ArbolBinario(int numero) { //Creamos otro constructor, por si el usuario quiere definir cuanto va a valer el nodo raiz del arbol.
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
		nodoRaiz = insertarNodo(numero, nodoRaiz); //Aplicamos el metodo de la recursividad
	}
	
	public void mostrarInorden(Nodo nodoRaiz) { //Metodo que usaremos para la recursividad.
		if(nodoRaiz != null) {	//Si el nodo no esta vacio, que haga lo siguiente:
			mostrarInorden(nodoRaiz.getNodoIzquierdo()); //Busque de manera recursiva su nodo izquierdo
			System.out.println(""+nodoRaiz.getNumero()); //Muestre el valor del nodo raiz
			mostrarInorden(nodoRaiz.getNodoDerecho()); // Busque de manera recursiva su nodo derecho
		}
	}
	
	public void mostrarInorden() { //Metodo que usara el usuario
		mostrarInorden(nodoRaiz);
	}
	//Y repetimos lo mismo para los siguientes formas de procesar el arbol binario, solo cambiando el orden en que se haran.
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
	
	public boolean buscarNumero(int numero, Nodo nodoRaiz) {//Nuevamente, un metodo que nos ayudara a la recursividad.
		if(nodoRaiz == null) { //Si el nodo esta vacio, que regrese un false.
			return false;
		}
		if(nodoRaiz.getNumero() == numero) { // Si encuentra el numero en el nodo raiz, que devuelva un true.
			return true;
		}
		
		return numero < nodoRaiz.getNumero() //Si el numero es menor que el nodo raiz
				? buscarNumero(numero, nodoRaiz.getNodoIzquierdo()) // Que lo empiece a buscar por el nodo izquierdo
				: buscarNumero(numero, nodoRaiz.getNodoDerecho()); // Que lo empiece a buscar por el nodo derecho
	}
	
	public void buscarNumero(int numero) { // Metodo que usara el usuario.
		if(buscarNumero(numero, nodoRaiz)) { //Si el metodo nos devuelve un true, entonces mandamos este mensaje
			System.out.println("Se encontro el numero "+numero+" en el arbol"); 
		}else { // Si el metodo no lo encuentra, que mande este mensaje.
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
