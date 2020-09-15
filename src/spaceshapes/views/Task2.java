package spaceshapes.views;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelListener;

public class Task2 extends Task1 implements ShapeModelListener {
	public Task2(ShapeModel shapeModel) {
		super(shapeModel);
	}

	/**
	 * Notifies a ShapeModelListener that a ShapeModel that it has registered 
	 * interest in has changed. 
	 * @param event describes the way in which a particular ShapeModel object
	 * has changed.
	 */
	public void update(ShapeModelEvent event) {
		int[] childIndices = new int[1];
		Object[] children = new Object[1];

		switch (event.eventType()) {
		case ShapeAdded:
			childIndices[0] = event.index();
			children[0] = event.operand();

			for (TreeModelListener listener : _listeners) {
				listener.treeNodesInserted( new TreeModelEvent( event.source(),
						new TreePath(event.parent().path().toArray()), childIndices, children) );
			}
			break;

		case ShapeRemoved:
			childIndices[0] = event.index();
			children[0] = event.operand();

			for (TreeModelListener listener : _listeners) {
				listener.treeNodesRemoved( new TreeModelEvent( event.source(), 
						new TreePath(event.parent().path().toArray()), childIndices, children) );
			}
			break;
		}
	}
}
