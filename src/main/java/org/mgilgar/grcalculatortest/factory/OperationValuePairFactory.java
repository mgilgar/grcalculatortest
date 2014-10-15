package org.mgilgar.grcalculatortest.factory;

import org.mgilgar.grcalculatortest.model.Operation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;

/**
 * OperationValuePair factory.
 *
 * @author mgilgar
 *
 */
public class OperationValuePairFactory {

   private static final String SEPARATOR = "\\s+";

   private OperationFactory    operationFactory;

   public void setOperationFactory(final OperationFactory operationFactory) {
      this.operationFactory = operationFactory;
   }

   /**
    * It creates an {@link OperationValuePairFactory} that will the given operationFactory to create {@link Operation}s.
    *
    * @param operationFactory
    *           the {@link OperationFactory} that will be used to create the operation part of a {@link OperationValuePair}.
    */
   public OperationValuePairFactory(final OperationFactory operationFactory) {
      super();
      this.operationFactory = operationFactory;
   }

   /**
    * It creates a new {@link OperationValuePair} based on the given input.
    *
    * @param input
    *           a String representing a {@link OperationValuePair}, i.e. "add 2" or "multiply 7".
    * @return a new {@link OperationValuePair} that matches the given input.
    */
   public OperationValuePair get(final String input) {
      final Operation operation = operationFactory.get(input);
      int value = Integer.valueOf(input.split(SEPARATOR)[1]);
      return new OperationValuePair(operation, value);
   }
}
