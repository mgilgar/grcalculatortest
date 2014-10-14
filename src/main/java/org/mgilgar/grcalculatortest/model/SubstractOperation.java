package org.mgilgar.grcalculatortest.model;

public class SubstractOperation extends Operation {

   private static final String PREFIX = "substract";

   @Override
   public long calculate(final long op1, final long op2) {
      return op1 - op2;
   }

   @Override
   protected String getPrefix() {
      return PREFIX;
   }

}
