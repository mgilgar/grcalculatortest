package org.mgilgar.grcalculatortest.model;

/**
 * Operation + value class holder.
 *
 * @author mgilgar
 *
 */
public class OperationValuePair {

   private final Operation operation;
   private final int       value;

   public OperationValuePair(final Operation operation, final int value) {
      this.operation = operation;
      this.value = value;
   }

   public Operation getOperation() {
      return operation;
   }

   public int getValue() {
      return value;
   }

}
