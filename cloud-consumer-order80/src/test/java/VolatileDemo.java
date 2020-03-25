import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: cuzz
 * @Date: 2019/4/16 21:29
 * @Description: 可见性代码实例
 */
public class VolatileDemo {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " coming...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.atomicAddSelf();
            System.out.println(Thread.currentThread().getName() + " updated...");
        }).start();
        System.out.println(data.num);
        System.out.println(Thread.currentThread().getName() + " job is done...");
    }
}

class Data {
    int num = 0;
//    volatile int num = 0;

    public synchronized void addToSixty() {
        this.num = 60;
    }

    public void addSelf(){
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void atomicAddSelf(){
        atomicInteger.getAndIncrement();
    }
}