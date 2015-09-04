Repository: java-sf-builder-simple-example

#"Simplest java builder pattern" or "Resurrection of double braces initialization"

What is double brace initialization?
See <http://stackoverflow.com/questions/1958636/what-is-double-brace-initialization-in-java> <http://c2.com/cgi/wiki?DoubleBraceInitialization>.

##Advantages:
1. Very simply to use.

##Disadvantages:
1. Breaks "equals" compatibility.
2. No checks performed, when use direct assignments. 
3. Possible memory leaks.

Can we avoid these troubles? Yes!

1. Make separate "Builder" class especially for double brace initialization.
2. Declare fields with default values.
3. Put object creation method in that class.

##Advantages:
1. Simply to use.
2. Do not breaks "equals" compatibility.
3. You can perform checks in creation method. 
4. No memory leaks.

##Disadvantages:
None

And, as a result, we have simplest java builder pattern ever.

##Usage:
<https://github.com/speaking-fish/java-sf-builder-simple-example/tree/master/src/com/speakingfish/builder/simple/test>

##Related:
For most complicated java builder pattern see <https://github.com/speaking-fish/java-sf-builder-mega>
