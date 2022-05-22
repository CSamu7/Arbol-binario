package informatica;

public class Nodo {

	//Definimos que tipo de dato vamos a enviar en el arbol binario
	 int numero;
	
	//Definimos nuestros nodos izquierdos y derechos.
	private Nodo nodoDerecho;
	private Nodo nodoIzquierdo;
	
	public Nodo(int numero) { //Hacemos el constructor que va a pedir el dato que se va a enviar al arbol binario
		this.numero = numero;
		nodoDerecho = nodoIzquierdo = null; //El nodo al momento de generarse, tendra sus nodos izquierdos y derechos null, sin datos.	
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Nodo getNodoDerecho() {
		return nodoDerecho;
	}

	public void setNodoDerecho(Nodo nodoDerecho) {
		this.nodoDerecho = nodoDerecho;
	}

	public Nodo getNodoIzquierdo() {
		return nodoIzquierdo;
	}

	public void setNodoIzquierdo(Nodo nodoIzquierdo) {
		this.nodoIzquierdo = nodoIzquierdo;
	}
}
