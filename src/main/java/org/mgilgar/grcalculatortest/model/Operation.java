package org.mgilgar.grcalculatortest.model;

public abstract class Operation {

   public abstract long calculate(long op1, long op2);

   public boolean canAnInstanceBeBuiltFrom(final String input) {
      return input.startsWith(getPrefix());
   }

   protected abstract String getPrefix();

}
