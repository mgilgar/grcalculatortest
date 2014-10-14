package org.mgilgar.grcalculatortest;

import java.util.ArrayList;
import java.util.List;

import org.mgilgar.grcalculatortest.factory.OperationFactory;
import org.mgilgar.grcalculatortest.factory.OperationValuePairFactory;
import org.mgilgar.grcalculatortest.model.AddOperation;
import org.mgilgar.grcalculatortest.model.ApplyOperation;
import org.mgilgar.grcalculatortest.model.MultiplyOperation;
import org.mgilgar.grcalculatortest.model.Operation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;

/**
 * Hello world!
 *
 */
public class App {

   public static void main(final String[] args) {
      List<Operation> operations = new ArrayList<Operation>();
      operations.add(new MultiplyOperation());
      operations.add(new AddOperation());
      operations.add(new ApplyOperation());
      OperationFactory operationFactory = new OperationFactory(operations);
      OperationValuePairFactory operationValueFairFactory = new OperationValuePairFactory(operationFactory);
      OperationValuePair operationValuePair = operationValueFairFactory.get("multiply 5");
      long initialValue = 10;
      long result = operationValuePair.getOperation().calculate(operationValuePair.getValue(), initialValue);
      System.out.println("Result: " + result);
   }
}
