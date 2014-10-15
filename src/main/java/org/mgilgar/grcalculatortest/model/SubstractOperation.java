package org.mgilgar.grcalculatortest.model;

/**
 * SubstractOperation class.
 *
 * @author mgilgar
 *
 */
public class SubstractOperation extends Operation {

   private static final String PREFIX = "substract";

   @Override
   public long calculate(final long... op) {
      return op[0] - op[1];
   }

   @Override
   protected String getPrefix() {
      return PREFIX;
   }

}
