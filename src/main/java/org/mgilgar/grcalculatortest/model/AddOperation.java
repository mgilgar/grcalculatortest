package org.mgilgar.grcalculatortest.model;


public class AddOperation extends Operation {

   private static final String PREFIX = "add";

   @Override
   public long calculate(final long op1, final long op2) {
      return op1 + op2;
   }

   @Override
   protected String getPrefix() {
      return PREFIX;
   }

}
