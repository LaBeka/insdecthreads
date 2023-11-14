
public class IncDecThreads{

    static final int COUNT = 5000;
    static long value;

    static class Decrement implements Runnable{
        String name;

        public Decrement(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                }
                System.out.printf("%s: %s: %s\n", this.getClass().getSimpleName(), name, --value);
            }
        }
    }

    static class Increment extends Thread{
        public void run(){
            for (int i = 0; i < COUNT; i++) {
                try{
                    Thread.sleep(0);
                }
                catch(InterruptedException e){
                    System.out.println("Thread has been interrupted");
                }
                System.out.printf("%s: %s: %s\n", this.getClass().getSimpleName(), Thread.currentThread().getName(), ++value);
            }

        }
    }
    public static void main(String[] args) {
        new Increment().start();
        new Decrement("Thread-1: ").run();
    }
}