# fibonacci-java

## Description

Calculate the nth Fibonacci number.

## Files

- Fib.java
  
  First version of the calculation.

  Fn(n + 1) = F(n) + F(n - 1)

- FibN.java

  Second version of the calculation.

  F(2n) = (2F(n) + F(n - 1)) * F(n)

  F(2n - 1) = F(n - 1)² + F(n)²

- FibT.java

  Third version of the calculation.

  Does essentially the same as FibN.java,
  but first generate quick path from top to bottom
  before calculating from bottom to top using the path.

## Usage

java Fib.java <n>

or

java FibN.java <n>

or

java FibT.java <n>

Example

java FibT.java 10000

## Last Readme update

- Date: 21-01-2023 dd-MM-yyyy
