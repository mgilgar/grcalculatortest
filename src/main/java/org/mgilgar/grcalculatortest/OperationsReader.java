package org.mgilgar.grcalculatortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mgilgar.grcalculatortest.factory.OperationValuePairFactory;
import org.mgilgar.grcalculatortest.model.ApplyOperation;
import org.mgilgar.grcalculatortest.model.OperationValuePair;

public class OperationsReader {

   private final BufferedReader            in;
   private final OperationValuePairFactory factory;

   public OperationsReader(final BufferedReader in, final OperationValuePairFactory factory) {
      super();
      this.in = in;
      this.factory = factory;
   }

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
