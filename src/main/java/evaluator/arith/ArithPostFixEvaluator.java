package evaluator.arith;

import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;
import language.Operand;
import language.Operator;
import parser.arith.ArithPostFixParser;
import stack.StackInterface;
import stack.LinkedStack;
import stack.StackUnderflowException;

/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple
 * arithmetic expressions.
 *
 */
public class ArithPostFixEvaluator implements PostFixEvaluator<Integer> {

  private final StackInterface<Operand<Integer>> stack;

  /**
   * Constructs an {@link ArithPostFixEvaluator}.
   */
  public ArithPostFixEvaluator() {
    this.stack = new LinkedStack<Operand<Integer>>();
  }

  /**
   * Evaluates a postfix expression.
   *
   * @return the result
   */
  @Override
  public final Integer evaluate(final String expr) {
    ArithPostFixParser parser = new ArithPostFixParser(expr);
    while (parser.hasNext()) {
      switch (parser.nextType()) {
      case OPERAND:
        stack.push(parser.nextOperand());
        break;
      case OPERATOR:
        try {
          Operand<Integer> operand1 = stack.pop();
          Operator<Integer> operator = parser.nextOperator();
          if (operator.getNumberOfArguments() == 2) {
            Operand<Integer> operand0 = stack.pop();
            operator.setOperand(0, operand0);
            operator.setOperand(1, operand1);
          } else {
            operator.setOperand(0, operand1);
          }
          Operand<Integer> result = operator.performOperation();
          stack.push(result);
        } catch (StackUnderflowException ex) {
          throw new IllegalPostFixExpressionException();
        }
        break;
      default:
        // TODO If we get here, something went terribly wrong
      }
    }
    if (stack.size() == 1) {
      return stack.pop().getValue();
    } else {
      // Empty the stack
      while (!stack.isEmpty()) {
        stack.pop();
      }
      throw new IllegalPostFixExpressionException();
    }
  }

}
