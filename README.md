# Calculator with Java and TDD

This is a simple Java project that shows how to parse arguments with regular expressions and perform calculations using BigDecimal (to guarantee accuracy). It is developed using the Test-Driven Development (TDD) method. TDD is a software development process that supports creating automated tests before the actual code. Now a standard best practice for developers working in an Agile development environment, it saves programmers from having to debug and rework their software. Instead, programmers can focus on the design and coding part.

In TDD, a test case is first created for a particular feature, normally a class. If the test case fails, new code is written to pass it. The code is then refactored until the test passes for all the parameters or given scenarios. 

## Design Pattern
The project uses the Strategy design pattern, first documented by Erich Gamma et al. in their book "Design Patterns: Elements of Reusable Object-Oriented Software."

This pattern allows the selection of an algorithm at runtime. In this project, a CalculationStrategy interface is created to encapsulate an execute method that is implemented by all subclasses. There are four subclasses of CalculationStrategy, each representing an operation: AdditionStrategy, SubtractionStrategy, MultiplicationStrategy and DivisionStrategy.

There is also a Context class that delegates an algorithm to different Strategy objects.

## Cloning the project
```
git clone https://github.com/budi-kurniawan/calculator.git
```

## Dependencies
- Maven 3 or later. This project is structured according to Maven directory structure.

## Testing the app
This project includes a test class (CalculatorTest) for various scenarios. To run the tests, do these:

- $cd /path/to/app
- $mvn test
