package org.mgilgar.grcalculatortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mgilgar.grcalculatortest.factory.OperationValuePairFactory;
import org.mgilgar.grcalculatortest.model.ApplyOperation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;

/**
 * OperationsValuePairReader
 *
 * @author mgilgar
 *
 */
public class OperationsValuePairReader {

   private final BufferedReader            in;
   private final OperationValuePairFactory factory;

   /**
    * It creates an {@link OperationsValuePairReader}.
    *
    * @param in
    *           the input where the {@link OperationsValuePairReader} should read the operations from.
    * @param factory
    *           the {@link OperationValuePairFactory} to use to create the {@link OperationValuePair}s from the input.
    */
   public OperationsValuePairReader(final BufferedReader in, final OperationValuePairFactory factory) {
      super();
      this.in = in;
      this.factory = factory;
   }

   /**
    * It reads input and creates the corresponding {@link List} of {@link OperationValuePair}s.
    *
    * @return a {@link List} of {@link OperationValuePair}s matching the input.
    * @throws IOException
    */
   public List<OperationValuePair> read() throws IOException {
      List<OperationValuePair> pairs = new ArrayList<OperationValuePair>();
      String s;
      boolean end = false;
      while ((s = in.readLine()) != null && s.length() != 0 && !s.equals("\n") && !end) {
         OperationValuePair pair = factory.get(s);
         if (pair != null) {
            pairs.add(pair);
            if (pair.getOperation() instanceof ApplyOperation) {
               end = true;
            }
         }
      }
      return pairs;
   }
}
