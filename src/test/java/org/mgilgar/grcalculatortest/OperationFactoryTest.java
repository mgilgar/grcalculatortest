package org.mgilgar.grcalculatortest;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mgilgar.grcalculatortest.factory.OperationFactory;
import org.mgilgar.grcalculatortest.model.AddOperation;
import org.mgilgar.grcalculatortest.model.ApplyOperation;
import org.mgilgar.grcalculatortest.model.DivideOperation;
import org.mgilgar.grcalculatortest.model.MultiplyOperation;
import org.mgilgar.grcalculatortest.model.Operation;
import org.mgilgar.grcalculatortest.model.SubstractOperation;

public class OperationFactoryTest {

   private static final String INPUT_ADD       = "add 5";
   private static final String INPUT_APPLY     = "apply 5";
   private static final String INPUT_DIVIDE    = "divide 5";
   private static final String INPUT_MULTIPLY  = "multiply 5";
   private static final String INPUT_SUBSTRACT = "substract 5";
   private static final String INPUT_WRONG     = "wrong 5";

   private OperationFactory    factory;
   private List<Operation>     operations;

   @Before
   public void setUp() {
      operations = new ArrayList<Operation>();
      operations.add(new AddOperation());
      operations.add(new ApplyOperation());
      operations.add(new DivideOperation());
      operations.add(new MultiplyOperation());
      operations.add(new SubstractOperation());
      factory = new OperationFactory(operations);
   }

   @Test
   public void getWhenInputLineContainingAnAddShouldReturnNullIfOperationIsNotAvailable() {
      factory = new OperationFactory(null);
      Operation operation = factory.get(INPUT_ADD);
      assertNull(operation);
   }

   @Test
   public void getWhenInputLineContainingWrongInputShouldReturnNull() {
      Operation operation = factory.get(INPUT_WRONG);
      assertNull(operation);
   }

   @Test
   public void getWhenInputLineContainingAnAddShouldReturnAnAddOperation() {
      Operation operation = factory.get(INPUT_ADD);
      assertTrue(operation instanceof AddOperation);
   }

   @Test
   public void getWhenInputLineContainingAnApplyShouldReturnAnApplyOperation() {
      Operation operation = factory.get(INPUT_APPLY);
      assertTrue(operation instanceof ApplyOperation);
   }

   @Test
   public void getWhenInputLineContainingADivideShouldReturnAnDivideOperation() {
      Operation operation = factory.get(INPUT_DIVIDE);
      assertTrue(operation instanceof DivideOperation);
   }

   @Test
   public void getWhenInputLineContainingAMultiplyShouldReturnAMultiplyOperation() {
      Operation operation = factory.get(INPUT_MULTIPLY);
      assertTrue(operation instanceof MultiplyOperation);
   }

   @Test
   public void getWhenInputLineContainingASubstractShouldReturnAnSubstractOperation() {
      Operation operation = factory.get(INPUT_SUBSTRACT);
      assertTrue(operation instanceof SubstractOperation);
   }

}
