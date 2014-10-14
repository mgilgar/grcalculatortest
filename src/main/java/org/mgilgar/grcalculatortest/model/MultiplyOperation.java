package org.mgilgar.grcalculatortest.model;


public class MultiplyOperation extends Operation {

   private static final String PREFIX = "multiply";

   @Override
   public long calculate(final long op1, final long op2) {
      return op1 * op2;
   }

   @Override
   protected String getPrefix() {
      return PREFIX;
   }

}
