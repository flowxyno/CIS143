# Use Case
In the lab, you learned a little about creating a Lambda and how it operates.

However, in general, you will be, on a day to day basis, using and constructing the function, however, not the declaration. 
Meaning, library developers will create the definitions that they require for their methods, but you will need to create the 
the execution of the method. So, the lib can create the contract and you would create the implemenation.

One such library, potentially one of the most powerful around, is the Streams library.
This Streams lib gets rid of large amount of boilerplate allowing the developer to focus on declarions rather than semantics.
Gone are the for loops that clutter up the application. Simply declare how you want the data processed and the Stream library will take care of the rest.

Note that this homework assignment does not expect you to have an intemate knowledge of Streams. That would take considerable time.
Instead, we will focus on the following (not in this order) methods:
1. filter
2. reduce
3. map
4. collect
5. sorted

Note that you will be using the Stream API on List objects. As a result, to start the stream, you will need to call the List.stream().
So, if you have a List called hotDogs, you will start the stream as follows:
   hotdogs.stream()...
   
# Reading

To read about Streams, be careful not to fall to far into the rabbit whole on this, you can reference the following:
https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

# You TODO

Make the Main.java run without errors by adding the required code (using the streams API (no for loops)) to the HomeworkStuff class.
