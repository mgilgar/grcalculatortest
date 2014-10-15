package org.mgilgar.grcalculatortest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mgilgar.grcalculatortest.model.AddOperation;
import org.mgilgar.grcalculatortest.model.ApplyOperation;
import org.mgilgar.grcalculatortest.model.DivideOperation;
import org.mgilgar.grcalculatortest.model.MultiplyOperation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;
import org.mgilgar.grcalculatortest.model.SubstractOperation;

/**
 * Test class for {@link Calculator}.
 * 
 * @author mgilgar
 *
 */
public class CalculatorTest {

   private static final int VALUE_2 = 2;
   private static final int VALUE_3 = 3;
   private static final int VALUE_5 = 5;
   private static final int VALUE_8 = 8;
   private static final int VALUE_9 = 9;

   private Calculator       calculator;

   @Before
   public void setUp() {
      calculator = new Calculator();
   }

   @Test
   public void calculateShouldReturn0WhenNull() {
      assertEquals(0, calculator.calculate(null, null));
   }

   @Test
   public void calculateShouldReturnValueWhenNoOperations() {
      assertEquals(VALUE_5,
            calculator.calculate(new OperationValuePair(new ApplyOperation(), VALUE_5), new ArrayList<OperationValuePair>()));
   }

   @Test
   public void calculateShouldReturnValueWhenOnlyMultiplyAndApplyOperations() {
      List<OperationValuePair> operationValuePairs = new ArrayList<OperationValuePair>();
      operationValuePairs.add(new OperationValuePair(new MultiplyOperation(), VALUE_5));
      assertEquals(VALUE_5 * VALUE_3,
            calculator.calculate(new OperationValuePair(new ApplyOperation(), VALUE_3), operationValuePairs));
   }

   @Test
   public void calculateShouldReturnValueWhenOnlyMultiplyAndAddAndApplyOperations() {
      List<OperationValuePair> operationValuePairs = new ArrayList<OperationValuePair>();
      operationValuePairs.add(new OperationValuePair(new MultiplyOperation(), VALUE_5));
      operationValuePairs.add(new OperationValuePair(new AddOperation(), VALUE_8));
      assertEquals(VALUE_3 * VALUE_5 + VALUE_8,
            calculator.calculate(new OperationValuePair(new ApplyOperation(), VALUE_3), operationValuePairs));
   }

   @Test
   public void calculateShouldReturnValueWhenOnlyMultiplyAndAddAndDivideAndApplyOperations() {
      List<OperationValuePair> operationValuePairs = new ArrayList<OperationValuePair>();
      operationValuePairs.add(new OperationValuePair(new MultiplyOperation(), VALUE_5));
      operationValuePairs.add(new OperationValuePair(new AddOperation(), VALUE_5));
      operationValuePairs.add(new OperationValuePair(new DivideOperation(), VALUE_2));
      assertEquals((VALUE_3 * VALUE_5 + VALUE_5) / VALUE_2,
            calculator.calculate(new OperationValuePair(new ApplyOperation(), VALUE_3), operationValuePairs));
   }

   @Test
   public void calculateShouldReturnValueWhenOnlyMultiplyAndAddAndDivideAndSubstractAndApplyOperations() {
      List<OperationValuePair> operationValuePairs = new ArrayList<OperationValuePair>();
      operationValuePairs.add(new OperationValuePair(new MultiplyOperation(), VALUE_5));
      operationValuePairs.add(new OperationValuePair(new AddOperation(), VALUE_5));
      operationValuePairs.add(new OperationValuePair(new DivideOperation(), VALUE_2));
      operationValuePairs.add(new OperationValuePair(new SubstractOperation(), VALUE_9));
      assertEquals((VALUE_3 * VALUE_5 + VALUE_5) / VALUE_2 - VALUE_9,
            calculator.calculate(new OperationValuePair(new ApplyOperation(), VALUE_3), operationValuePairs));
   }
}
