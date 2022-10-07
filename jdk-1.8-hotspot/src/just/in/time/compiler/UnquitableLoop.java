package just.in.time.compiler;

/**
 * 无法退出的循环
 *
 * subthreadNeedRun 在子线程频繁使用，已被优化为局部变量，
 * 可设置volatile修饰符，让subthreadNeedRun始终可见
 */
public class UnquitableLoop {
    // 子线程是否需要运行
    private static boolean subthreadNeedRun = true;
    // private volatile static boolean subthreadNeedRun = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
           while (subthreadNeedRun) {

           }
           System.out.println("子线程结束");
        });
        t1.start();
        Thread.sleep(1000);
        subthreadNeedRun = false;
        t1.join();
        System.out.println("主线程结束");
    }
}
