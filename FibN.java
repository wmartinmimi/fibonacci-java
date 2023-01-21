import java.math.BigInteger;

class Fib{

  static BigInteger fib(BigInteger n, BigInteger r, BigInteger fn, BigInteger fnm1){
    while (n.compareTo(r) < 0){
      var fnp1 = fn.add(fnm1);
      fnm1 = fn;
      fn = fnp1;
      n = n.add(BigInteger.ONE);
      // print(f"{fn} n: {n}")
      println(n.toString() + " / " + r.toString() + " | " + String.valueOf(n.divide(r).floatValue() * 100) + "%");
    }
    return fn;
  }

  static BigInteger qfib(BigInteger n, BigInteger r, BigInteger fn, BigInteger fnm1){
    var two = BigInteger.valueOf(2);
    while (n.multiply(two).compareTo(r) < 0){
      var f2n = fnm1.multiply(two).add(fn).multiply(fn);
      // f2n = (2 * fnm1 + fn) * fn
      var f2nm1 = fnm1.multiply(fnm1).add(fn.multiply(fn));
      // f2nm1 = fnm1 * fnm1 + fn * fn
      fn = f2n;
      fnm1 = f2nm1;
      n = n.multiply(two);
      // print(f"q: {fn} n: {n}")
      println(n.toString() + " / " + r.toString() + " | " + String.valueOf(n.divide(r).floatValue() * 100) + "% (quick mode)");
    }
    if (n.compareTo(r) <= 0){
      fn = fib(n, r, fn, fnm1);
    }
    return fn;
  }

  static BigInteger cal(BigInteger r){
    var two = BigInteger.valueOf(2);
    if (r.compareTo(two) <= 0){
      return BigInteger.ONE;
    } else {
      return qfib(two, r , BigInteger.ONE, BigInteger.ONE);
    }
  }

  static void println(String str){
    System.out.println(str);
  }

  public static void main(String[] args){
    println(cal(new BigInteger(args[0])).toString());
    // fib(new BigInteger(args[0]));
  } 
}
