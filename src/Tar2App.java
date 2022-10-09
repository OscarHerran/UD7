
import java.util.*;
public class Tar2App {
	//final Scanner ASK = new Scanner(System.in); *** PREGUNTAR PORQUE NO APLICA LA CONSTANTE DE ÁMBITO GLOBAL COMO SCANNER ???????????? ***
	public static void main(String[] args) {


		getList();
	}

	
	public static double giveChange(int payment, double calculateTotal) {// MÉTODO QUE CALCULA EL CAMBIO A DEVOLVER
		Scanner text = new Scanner(System.in);

		return payment - calculateTotal;
	}
	
	public static double calculateTotal(int countProducts, double totalPrice) {// MÉTODO QUE CALCULA EL TOTAL A PAGAR
	
		double saleQuantity = 0;
		
		saleQuantity = countProducts * totalPrice;
		
		return saleQuantity;
	}
	
	public static double optionIVA(int product) {// MÉTODO QUE ESTABLECE EL PORCENTAJE DE IVA
		double optionIVA = 0; 

		if(product == 4) {
			optionIVA = 0.04;
		} else if(product == 21) {
			optionIVA = 0.21;
		} else {
			System.out.println("Debe de elegir una de las opciones descritas");
		}
		
		return optionIVA;
	}

	public static double price_with_tax(double price, double optioIVA) {//MÉTODO QUE ESTABLECE EL PRECIO CON IVA INCLUIDO
		double totalPrice = price + price * optioIVA;
		
		return totalPrice;
	}
	
	public static void getList() {// MÉTODO QUE INICIA EL PROGRAMA Y ESTABLECE LOS VALORES A LLENAR EN EL ARRAY
		Scanner text = new Scanner(System.in);
		List <Double> car = new ArrayList <>();
		
		System.out.println("Desea realizar la compra ?");
		String question = text.next(); 
		
		if(question.equals("si")) {
			do {
				System.out.println("Indique el IVA a aplicar = 4 o 21 % ");
				int product = text.nextInt();
				System.out.println("Indique el precio del producto para aplicar IVA = ");
				double price = text.nextInt();
				System.out.println("Indique la cantidad de productos para totalizar?");
				int countProducts = text.nextInt();
				System.out.println("Indique la cantidad de dinero a abonar?");
				int payment = text.nextInt(); 
				
				//LLAMADO A LOS MÉTODOS
				
				car.add(optionIVA(product));//MÉTODO ELIGE IVA
				car.add(price);//PRECIO
				car.add((price_with_tax(price, optionIVA(product))));//MÉTODO QUE ESTABLECE EL PRECIO CON IVA
				car.add((calculateTotal(countProducts, price_with_tax(price, optionIVA(product)))));// MÉTODO QUE TOTALIZA LA CANTIDAD A PAGAR
				car.add((giveChange(payment, calculateTotal(countProducts, price_with_tax(price, optionIVA(product))))));// MÉTODO QUE ESTABLECE LA CANTIDAD DE VUELTO
				printList(car);
				System.out.println("Desea realizar la compra ?");
				question = text.next(); 
			}while(question != "no");
		} else {
			System.out.println("Hasta pronto...");
		}

	}
	
	public static void printList(List <Double> car) {// MÉTODO PARA IMPRIMIR EL ARRAYLIST CON CADA VALOR
		
			System.out.println("EL IVA aplicado es = " + car.get(0));
			System.out.println("EL precio bruto  es = " + car.get(1));
			System.out.println("EL precio total con IVA es = " + car.get(2));
			System.out.println("La cantidad a pagar es = " + car.get(3));
			System.out.println("El vuelto de su pago es = " + car.get(4));
	}
}