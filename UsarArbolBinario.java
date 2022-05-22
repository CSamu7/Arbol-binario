package informatica;

public class UsarArbolBinario {

	public static void main(String[] args) {

		ArbolBinario miArbol = new ArbolBinario(3);
		
		miArbol.insertarNodo(4);
		miArbol.insertarNodo(5);
		miArbol.insertarNodo(2);
		miArbol.insertarNodo(8);
		miArbol.insertarNodo(7);
		
		miArbol.mostrarInorden();
		System.out.println("-----------");
		miArbol.mostrarPreorden();
		System.out.println("-----------");
		miArbol.mostrarPostorden();

		miArbol.buscarNumero(4);
		System.out.println("------------------------Luego de eliminar el nodo------------------------");
		miArbol.eliminarNumero(4);
		
		miArbol.buscarNumero(4);
		miArbol.buscarNumero(11);
	}
}
