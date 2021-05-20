# Use Case
Once you get out in the field, you will need to learn to leverage annotations. Spring and other framworks rely heavily on them to reduce
the boilerplate code required within a project. Lombok is another library that makes life easier.

In this example, we are going to use the standard annotations from Java. You can read about them here. https://beginnersbook.com/2014/09/java-annotations/

In short, you have:
1. @Override: Which is when a method overrides the parent classes method, or more commonally, will implement an interface. In ous case we will
be implementing an interface.
2. @Depreciated: When a field or method is due to be removed in future releases. This provides the compiler with a warning to tell developers that 
something is due for removal.
3. @SuppressWarnings: This will tell the compile to suppress a warning and not display it.

# You TODO

1. Add the @Override annotation, for any methods implemented from the IHomeworkAnnotation interface.
2. Add the @Depreciated annotation to all the methods in the HomeworkAnnotations class.
3. Suppress the compiler warnings.