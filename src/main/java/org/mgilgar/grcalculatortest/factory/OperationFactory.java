package org.mgilgar.grcalculatortest.factory;

import java.util.List;

import org.mgilgar.grcalculatortest.model.Operation;

public class OperationFactory {

   private final List<Operation> operations;

   public OperationFactory(final List<Operation> operations) {
      this.operations = operations;
   }

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
