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
  public final T pop() throws StackUnderflowException {
    if (count == 0) {
      throw new StackUnderflowException();
    }
    T elem = top.getElement();
    top = top.getNext();
    count--;
    return elem;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final T top() throws StackUnderflowException {
    if (count == 0) {
      throw new StackUnderflowException();
    }
    return top.getElement();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final boolean isEmpty() {
    if (count == 0) {
      return true;
    }
    return false;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final int size() {
    return count;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void push(final T elem) {
    LinearNode<T> node = new LinearNode<T>(elem);
    node.setNext(top);
    top = node;
    count++;
  }

}
