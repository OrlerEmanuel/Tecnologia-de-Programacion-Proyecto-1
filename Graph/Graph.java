package Graph;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Modela un grafo con las operacion pedidas por la catedra.
 * @author Emanuel Orler.
 */

public class Graph {
	
	protected HashMap<Integer, LinkedList<Edge<Integer,Integer>>> graph;
	protected static Logger logger;
	
	/**
	 * Crea e inicializa un nuevo grafo vacio.
	 */
	public Graph() {
		graph = new HashMap<Integer,LinkedList<Edge<Integer,Integer>>>();
		if(logger == null) {
			Handler handler =  new ConsoleHandler();
			handler.setLevel(Level.SEVERE);
			logger = Logger.getLogger(Graph.class.getName());
			logger.setUseParentHandlers(false);
			logger.setLevel(Level.FINE);
			logger.addHandler(handler);
		}
	}
	
	/**
	 * Agrega un nuevo nodo sin ningun arco.
	 * @param node: Valor que va a ser asignado al nodo.
	 */
	public void addNode(int node) {
		if(!graph.containsKey(node)) {
			graph.put(node, new LinkedList<Edge<Integer,Integer>>());
			logger.info("Se ha agregado un nodo al grafo con rotulo "+node+".");
		}
		else
			//Es considerado warning porque puede ser que la estructura este siendo mal manipulada.
			logger.warning("El nodo "+node+" ya se encuentra dentro del grafo.");
	}
	
	/**
	 * Agrega un nuevo arco entre dos nodos.
	 * @param node1: Valor que va a ser asignado al primer nodo.
	 * @param node2: Valor que va a ser asignado al segundo nodo.
	 */
	public void addEdge(int node1, int node2) {
		Iterator<Edge<Integer,Integer>> iterator;
		Edge<Integer,Integer> edge = null;
		boolean contained = false;
		if(graph.containsKey(node1) && graph.containsKey(node2)) {
			logger.info("Los nodos "+node1+" y "+node2+" pertenecen al grafo y se intentara crear un arco entre ellos.");
			iterator = graph.get(node1).iterator();
			while(!contained && iterator.hasNext())
				contained = iterator.next().getV().equals(node2);
			if(!contained) {
				edge = new Edge<Integer,Integer>(node1,node2);
				graph.get(node1).add(edge);
				graph.get(node2).add(edge);
				logger.info("Se ha creado con exito un arco entre "+node1+" y "+node2+".");
			}
			else
				//Es considerado fine porque si el arco que queriamos crear ya fue creado anteriormente no es una informacion de alta importancia.
				logger.fine("El arco que se esta intentando crear existe actualemente.");
		}
		else
			//Es considerado warning porque puede ser que la estructura este siendo mal manipulada.
			logger.warning("Alguno de los nodos ingresados por parametro no pertenecen al grafo.");
	}
	
	/**
	 * Remueve un nodo perteneciente al grafo.
	 * @param node: Valor del nodo que se quiere eliminar del grafo.
	 */
	public void removeNode(int node) {
		if(graph.containsKey(node)) {
			//Este bloque remueve los arcos de la lista de arcos del nodo y de los nodos con los que esta vinculado.
			for(Edge<Integer,Integer> e: graph.get(node)) {
				if(e.getV().equals(node))
					graph.get(e.getK()).remove(e);
				else
					graph.get(e.getV()).remove(e);
			}
			graph.remove(node);
			logger.info("Se ha eliminado el nodo "+node+" del grafo.");
		}
		else
			//Es considerado warning porque puede ser que la estructura este siendo mal manipulada.
			logger.warning("El nodo "+node+" que se estan intentando eliminar no pertenece al grafo.");
	}
	
	/**
	 * Remueve un arco entre dos nodos.
	 * @param node1: Valor del nodo origen del arco.
	 * @param node2: Valor del nodo destindo del arco.
	 */
	public void removeEdge(int node1, int node2) {
		Iterator<Edge<Integer,Integer>> iterator;
		Edge<Integer,Integer> edge = null;
		boolean contained = false;
		if(graph.containsKey(node1) && graph.containsKey(node2)) {
			logger.info("Los nodos "+node1+" y "+node2+" pertenecen al grafo y se intentara eliminar un arco entre ellos.");
			iterator = graph.get(node1).iterator();
			while(!contained && iterator.hasNext()) {
				edge = iterator.next();
				contained = edge.getV().equals(node2);
			}
			if(contained) {
				graph.get(node1).remove(edge);
				graph.get(node2).remove(edge);
				logger.info("Se ha eliminado con exito el arco entre "+node1+" y "+node2+".");
			}
			else
				//Es considerado fine porque si el arco que queriamos eliminar ya fue eliminado anteriormente no es una informacion de alta importancia.
				logger.fine("El arco que se esta intentando eliminar no existe actualemente.");
		}
		else
			//Es considerado severe porque implica que hay un gran error en la manipulacion de la estructura.
			logger.severe("El arco que se quiere eliminar no es posible que exista.");
	}
}