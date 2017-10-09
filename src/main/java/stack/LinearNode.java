package stack;

public class LinearNode<T> {
  private LinearNode<T> next;
  private T element;

  public LinearNode() {
    next = null;
    element = null;
  }

  public LinearNode(final T elem) {
    next = null;
    element = elem;
  }

  public final LinearNode<T> getNext() {
    return next;
  }

  public final void setNext(final LinearNode<T> node) {
    next = node;
  }

  public final T getElement() {
    return element;
  }

  public final void setElement(final T elem) {
    element = elem;
  }
}
