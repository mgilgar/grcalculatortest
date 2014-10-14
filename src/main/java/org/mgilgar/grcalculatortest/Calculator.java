package org.mgilgar.grcalculatortest;

import java.util.List;

import org.mgilgar.grcalculatortest.model.OperationValuePair;

public class Calculator {

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
