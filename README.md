# fibonacci-java

## Description

Calculate the nth Fibonacci number using java.

A fun simple project I played with.

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

  Now also work with negative nth Fibonacci.

## Usage

```bash
java Fib.java <n>
```

or

```bash
java FibN.java <n>
```

or

```bash
java FibT.java <n>
```

Example

```bash
java FibT.java 10000
```

## Last Readme update

- Date: 03-02-2023 dd-MM-yyyy
