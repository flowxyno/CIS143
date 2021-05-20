# Use Case
In the this lab you will need to learn to catch and rethrow an excetion. 

In order to do this lab you will be creating your own exception and modifying both the ThrowsException and Main files to show that you understand the concepts.
 
# Before You Begin

Please read the following blog post about [using ArrayLists](https://www.baeldung.com/java-exceptions)

# You TODO

1. Create a file called MyException. This will be your exception class. Note that you will need to create a constructor that takes a string and the original exception.
2. Once the MyException has been created, you will need to, in the ThrowsException.throwAnExceptionForMe(), catch the exception (the ones already there) and:
    a. In the catch portion create a new MyException.
    b. Throw the new MyException.
3. At this point, you will need to update the method signature of the ThrowsException.throwAnExceptionForMe() in order to compile.
4. Once complete, you will have a compile error in the Main class. You will need to:
  a. Catch the new MyException
  b. In the catch portion do a System.out.println("Exception caught.");
  c. Remove the throws declaration from the method as well as the main method.
  d. So far we are 'swallowing' the exception. This is very bad. Once you have written 'Exception caught.' you with then need to rethrow with
     a RuntimeException. Note that this will not be in the method signature.
     
Note that with the above, your program will still fail, however it will fail with a RuntimeException. 
  