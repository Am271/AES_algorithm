public class test {
  private static int a = 100;
  private int b;

  public test(int x) {
    this.b = x;
  }

  public static void main(String[] args) {
    test obj1 = new test(25);
    test obj2 = new test(35);
    System.out.println("Object1 a: " + obj1.a);
    System.out.println("Object2 a: " + obj2.a);
    System.out.println("Object1 b: " + obj1.b);
    System.out.println("Object2 b: " + obj2.b);
    obj2.a = 105; obj2.b = 10;
    System.out.println("Object1 a: " + obj1.a);
    System.out.println("Object2 a: " + obj2.a);
    System.out.println("Object1 b: " + obj1.b);
    System.out.println("Object2 b: " + obj2.b);
  }
}
