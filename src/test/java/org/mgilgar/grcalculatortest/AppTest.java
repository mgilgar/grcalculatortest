package org.mgilgar.grcalculatortest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mgilgar.grcalculatortest.factory.OperationValuePairFactory;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test class for App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest {

   private static final String INPUT_ADD       = "add 5";
   private static final String INPUT_APPLY     = "apply 3";
   private static final String EXPECTED_OUTPUT = "8\n";

   private App                 app;

   @Mock
   BufferedReader              in;

   @Mock
   BufferedWriter              out;

   @Before
   public void setUp() {
      app = new App();
      app.setIn(in);
      app.setOut(out);
   }

   @Test
   public void startShouldWriteResult() throws IOException {
      when(in.readLine()).thenReturn(INPUT_ADD).thenReturn(INPUT_APPLY).thenReturn("\n");
      app.start();
      verify(out, times(1)).write(EXPECTED_OUTPUT);
      verify(out, times(1)).flush();
   }

   @Test
   public void buildOperationValuePairFactoryShouldReturnAnOperationValuePairFactory() {
      OperationValuePairFactory factory = app.buildOperationValuePairFactory();
      assertNotNull(factory);
   }

   @Test
   public void configuresInShouldReturnBufferedReaderWhenNull() throws FileNotFoundException {
      BufferedReader in = app.configuresIn(null);
      assertNotNull(in);
   }

   @Test
   public void configuresInShouldReturnBufferedReaderWhenFilename() throws FileNotFoundException {
      BufferedReader in = app.configuresIn(new String[] { "example1.txt" });
      assertNotNull(in);
   }

   @Test
   public void configuresOutShouldReturnBufferedWriterWhenNull() throws IOException {
      BufferedWriter out = app.configuresOut(null);
      assertNotNull(out);
   }

   @Test
   public void configuresOutShouldReturnBufferedWriterWhenFilename() throws IOException {
      BufferedWriter out = app.configuresOut(new String[] { "output.txt" });
      assertNotNull(out);
   }
}
