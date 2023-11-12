
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
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                }
                String str = String.format("%s: %s: %s\n", this.getClass().getSimpleName(), name, --value);
                System.out.print(str);
            }
        }//A thread class that is described through an implementation of the Runnable interface. Its task in the loop at
        // each iteration is to decrease by 1 and display the value of the value variable in the console. The names of
        // the class and the thread are also printed to the console.
    }

    static class Increment extends Thread{
        public void run(){

            for (int i = 0; i < COUNT; i++) {
                try{
                    Thread.sleep(3);
                }
                catch(InterruptedException e){
                    System.out.println("Thread has been interrupted");
                }
                String str = String.format("%s: %s: %s\n", this.getClass().getSimpleName(), Thread.currentThread().getName(), ++value);
                System.out.print(str);
            }

        }
        // Its task in the loop at each iteration is to
        // increase by 1 and output the value of the value variable to the console. The names of the class and the thread
        // are also printed to the console.
    }
    public static void main(String[] args) {
        new Increment().start();
        new Decrement("Thread-1: ").run();
    }
}