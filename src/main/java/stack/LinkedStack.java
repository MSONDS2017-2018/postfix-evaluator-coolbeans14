package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List
 * structure to allow for unbounded size.
 *
 * @param <T>
 *          the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

  private int count;
  private LinearNode<T> top;

  public LinkedStack() {
    count = 0;
    top = null;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public T pop() throws StackUnderflowException {
    T elem = top.getElement();
    top = top.getNext();
    count--;
    return elem;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public T top() throws StackUnderflowException {
    return top.getElement();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean isEmpty() {
    if (top == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int size() {
    return count;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void push(T elem) {
    LinearNode<T> node = new LinearNode<T>(elem);
    node.setNext(top);
    top = node;
  }

}
