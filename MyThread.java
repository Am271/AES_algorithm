public class MyThread extends Thread {
  private int id;
  private int times;

  public MyThread(int id, int t) {
    this.id = id;
    this.times = t;
  }

  private void count() {
    for(int i = 1; i <= this.times; i++)
      System.out.println("Thread no. " + this.id + " count: " + i);
  }

  public void run() {
    this.count();
  }

  public static void main(String[] args) {
    MyThread t1 = new MyThread(1, 50);
    MyThread t2 = new MyThread(2, 100);
    t1.start();
    t2.start();
  }
}
