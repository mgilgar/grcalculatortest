package org.mgilgar.grcalculatortest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.mgilgar.grcalculatortest.factory.OperationFactory;
import org.mgilgar.grcalculatortest.factory.OperationValuePairFactory;
import org.mgilgar.grcalculatortest.model.AddOperation;
import org.mgilgar.grcalculatortest.model.ApplyOperation;
import org.mgilgar.grcalculatortest.model.DivideOperation;
import org.mgilgar.grcalculatortest.model.MultiplyOperation;
import org.mgilgar.grcalculatortest.model.Operation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;
import org.mgilgar.grcalculatortest.model.SubstractOperation;

/**
 * Command line wrapper and main app.
 *
 */
public class App {

   private BufferedReader in;
   private BufferedWriter out;

   public void setIn(final BufferedReader in) {
      this.in = in;
   }

   public void setOut(final BufferedWriter out) {
      this.out = out;
   }

   /**
    * Main method mapped to the command line.
    *
    * @param args
    *           it can be either empty or one argument may be passed (indicating the file to use as the input) or two arguments
    *           (1st one meaning input file and 2nd one meaning output file).
    * @throws IOException
    */
   public static void main(final String[] args) throws IOException {
      BufferedReader in = configuresIn(args);
      BufferedWriter out = configuresOut(args);

      App app = new App();
      app.setIn(in);
      app.setOut(out);
      app.start();
   }

   /**
    * It executes the app.
    *
    * @throws IOException
    */
   public void start() throws IOException {
      OperationValuePairFactory operationValueFairFactory = buildOperationValuePairFactory();
      OperationsValuePairReader reader = new OperationsValuePairReader(in, operationValueFairFactory);
      Calculator calculator = new Calculator();

      List<OperationValuePair> pairs = reader.read();
      long result = calculator.calculate(pairs.remove(pairs.size() - 1), pairs);
      out.write(String.valueOf(result) + "\n");
      out.flush();
   }

   /**
    * Builds an {@link OperationValuePairFactory} with all supported operations.
    *
    * @return a {@link OperationValuePairFactory} with all supported operations configured.
    */
   protected OperationValuePairFactory buildOperationValuePairFactory() {
      List<Operation> operations = new ArrayList<Operation>();
      operations.add(new AddOperation());
      operations.add(new ApplyOperation());
      operations.add(new DivideOperation());
      operations.add(new MultiplyOperation());
      operations.add(new SubstractOperation());
      OperationFactory operationFactory = new OperationFactory(operations);
      OperationValuePairFactory operationValueFairFactory = new OperationValuePairFactory(operationFactory);
      return operationValueFairFactory;
   }

   /**
    * Configures the {@link BufferedReader} to be used to read the input data.
    *
    * @param filename
    *           the filename to use as an input or null.
    * @return a {@link BufferedReader} pointing to the standard input if no arguments are passed, or pointing to a file identified
    *         by args[0].
    * @throws FileNotFoundException
    */
   protected static BufferedReader configuresIn(final String[] args) throws FileNotFoundException {
      BufferedReader in;
      if (args == null || args.length == 0) {
         in = new BufferedReader(new InputStreamReader(System.in));
      } else {
         in = new BufferedReader(new FileReader(args[0]));
      }
      return in;
   }

   /**
    * Configures the {@link BufferedWriter} to be used to write the output data.
    *
    * @param filename
    *           the filename to use as an output or null to use default output.
    * @return a BufferedWriter pointing to the standard output if no arguments are passed, or pointing to a file identified by
    *         args[1].
    * @throws IOException
    */
   protected static BufferedWriter configuresOut(final String[] args) throws IOException {
      BufferedWriter out;
      if (args == null || args.length <= 1) {
         out = new BufferedWriter(new OutputStreamWriter(System.out));
      } else {
         out = new BufferedWriter(new FileWriter(args[1]));
      }
      return out;
   }

}
