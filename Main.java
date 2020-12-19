import java.util.Random;
class Nodo{
	Nodo hijo_izq;
	Nodo hijo_der;
	
	private int dato;
	
		Nodo(int dato){
			this.dato = dato;
			hijo_izq = null;
			hijo_der = null;
		}
		
	void NuevoNodo(Nodo nodo){
		if(nodo.dato < dato)
			if(hijo_izq==null)
				hijo_izq = nodo;//De esta forma llevandose todo el dato de nodo
			else
				hijo_izq.NuevoNodo(nodo);
		else if(nodo.dato > dato)
			if(hijo_der==null)
				hijo_der = nodo;
			else
				hijo_der.NuevoNodo(nodo);
	}//Se crea el nuevo nodo segun su magnitud
	
	void RecorrerNodoA(){
		if(hijo_izq != null)
			hijo_izq.RecorrerNodoA();//Para recorrer todo los nodos izq
		System.out.println(dato);//Metodo de recorrido en en orden
		if(hijo_der!=null)
			hijo_der.RecorrerNodoA();
	}//Para reccorrer el arbol evaluando desde izq a derecho
	void RecorrerNodoD(){
		if(hijo_der != null)
			hijo_der.RecorrerNodoD();//Para recorrer todo los nodos izq
		System.out.println(dato);
		if(hijo_izq!=null)
			hijo_izq.RecorrerNodoD();
	}//Para reccorrer el arbol evaluando desde derecho a izq
	
	String aCadena(){//para mostrar a los datos de la estructura.
		if(hijo_izq!=null)
			if(hijo_der!= null)
				return "\nDato: "+dato+
				"\nNodo izquierdo: "+hijo_izq.dato+
				"\nNodo derecho: "+hijo_der.dato;
			else 
				return "\nDato: "+dato+
				"\nNodo izquierdo: "+hijo_izq.dato+
				"\nNodo derecho: "+hijo_der;
		if(hijo_der != null)
			return "\nDato: "+dato+
				"\nNodo izquierdo: "+hijo_izq+
				"\nNodo derecho: "+hijo_der.dato;
				
		return "\nDato: "+dato+
				"\nNodo izquierdo: "+hijo_izq+
				"\nNodo derecho: "+hijo_der;
		
	}//De esta forma accedemos a los datos de nuestra estructura
	
	void VerArbol(){
		//Este metodo de recorrido se llama pre orden
		System.out.println(this.aCadena());//Esto devuelve el objeto que la llamo, se comenta en el Libro de Luis Joyanes Java 6 
		if(hijo_izq!=null)
			hijo_izq.VerArbol();
		if(hijo_der!=null)
			hijo_der.VerArbol();
	}//Mostrar una vista desordenada del arbol
	void VerArbolPost(){
		if(hijo_izq!=null)
			hijo_izq.VerArbolPost();
		if(hijo_der!=null)
			hijo_der.VerArbolPost();
		//Este metodo de recorrido se llama pre orden
		System.out.println(this.aCadena());//Esto devuelve el objeto que la llamo, se comenta en el Libro de Luis Joyanes Java 6 
	}
	
	String BuscarNodo(int dato){
		if(this.dato == dato)
			return this.aCadena();
		else if(dato<this.dato&&hijo_izq!=null)
			return hijo_izq.BuscarNodo(dato);
		else if(dato>this.dato && hijo_der !=null)
			return hijo_der.BuscarNodo(dato);
		return null;
	}
}
class Arbol{
	Nodo raiz;
	
	Arbol(){
		raiz = null;
	}
	
	void InsertarNodo(int dato){
		Nodo nodo = new Nodo(dato);
		if(raiz == null)
			raiz = nodo;
		else
			raiz.NuevoNodo(nodo);
	}
	
	void TraerDatoA(){
		raiz.RecorrerNodoA();
	}//Forma ascendente
	void TraerDatoD(){
		raiz.RecorrerNodoD();
	}//Forma descendente
	
	void MostrarArbol(){
		raiz.VerArbol();
	}
	void MostrarArbolPostOrden(){
		raiz.VerArbolPost();
	}
	String BuscarNodo(int dato){
		return raiz.BuscarNodo(dato);
	}
}
public class ArboleBinarios{
	public static void main(String []args){
		Arbol raiz = new Arbol();
		Random r = new Random();
		
		// for(int veces = 0; veces<10; veces++)
		// 	raiz.InsertarNodo(r.nextInt(100));
		
		raiz.InsertarNodo(60);
		raiz.InsertarNodo(37);
		raiz.InsertarNodo(75);
		raiz.InsertarNodo(25);
		raiz.InsertarNodo(15);
		raiz.InsertarNodo(30);
		raiz.InsertarNodo(32);
		raiz.InsertarNodo(28);
		raiz.InsertarNodo(36);
		raiz.InsertarNodo(62);
		raiz.InsertarNodo(69);
		
		
		raiz.TraerDatoA();
		System.out.println();
		raiz.TraerDatoD();
		System.out.println();
		raiz.MostrarArbol();
		System.out.println();
		String encontrado = raiz.BuscarNodo(0);
		
		if(encontrado!=null)
			System.out.println(encontrado);
		else
			System.out.println("No se encontro este valor");
	}
}