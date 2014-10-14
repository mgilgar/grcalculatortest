package org.mgilgar.grcalculatortest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mgilgar.grcalculatortest.factory.OperationFactory;
import org.mgilgar.grcalculatortest.factory.OperationValuePairFactory;
import org.mgilgar.grcalculatortest.model.MultiplyOperation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test class for OperationValuePairFactory.
 *
 * @author mgilgar
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OperationValuePairFactoryTest {

   private static final String       INPUT = "multiply 2";
   private static final int          VALUE = 2;

   private OperationValuePairFactory operationValuePairFactory;

   @Mock
   private OperationFactory          operationFactory;

   @Before
   public void setUp() {
      operationValuePairFactory = new OperationValuePairFactory(operationFactory);
   }

   @Test
   public void getShouldPopulateTheValue() {
      when(operationFactory.get(INPUT)).thenReturn(new MultiplyOperation());
      OperationValuePair pair = operationValuePairFactory.get(INPUT);
      assertEquals(VALUE, pair.getValue());
   }
}
