public class MyThread extends Thread {
  private final int bufSize = 10;
  private int[] buf;
  private boolean[] read;
  private int id;
  private MyThread other;
  private int times;

  public MyThread(int id) {
    this.id = id;
    this.buf = new int[this.bufSize];
    this.read = new boolean[this.bufSize];
    this.times = 100;
  }

  public MyThread(int id, MyThread obj) {
    this(id);
    this.other = obj;
  }

  private int clear(int x) {
    int i = 0;
    while(i <= x) {
      this.buf[i] = 0;
      this.read[i] = false;
      x++;
    }
    return i-1;
  }

  private void count() {
    int i = 1, j;
    while(i <= this.times) {
      j = 0;
      while(j < (this.bufSize - 1) && this.read[j] == true)
        j++;
      this.clear(j);
      this.buf[j] = i;
      try {
        Thread.sleep(210);
      }
      catch (InterruptedException e) {
        System.out.println("Sleep interrupted");
      }
      i++;
    }
  }

  private void getCount() {
    int i = 0, j, tmp = -1;
    while(tmp <= 10) {
      j = 0;
      try {
        while(this.other.buf[0] == 0)
          Thread.sleep(10);
      }
      catch (InterruptedException e) {
        System.out.println("Sleep interrupted");
      }
      while(j < this.bufSize && this.other.buf[j] > 0)
        j++;
      if(j > 0)
        j--;
      // System.out.println("j is " + j);
      if(tmp != this.other.buf[j]) {
        System.out.print(this.other.buf[j] + " ");
        this.other.read[j] = true;
        i++;
        tmp = this.other.buf[j];
      }
    }
    // this.other.stop();
  }

  public void run() {
    this.clear(0);
    if(id == 1)
      this.count();
    else if(id == 2)
      this.getCount();
  }

  public static void main(String[] args) {
    MyThread t1 = new MyThread(1);
    MyThread t2 = new MyThread(2, t1);
    t1.start();
    t2.start();
  }
}
