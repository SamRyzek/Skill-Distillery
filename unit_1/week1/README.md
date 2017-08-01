### Week 1 — Fundamentals of Programming using Java

#### Learning Objectives
* Create programs using Java's basic syntax:
    * variables
    * conditionals (if and switch statements)
    * loops
    * methods
    * arrays
* Compile and run Java programs on the command line
* Use Git and Github for version control
* Utilize [Pair Programming][pair] to share knowledge and foster communication.
* Create Java programs using the Eclipse Integrated Development Environment (IDE)

**Monday**:
* Daily Objectives
  * Understand what memory is and how it is used.
  * Be able to create and use variables to hold data.
  * Understand variable types and memory allocation sizes.
  * Be able to write output to the screen; format that output.
  * Be able to collect and display user input.
  
* Orientation
* [Fundamentals of Computer Programming](JFOP)
   * Chapter 4 - Data Types, Constants, and Variables
   * Chapter 5 - Screen Output and Keyboard Input
* Project: [Day One Setup](Day1-Setup)

**Tuesday**:
* Daily Objectives
  * Understand expressions and operators, and how they are used.
  * Be able to write programs that use AND and OR logic.
  * Be able to use if, else, switch control flow statements.
  * Be able to use for, while, and do while loops.
  
* [Fundamentals of Computer Programming](JFOP)
   * Chapter 6 - Expressions
   * Chapter 7 - Decision Making
   * Chapter 8 - Looping
* Project: [HiLo](hiLo/README.md)
* Project: [FizzBuzz](fizzBuzz/README.md)

**Wednesday**:
* Daily Objectives
  * Be able to create and use methods and pass values as parameters.
  * Understand local vs. class variable scope.
  * Declare and use one and two-dimensional arrays.
  
* [Fundamentals of Computer Programming](JFOP)
   * Chapter 9 - Methods
   * Chapter 10 - Data Collections: Arrays
   * Chapter 11 - Debugging
* Project: [Tic Tac Toe](tictactoe/README.md)

**Thursday**:
* Daily Objectives
  * Know the difference between JVM, JRE, and JDK.
  * Use the args array to pass runtime parameters to a Java program.
  * Install and use Eclipse, including debugger.
  * Know rules for variable naming.
  * Understand Java primitives and rules for casting.
  * Understand local and final variable assignment rules.
  * Be able to determine if two Strings are equal.

* Java 1
   * Chapter 1 - Course Overview
   * Chapter 2 - Getting Started with Java
   * Chapter 3 - Eclipse
   * Chapter 4 - Datatypes and Variables
   * Chapter 5 - Operators and Expressions
* Project: [Deaf Grandma](deaf_grandma/README.md)
* Project: [Employee Menu](employee_menu/README.md)

**Friday**:
* Daily Objectives
  * Use for, while, do-while loops.
  * Understand the difference between while and do-while.
  * Use methods with arguments and return values.
  * Understand code blocks and variable scope.
  * Understand the difference between static and class variables.
  
* Java 1
   * Chapter 6 - Control Flow
   * Chapter 7 - Methods
* Project: [Make Change](makeChange/README.md)

**Homework**:
* Reading
  * Head First Java, Chapters 1-5 (Some will be review, some will be new information)
* Coding
  * Make Change Project (from Friday)
  * Complete any projects/labs that you haven't finished.


#### Git with it!
* [Git/Github Resources][git]
* [Git Cheatsheet][cheat]

Git is version control software (note, Git and Github are two different things), which you can use as an individual or with a team to persist different states of your code. This is useful if you accidentally create a bug in your program and need to revert back to a previous working version. It is also handy when you have a team of people all working on the same project and need to keep track of what is happening.

This week we are going to get a lot of practice with the following git commands:

* `git status`
* `git add file_name`
* `git commit -m "message"`
* `git branch branchname`
* `git checkout branchname`
* `git push origin branchname`

We are also going to practice writing descriptive commit messages, and talk about what makes a good commit message.

At first git can seem a little scary, but the genius of git is that when you use it, it is much harder to break things (you can always revert!).

#### Github

Github is a cross between a social networking site, giant file share, and project showcase. There you can find open source projects, code samples, documentation for dependencies, pretty much anything open source. It's also a way to display projects to the world (like on a resume), and interact with other developers.

#### Github Pages
* [Getting Started Guide][ghp]

With your Github account you have access to what amounts to a free domain with hosting. Github Pages is a very simple way to get started with your own site, and the documentation for getting it up and running is excellent. Here are two resources that should help you get going, you can Google around for more info on how to make it a little more interesting, or if you ask for one, we can do a lightning talk on some various options.

* [Github Pages][gitpages]
* [Github Pages Guide][guide]

[gitpages]:https://pages.github.com/
[guide]:https://guides.github.com/features/pages/
[git]:../resources/github_resources.md
[ghp]:../resources/github_pages.md
[cheat]:../resources/git_cheatsheet.md
[pair]:../resources/pair_programming.md
