### Roman Numerals

#### Application Overview

You are going to make an application that translates Hindu-Arabic Numerals (i.e. 1,2,3) into Roman Numerals (i.e. I, II, III).  Your translator should implement the `Translator` interface from the Pig Latin project (or, if you have one, extend your `AbstractTranslator` class.)  Call your number translation method(s) from `translateWord()`.

You will build up the logic user story by user story to allow for larger and larger numbers to be converted. Don't try to jump ahead too fast, make sure that each step is working, and that the previous user stories are still working correctly after you've moved onto the next solution.

You will use JUnit tests to confirm your translation works.  A starting set of JUnit tests is provided in [RomanNumeralTranslatorImplTests.java](RomanNumeralTranslatorImplTests.java).  As you work on larger and larger numbers, add additional test cases (you don't need to test every possible number, obviously.)


#### User Story #1

The user is asked to input a number less than 10.

#### User Story #2

The user is presented with the Roman Numeral which corresponds to the number they entered.

#### User Story #3

If the user inputs non-integer text, their original text is returned.

#### User Story #4

User is re-prompted to enter a number up to 100.

#### User Story #5

User is re-prompted to enter a number up to 1,000.

#### User Story #6

User is re-prompted to enter a number over 1,000,000.

#### Stretch Goals

* Now that you understand the logic to go from numbers to numerals, can you do the reverse? Take Roman Numerals as input and convert them into Hindu-Arabic Numbers.
