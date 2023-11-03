# Calculator with Java and TDD

This is a simple Java project that shows how to parse arguments with regular expressions and perform calculations using BigDecimal (to guarantee accuracy). It is developed using the Test-Driven Development (TDD) method. TDD is a software development process that supports creating automated tests before the actual code. Now a standard best practice for developers working in an Agile development environment, it saves programmers from having to debug and rework their software. Instead, programmers can focus on the design and coding part.

In TDD, a test case is first created for a particular feature, normally a class. If the test case fails, new code is written to pass it. The code is then refactored until the test passes for all the parameters or given scenarios. 

## SOLID Principles
The project follows the SOLID principles:
- **S**ingle responsibility. The application has been separated into classes/interfaces that each has single responsibility: 
    - **InputParser** is solely responsible for parsing the input
    - **InputValidator** is solely responsible for validating the input
    - **CalculationStrategy** is only responsible for performing one single algorithm
- **O**pen/closed principle. All classes are closed for modification but open for extension.
- **L**iskov substitution. Any subtype of a base class above can replace the base class without disrupting the behavior of our program.
- **I**nterface segregation. Each interface is the smallest unit possible.
- **D**ependency inversion. The main class, **Calculator**, can only be instantiated by injecting it with an instance of InputParser, InputValidator and a map of CalculationStrategy. A CalculatorBuilder class shows how to easily create a Calculator. A different builder can be created to inject Calculator with different implementations of the components.

## Design Pattern
The project uses these patterns (first documented by Erich Gamma et al. in their book "Design Patterns: Elements of Reusable Object-Oriented Software."):

- the Strategy design pattern. This pattern allows the selection of an algorithm at runtime. In this project, a CalculationStrategy interface is created to encapsulate an execute method that is implemented by all subclasses. There are four subclasses of CalculationStrategy, each representing an operation: AdditionStrategy, SubtractionStrategy, MultiplicationStrategy and DivisionStrategy. There is also a Context class that delegates an algorithm to different Strategy objects.
- the Builder design pattern. This pattern helps construct a Calculator object, considered complex due to the need to inject different dependencies.

## Java Version
It uses the latest feature of JDK 21, the pattern matching for switch.

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
