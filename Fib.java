import java.math.BigInteger;

class Fib{

  static void println(String str){
    System.out.print(str);
  }

  public static void main(String[] args){
    fib(new BigInteger(args[0]));
  }

  static void fib(BigInteger n){
    //println("{[");
    var secondLast = BigInteger.ZERO;
    var last = BigInteger.ZERO;
    for (; n.compareTo(BigInteger.ONE) > 0; n = n.subtract(BigInteger.ONE)){
      var current = secondLast.add(last);
      if (current.equals(BigInteger.ZERO))
      current = BigInteger.ONE;
      secondLast = last;
      last = current;
      //println(current.toString()+", ");
    }
    var current = secondLast.add(last);
    println(current.toString() + "\n");
  }
}
