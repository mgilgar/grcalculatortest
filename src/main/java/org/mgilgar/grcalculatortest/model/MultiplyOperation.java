package org.mgilgar.grcalculatortest.model;

/**
 * MultiplyOperation class.
 *
 * @author mgilgar
 *
 */
public class MultiplyOperation extends Operation {

   private static final String PREFIX = "multiply";

   @Override
   public long calculate(final long... op) {
      return op[0] * op[1];
   }

   @Override
   protected String getPrefix() {
      return PREFIX;
   }

}
