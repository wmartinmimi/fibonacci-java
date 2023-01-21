import java.math.BigInteger;

class FibT{

  static abstract class Cal {
    Cal next;
    BigInteger fn, fnm1;
    abstract void cal();
  }

  static class Basic extends Cal{
    @Override
    void cal(){
      var fnp1 = fn.add(fnm1);
      fnm1 = fn;
      fn = fnp1;
    }
  }

  static class Quick extends Cal{

    static final BigInteger two = BigInteger.valueOf(2);

    @Override
    void cal(){
      var f2n = fnm1.multiply(two).add(fn).multiply(fn);
      var f2nm1 = fnm1.multiply(fnm1).add(fn.multiply(fn));
      fn = f2n;
      fnm1 = f2nm1;
    }
  }

  static class Just1 extends Cal{
    @Override
    void cal(){
      fn = BigInteger.ONE;
    }
  }

  static class FibTree{
    Cal entry;
    static final BigInteger two = BigInteger.valueOf(2);

    FibTree(BigInteger n){
      Cal next;
      if (n.compareTo(two) <= 0){
        entry = new Just1();
        return;
      }
      while (!n.equals(two)){
        next = entry;
        if (n.remainder(two).equals(BigInteger.ZERO)){
          entry = new Quick();
          n = n.divide(two);
          //println("q" + n.toString());
        } else {
          entry = new Basic();
          n = n.subtract(BigInteger.ONE);
          //println("b" + n.toString());
        }
        entry.next = next;
      }
    }
    BigInteger cal(){
      BigInteger fn = BigInteger.ONE;
      BigInteger fnm1 = BigInteger.ONE;
      BigInteger debug_n = BigInteger.ZERO;
      while (entry != null){
        entry.fn = fn;
        entry.fnm1 = fnm1;
        entry.cal();
        fn = entry.fn;
        fnm1 = entry.fnm1;
        //println("fn: " + fn.toString() + " fnm1: " + fnm1.toString());
        entry = entry.next;
        debug_n = debug_n.add(BigInteger.ONE);
        //println("next!" + debug_n.toString());
      }
      return fn;
    }
  }

  static void println(String str){
    System.out.println(str);
  }

  public static void main(String[] args){
    var t = new FibTree(new BigInteger(args[0]));
    println(t.cal().toString());
  } 
}
