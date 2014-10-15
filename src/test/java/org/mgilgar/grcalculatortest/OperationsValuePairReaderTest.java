package org.mgilgar.grcalculatortest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mgilgar.grcalculatortest.factory.OperationValuePairFactory;
import org.mgilgar.grcalculatortest.model.AddOperation;
import org.mgilgar.grcalculatortest.model.ApplyOperation;
import org.mgilgar.grcalculatortest.model.MultiplyOperation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test class for {@link OperationsValuePairReader}.
 * 
 * @author mgilgar
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OperationsValuePairReaderTest {

   private static final String       INPUT_ADD      = "add 5";
   private static final String       INPUT_APPLY    = "apply 4";
   private static final String       INPUT_MULTIPLY = "multiply 3";
   private static final String       INPUT_WRONG    = "xxx 3";

   private OperationsValuePairReader operationsReader;

   @Mock
   private BufferedReader            in;

   @Mock
   private OperationValuePairFactory factory;

   @Before
   public void setUp() {
      operationsReader = new OperationsValuePairReader(in, factory);
      when(factory.get(INPUT_ADD)).thenReturn(new OperationValuePair(new AddOperation(), 5));
      when(factory.get(INPUT_APPLY)).thenReturn(new OperationValuePair(new ApplyOperation(), 4));
      when(factory.get(INPUT_MULTIPLY)).thenReturn(new OperationValuePair(new MultiplyOperation(), 3));
      when(factory.get(INPUT_WRONG)).thenReturn(null);
   }

   @Test
   public void readShouldTerminateIfEmptyIsGiven() throws IOException {
      when(in.readLine()).thenReturn("\n");
      List<OperationValuePair> operationValuePairs = operationsReader.read();
      assertEquals(0, operationValuePairs.size());
   }

   @Test
   public void readShouldNotAddOperationValuePairIfOperationDoesNotExist() throws IOException {
      when(in.readLine()).thenReturn(INPUT_WRONG).thenReturn("\n");
      List<OperationValuePair> operationValuePairs = operationsReader.read();
      assertEquals(0, operationValuePairs.size());
   }

   @Test
   public void readShouldAddOperationValuePairWhenOperationExist() throws IOException {
      when(in.readLine()).thenReturn(INPUT_ADD).thenReturn("\n");
      List<OperationValuePair> operationValuePairs = operationsReader.read();
      assertEquals(1, operationValuePairs.size());
   }

   @Test
   public void readShouldAdd2OperationsValuePairsWhen2Operations() throws IOException {
      when(in.readLine()).thenReturn(INPUT_ADD).thenReturn(INPUT_APPLY).thenReturn("\n");
      List<OperationValuePair> operationValuePairs = operationsReader.read();
      assertEquals(2, operationValuePairs.size());
   }

   @Test
   public void readShouldAdd2OperationsValuePairsWhen2ndOperationIsApply() throws IOException {
      when(in.readLine()).thenReturn(INPUT_ADD).thenReturn(INPUT_APPLY).thenReturn(INPUT_MULTIPLY).thenReturn("\n");
      List<OperationValuePair> operationValuePairs = operationsReader.read();
      assertEquals(2, operationValuePairs.size());
   }
}
