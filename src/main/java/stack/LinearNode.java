package stack;

/**
 * A {@link LinkedNode} is a node that is implemented using a linked
 * list structure referencing an element.
 *
 * @param <T>
 *          the element referenced in the node
 */
public class LinearNode<T> {
  private LinearNode<T> next;
  private T element;

  /**
   * Create an empty LinearNode.
   */
  public LinearNode() {
    next = null;
    element = null;
  }

  /**
   * @param elem initializes element.
   */
  public LinearNode(final T elem) {
    next = null;
    element = elem;
  }

  /**
   * @return next node.
   */
  public final LinearNode<T> getNext() {
    return next;
  }

  /**
   * @param node sets node.
   */
  public final void setNext(final LinearNode<T> node) {
    next = node;
  }

  /**
   * @return this node's element.
   */
  public final T getElement() {
    return element;
  }

  /**
   * @param elem sets this node's element
   */
  public final void setElement(final T elem) {
    element = elem;
  }
}
