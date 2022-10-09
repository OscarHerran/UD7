package Tar3App;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class BaDatos {
	
	public static void start() {
	Hashtable <String, Integer> products = new Hashtable <String, Integer> ();
		for(int i = 0; i <= 9; i++) {
				String product = JOptionPane.showInputDialog("Indique el producto");
				String quantity = JOptionPane.showInputDialog("Ingrese cantidad");
				int cantidad = Integer.parseInt(quantity);
				products.put(product, cantidad);
		}choice(products);
			JOptionPane.showMessageDialog(null, "Gracias, vuelva pronto");
		}	
	
	public static void choice(Hashtable <String, Integer> products) {
		String choice = JOptionPane.showInputDialog("Indique opcion: \n1. Buscar producto  \n2. Ver lista de productos");
		int choices = Integer.parseInt(choice);
		switch(choices) {
			case 1:
				String product = JOptionPane.showInputDialog("Indique el producto?").toLowerCase();
				searchHash(product, products);
				break;
			case 2:
				printData(products);
				break;
			default:
				break;
		}
	}
	public static void searchHash(String product, Hashtable <String, Integer> products) {
		System.out.println(products.get(product));
	}
	
	public static void printData(Hashtable <String, Integer> products) {
		Enumeration <Integer> elemento = products.elements();
		Enumeration <String> keys = products.keys();
		System.out.println("La lista de productos son = \n");
		while(elemento.hasMoreElements() && keys.hasMoreElements()) {
			System.out.println("Producto = " + keys.nextElement() + "\nCantidad = " + elemento.nextElement());
		}

	}
}