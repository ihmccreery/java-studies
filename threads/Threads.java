public class Threads implements Runnable {
    private String msg;
    private int wait;

    public Threads(String msg, int wait) {
        this.msg = msg;
        this.wait = wait;
    }

    public void run() {
        try {
            Thread.sleep(wait);
            System.out.println(this.msg);
        } catch(InterruptedException e) {
            return;
        }
    }

    public static void main(String[] args) {
        (new Thread(new Threads("arg!", 10))).start();
        (new Thread(new Threads("ack!", 1000))).start();
        (new Thread(new Threads("wow!", 0))).start();
        (new Thread(new Threads("yup!", 500))).start();
    }
}
