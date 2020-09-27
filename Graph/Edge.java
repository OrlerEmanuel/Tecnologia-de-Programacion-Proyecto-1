package Graph;
/**
 * Modela un arco dirigido sin peso.
 * @author Emanuel Orler
 * @param <K>: Tipo de dato abstracto del nodo origen.
 * @param <V>: Tipo de dato abstracto del nodo destino.
 */
public class Edge<K, V> {
	protected K k;
	protected V v;
	
	/**
	 * Inicializa un nuevo arco.
	 * @param k: Dato de que tendra el nodo origen.
	 * @param v: Dato de que tendra el nodo destino.
	 */
	public Edge(K k, V v) {
		this.k = k;
		this.v = v;
	}
	/**
	 * Obtiene el valor asociado al nodo origen. 
	 * @return k, donde k es el valor del nodo origen.
	 */
	public K getK() {
		return k;
	}
	/**
	 * Modifica el valor actual del nodo origen.
	 * @param k: Valor a establecer dentro del nodo origen.
	 */
	public void setK(K k) {
		this.k = k;
	}
	/**
	 * Obtiene el valor asociado al nodo destino. 
	 * @return v, donde v es el valor del nodo destino.
	 */
	public V getV() {
		return v;
	}
	/**
	 * Modifica el valor actual del nodo destino.
	 * @param v: Valor a establecer dentro del nodo destino.
	 */
	public void setV(V v) {
		this.v = v;
	}

}