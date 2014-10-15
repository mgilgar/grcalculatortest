PERSONAL DATA:
Test done by Miguel Gil.

DESIGN:
-App is the main application and command line wrapper to kick off the app.
-ApplyOperation, AddOperation, DivideOperation, MultiplyOperation, SubstractOperation all extend Operation abstract class
and represent the operations that are available in the app.
-OperationValuePair is a wrapper of an operation and one operand, representing the input of one line in the app.
-The way I convert input lines in data in the app is by using two factories, OperationsValuePairFactory and OperationsFactory.
They take an input line and create an OperationValuePair instance.
-The class that controls the calls to these factories is called OperationsValuePairReader, that is in charge of reading
the input and calling the appropriate factory to create the list of OperationsValuePair.
-Calculator is the class that given a List of OperationsValuePair calculates the result.
-All these classes are orchestated by App class to provide the desired output.

Everything has been unit tested, using mocks (mockito library) when necessary.


ASSUMPTIONS:
-The input finishes when an apply operation is found. The output is only printed when after that 
operation the user press enter twice.
-Once the apply operation is found, the initial value is calculated and the rest operations are applied in the 
same order as they were written in the input file (FIFO).
  
COMPILE
From parent project folder:
mvn clean verify  
    
TESTS:
There are 35 tests testing all classes.
Where necessary I have used mocks (with mockito library).
    
RUN
from project parent folder:
java -cp target/classes org.mgilgar.grcalculatortest.App
And you can type the input desired, i.e.:
add 2 multiply 3 apply 3



and then press enter twice to get the output:
15


You can also pass a file name with the input:

java -cp target/classes org.mgilgar.grcalculatortest.App example1.txt
java -cp target/classes org.mgilgar.grcalculatortest.App example2.txt
java -cp target/classes org.mgilgar.grcalculatortest.App example3.txt
java -cp target/classes org.mgilgar.grcalculatortest.App example4.txt



If you want the output to be printed to a file you can use this:
java -cp target/classes org.mgilgar.grcalculatortest.App example1.txt output.txt