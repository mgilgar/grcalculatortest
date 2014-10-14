package org.mgilgar.grcalculatortest.factory;

import org.mgilgar.grcalculatortest.model.Operation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;

public class OperationValuePairFactory {

   private static final String SEPARATOR = "\\s+";

   private OperationFactory    operationFactory;

   public OperationValuePairFactory(final OperationFactory operationFactory) {
      super();
      this.operationFactory = operationFactory;
   }

   /*
    * public OperationFactory getOperationFactory() { return operationFactory; }
    */

   public void setOperationFactory(final OperationFactory operationFactory) {
      this.operationFactory = operationFactory;
   }

   public OperationValuePair get(final String input) {
      final Operation operation = operationFactory.get(input);
      int value = Integer.valueOf(input.split(SEPARATOR)[1]);
      return new OperationValuePair(operation, value);
   }
}
