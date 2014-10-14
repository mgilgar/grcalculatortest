package org.mgilgar.grcalculatortest.model;


public class ApplyOperation extends Operation {

   private static final String PREFIX = "apply";

   @Override
   public long calculate(final long op1, final long op2) {
      return op1;
   }

   @Override
   protected String getPrefix() {
      return PREFIX;
   }

}
