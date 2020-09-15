package spaceshapes.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import spaceshapes.ShapeModel;
import spaceshapes.Shape;
import spaceshapes.CarrierShape;

public class Task1 implements TreeModel {

	private ShapeModel _shapeModel;
	protected List<TreeModelListener> _listeners = new ArrayList<TreeModelListener>();

	public Task1(ShapeModel shapeModel) {
		_shapeModel = shapeModel;
	}

	/**
	 * Adds a listener for the TreeModelEvent posted after the tree changes.
	 */
	public void addTreeModelListener(TreeModelListener listener) {
		_listeners.add(listener);
	}

	/**
	 * Returns the child of parent at index index in the parent's child array.
	 */
	public Object getChild(Object parent, int index) {
		if (parent instanceof CarrierShape) {
			try {
				return ((CarrierShape)parent).shapeAt(index);
			} 
			catch (IndexOutOfBoundsException e) {
				return null;
			}
		}
		return null; // Parent is not of a type CarrierShape;
	}

	/**
	 * Returns the number of children of parent.
	 */
	public int getChildCount(Object parent) {
		if (parent instanceof CarrierShape) {
			return ((CarrierShape)parent).shapeCount();
		}
		return 0; // The parent is not of a type CarrierShape.
	}

	/**
	 * Returns the index of child in parent.
	 */
	public int getIndexOfChild(Object parent, Object child) {
		if ( (parent instanceof CarrierShape) && (child instanceof Shape) ) {
			return ( ((CarrierShape)parent).indexOf((Shape)child) );
		}
		return -1;
	}

	/**
	 * Returns the root of the tree.
	 */
	public Object getRoot() {
		if (_shapeModel.root() != null) {
			return _shapeModel.root();
		} else {
			return null;
		}
	}
	
	/**
	* Returns true if node is a leaf.
	*/
	public boolean isLeaf(Object node) {
		if (node instanceof CarrierShape) {
			return false;
		} else if (node instanceof Shape) {
			return true;
		}
		return false;
	}

	/**
	 * Removes a listener previously added with addTreeModelListener.
	 */
	public void removeTreeModelListener(TreeModelListener listener) {
		_listeners.remove(listener);
	}

	/**
	 * Messaged when the user has altered the value for the item identified by path to newValue.
	 */
	public void valueForPathChanged(TreePath path, Object newValue) {
	}
}
