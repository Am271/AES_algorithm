class MyThread extends Thread {
    private int value;
    private MyThread obj;
    private int id;

    public MyThread(int id, int value) {
      this.id = id;
      this.value = value;
    }

    public MyThread(int id, MyThread obj) {
      this.obj = obj;
      this.id = id;
    }

    public void run() {
        try {
          for(int i = 0; i < 4; i++) {
                  System.out.println("Thread no." + id);;
                  if(id == 2) {
                    this.setVal(this.obj.getVal());
                    System.out.println("Value of 1st thread: " + this.getVal());
                  }
                  else {
                    System.out.println("Value of current thread: " + this.getVal());
                    this.value += 5;
                  }
                  Thread.sleep(1000);
            }
          }
        catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
    }

    public int getVal() {
      return this.value;
    }

    public void setVal(int a) {
      this.value = a;
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread(1, 10);
        MyThread t2 = new MyThread(2, t1);
        t1.start();
        t2.start();
    }
}
