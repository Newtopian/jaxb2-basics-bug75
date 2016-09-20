import info.newtopian.schemas.jaxb2_basics.simplegraph.Edge;
import info.newtopian.schemas.jaxb2_basics.simplegraph.Graph;
import info.newtopian.schemas.jaxb2_basics.simplegraph.Node;
import info.newtopian.schemas.jaxb2_basics.simplegraph.ObjectFactory;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class HashCode {

	private Edge	edge;
	private Node	startNode;
	private Node	endNode;
	private Graph	graph;

	/**
	 *
	 */
	@Before
	public void prepareObjects()
	{
		ObjectFactory fact = new ObjectFactory();
		edge = fact.createEdge();
		edge.setEdgeName("SomeEdge");

		startNode = fact.createNode();
		startNode.setId("noderef-1");
		startNode.setMessageID("MESSAGE-1");
		startNode.getEdge().add(edge);
		edge.setLinksFromNode(startNode);

		endNode = fact.createNode();
		endNode.setId("noderef-2");
		endNode.setMessageID("MESSAGE-2");
		endNode.getEdge().add(edge);
		edge.setLinksToNode(endNode);

		graph = fact.createGraph();
		graph.setStartNode(startNode);
		graph.setNodeList(fact.createGraphNodeList());
		graph.getNodeList().getNode().add(startNode);
		graph.getNodeList().getNode().add(endNode);

	}

	/**
	 *
	 */
	@Test
	public void testHashCode() {

		int hash = edge.hashCode();
	}

	/**
	 *
	 */
	@Test
	public void testToString() {

		String dump = edge.toString();
	}

	/**
	 *
	 */
	@Test
	public void testEquals() {

		startNode.equals(endNode);
		edge.equals(edge);
		graph.equals(graph);
	}

}
