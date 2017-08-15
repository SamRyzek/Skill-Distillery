### Pig Latin

#### Application Overview

You are going to write a translation program that converts English into Pig Latin. For an overview of the rules of pig latin [click here][pig].

The class that does the conversion will implement an interface. You will write JUnit tests for this class.

#### User Story #1

User is prompted for a word.

#### User Story #2

The word the user entered is returned, along with the pig latin equivalent.

#### User Story #3

The user can enter any number of words (a sentence/paragraph), and it will be returned to him/her along with the pig latin translation.

#### Stretch Goals

* Make sure everything is encapsulated within methods, only call one method in your main.

* Did you use StringBuilder to complete this? If not lets get to know StringBuilder. Create a brand new Java file with the prefix 'SB' and complete this assignment again using StringBuilder instead of String.

#### Class structure
* PigLatinApp - has main method, takes user input, calls Translator
* Translator - interface for translation with two methods
  ```java
  String translateWord(String word);
  String translateText(String sentence);
  ```
* PigLatinTranslatorImpl - implements `Translator`

#### JUnit tests
Create and implement JUnit tests for your `PigLatinTranslatorImpl` based on the [rules for Pig Latin][pig]. Also be sure to handle `null` String inputs. Methods should be well-named to reflect the class' functionality, such as
```java
@Test
public void test_translateWord_returns_empty_String_for_null_input(){
  //tests
}

@Test
public void test_translateWord_for_word_starting_with_consonant_and_vowel_moves_consonant_to_end_of_word_and_adds_ay(){
  //tests
}
```
_Write JUnit tests before method implementations._

[pig]: http://web.ics.purdue.edu/~morelanj/RAO/prepare2.html
