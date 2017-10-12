package language.arith;

import language.Operand;
import language.Operator;

/**
 * The {@code NegateOperator} is an operator that performs negation on a single integer
 * @author jcollard, jddevaug
 *
 */
public class NegateOperator implements Operator<Integer> {
  private Operand<Integer> op;

  /**
   * {@inheritDoc}
   */
  @Override
  public int getNumberOfArguments() {
    return 1;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Operand<Integer> performOperation() {
    if (op == null) {
      throw new IllegalStateException("Could not perform operation prior to operands being set.");
    }
    Operand<Integer> result = new Operand<Integer>(op.getValue() * -1);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setOperand(int i, Operand<Integer> operand) {
    if (operand == null) {
      throw new NullPointerException("Could not set null operand.");
    }
    if (i > 0) {
      throw new IllegalArgumentException("This operator only accepts operand 0 "
                                          + "but recieved " + i + ".");
    }
    if (i == 0) {
      if (op != null) {
        throw new IllegalStateException("Position " + i + " has been previously set.");
      }
      op = operand;
    }
  }
  
  /**
   * {@inheritDoc}
   */
  public Operand<Integer> getOp(){
    return op;
  }

}
