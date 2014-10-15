package org.mgilgar.grcalculatortest.factory;

import java.util.List;

import org.mgilgar.grcalculatortest.model.Operation;

/**
 * Operation factory.
 *
 * @author mgilgar
 *
 */
public class OperationFactory {

   private final List<Operation> operations;

   /**
    * It creates an {@link OperationFactory} with the given operations.
    *
    * @param operations
    *           the operations that we want this factory to be able to create.
    */
   public OperationFactory(final List<Operation> operations) {
      this.operations = operations;
   }

   /**
    * It returns a subclass of Operation based on the operationName. It can only return an instance of the classes that have been
    * passed in the constructor before.
    *
    * @param operationName
    *           the name of the operation that we want to return.
    * @return an {@link Operation} that matches the operationName.
    */
   public Operation get(final String operationName) {
      if (operations == null) {
         return null;
      }
      for (Operation operation : operations) {
         if (operation.canAnInstanceBeBuiltFrom(operationName)) {
            return operation;
         }
      }
      return null;
   }
}
