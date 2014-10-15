package org.mgilgar.grcalculatortest.model;

/**
 * AddOperation class.
 *
 * @author mgilgar
 *
 */
public class AddOperation extends Operation {

   private static final String PREFIX = "add";

   @Override
   public long calculate(final long... op) {
      return op[0] + op[1];
   }

   @Override
   protected String getPrefix() {
      return PREFIX;
   }

}
