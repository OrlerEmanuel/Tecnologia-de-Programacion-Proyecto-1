package Graph;

public class Test {
	public static void main(String[] args) {

		//Construir el grafo
		Graph graph = new Graph();
		for(int i=1;i<6;i++)
			graph.addNode(i);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
			
		/**Estado acutal del grafo:
		 * 
		 * 			(1)-----→(2)-----→(3)-----→(4)-----→(5)
		 * 			 \                 ↑
		 *            \---------------/
		 */
			
		//AddNode correcto funcionamiento.
		graph.addNode(6);
		
		//AddNode intenta agregar un nodo ya ingresado.
		graph.addNode(6);
		
		//AddEdge correcto funcionamiento.
		graph.addEdge(1, 6);
		graph.addEdge(6, 3);
		
		//AddEdge con el arco ya creado.
		graph.addEdge(1, 6);
		
		//AddEdge con un arco con parametro mal ingresados.
		graph.addEdge(6, 7);
		
		//RemoveNode correcto funcionamiento:
		graph.removeNode(5);
		
		//RemoveNode intenta remover un nodo que no existe.
		graph.removeNode(7);
		
		//RemoveEdge correcto funcionamiento.
		graph.removeEdge(1,3);
		
		//RemoveEdge intentado remover un arco que no existe.
		graph.removeEdge(1,3);
		
		//RemoveEdge intentado remover un arco que no es posible que exista.
		graph.removeEdge(6, 7);
	}
}
