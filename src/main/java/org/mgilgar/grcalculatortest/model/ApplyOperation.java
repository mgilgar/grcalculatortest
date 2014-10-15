package org.mgilgar.grcalculatortest.model;

/**
 * ApplyOperation class.
 *
 * @author mgilgar
 *
 */
public class ApplyOperation extends Operation {

   private static final String PREFIX = "apply";

   @Override
   public long calculate(final long... op) {
      return op[0];
   }

   @Override
   protected String getPrefix() {
      return PREFIX;
   }

}
