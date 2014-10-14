package org.mgilgar.grcalculatortest.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mgilgar.grcalculatortest.model.AddOperation;
import org.mgilgar.grcalculatortest.model.ApplyOperation;
import org.mgilgar.grcalculatortest.model.DivideOperation;
import org.mgilgar.grcalculatortest.model.MultiplyOperation;
import org.mgilgar.grcalculatortest.model.SubstractOperation;

/**
 * Test class for classes AddOperation, DivideOperation, ApplyOperation, MultiplyOperation, SubstractOperation and Operation
 * abstract class.
 *
 * @author mgilgar
 *
 */
public class OperationsTest {

   private final static String ADD_INPUT       = "add";
   private final static String APPLY_INPUT     = "apply";
   private final static String DIVIDE_INPUT    = "divide";
   private final static String MULTIPLY_INPUT  = "multiply";
   private final static String SUBSTRACT_INPUT = "substract";

   private AddOperation        add;
   private ApplyOperation      apply;
   private DivideOperation     divide;
   private MultiplyOperation   multiply;
   private SubstractOperation  substract;

   @Before
   public void setUp() {
      add = new AddOperation();
      apply = new ApplyOperation();
      divide = new DivideOperation();
      multiply = new MultiplyOperation();
      substract = new SubstractOperation();
   }

   @Test
   public void canAnInstanceBeBuiltFromOnAddOperationShouldReturnTrueWhenAddInput() {
      assertTrue(add.canAnInstanceBeBuiltFrom(ADD_INPUT));
   }

   @Test
   public void canAnInstanceBeBuiltFromOnApplyOperationShouldReturnTrueWhenAddInput() {
      assertTrue(apply.canAnInstanceBeBuiltFrom(APPLY_INPUT));
   }

   @Test
   public void canAnInstanceBeBuiltFromOnDivideOperationShouldReturnTrueWhenAddInput() {
      assertTrue(divide.canAnInstanceBeBuiltFrom(DIVIDE_INPUT));
   }

   @Test
   public void canAnInstanceBeBuiltFromOnMultiplyOperationShouldReturnTrueWhenAddInput() {
      assertTrue(multiply.canAnInstanceBeBuiltFrom(MULTIPLY_INPUT));
   }

   @Test
   public void canAnInstanceBeBuiltFromOnSubstractOperationShouldReturnTrueWhenAddInput() {
      assertTrue(substract.canAnInstanceBeBuiltFrom(SUBSTRACT_INPUT));
   }

   @Test
   public void calculateOnAddOperationShouldAdd() {
      assertEquals(2, add.calculate(1, 1));
   }

   @Test
   public void calculateOnApplyOperationShouldReturnValue() {
      assertEquals(1, apply.calculate(1, 1));
   }

   @Test
   public void calculateOnDivideOperationShouldDivide() {
      assertEquals(2, divide.calculate(6, 3));
   }

   @Test
   public void calculateOnMultiplyOperationShouldMultiply() {
      assertEquals(6, multiply.calculate(2, 3));
   }

   @Test
   public void calculateOnSubstractOperationShouldSubstract() {
      assertEquals(3, substract.calculate(4, 1));
   }
}
