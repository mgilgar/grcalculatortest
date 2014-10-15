package org.mgilgar.grcalculatortest;

import java.util.List;

import org.mgilgar.grcalculatortest.model.ApplyOperation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;

/**
 * Calculator.
 *
 * @author mgilgar
 *
 */
public class Calculator {

   /**
    * Given an {@link OperationValuePair} containing the {@link ApplyOperation} and the {@link List} of {@link OperationValuePair}
    * it calculates the result of apply those operations in the given order (FIFO) to the value contained in the apply operation.
    *
    * @param applyOperationValuePair
    *           the pair containing the {@link ApplyOperation} and the initial value.
    * @param operationValuePairs
    *           the operations to apply to the initial value.
    * @return the result of apply the given operations in operationValuePairs to the initial value given in
    *         applyOperationValuePair.
    */
   public long calculate(final OperationValuePair applyOperationValuePair, final List<OperationValuePair> operationValuePairs) {
      if (applyOperationValuePair == null) {
         return 0;
      }
      if (operationValuePairs == null || operationValuePairs.size() == 0) {
         return applyOperationValuePair.getValue();
      }
      long accumulativeValue = applyOperationValuePair.getValue();
      for (OperationValuePair operationValuePair : operationValuePairs) {
         accumulativeValue = operationValuePair.getOperation().calculate(accumulativeValue, operationValuePair.getValue());
      }
      return accumulativeValue;
   }
}
