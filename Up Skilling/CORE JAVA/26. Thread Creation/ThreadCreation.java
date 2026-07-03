public class ThreadCreation {

    public static void main(String[] args) {

        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");

        thread1.start();
        thread2.start();
    }
}

class MyThread extends Thread {

    private String threadName;

    MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": Message " + i);
        }
    }
}