package org.mgilgar.grcalculatortest.model;

/**
 * Operation abstract class. It defines all method should be implemented in all {@link Operation}. It also contains some
 * implementations shared by all {@link Operation}s.
 *
 * @author mgilgar
 *
 */
public abstract class Operation {

   /**
    * Given a list of operands, it returns the result of apply the operation to them.
    *
    * @param op
    *           the operands we want to apply the operation for.
    * @return the result of the application of that operations to the operands.
    */
   public abstract long calculate(final long... op);

   /**
    * Returns if the operation where we call this method can be created from the given input.
    *
    * @param input
    *           the input
    * @return true if an object of this class can be created from the given input. For instance if we call the method AddOperation
    *         with an input of "add 5" it will return true, if the input is "multiply 7" it will return false.
    */
   public boolean canAnInstanceBeBuiltFrom(final String input) {
      return input.startsWith(getPrefix());
   }

   /**
    * It returns the input prefix that all inputs compatible with this operation should start with.
    *
    * @return
    */
   protected abstract String getPrefix();

}
