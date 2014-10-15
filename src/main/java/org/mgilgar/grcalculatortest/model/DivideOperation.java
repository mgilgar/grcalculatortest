package org.mgilgar.grcalculatortest.model;

/**
 * DivideOperation class.
 *
 * @author mgilgar
 *
 */
public class DivideOperation extends Operation {

   private static final String PREFIX = "divide";

   @Override
   public long calculate(final long... op) {
      return op[0] / op[1];
   }

   @Override
   protected String getPrefix() {
      return PREFIX;
   }

}
