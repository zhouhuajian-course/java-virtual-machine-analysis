package stack.overflow.error;

/**
 * 栈溢出错误
 *
 * 线程栈内存大小默认根据虚拟内存分配
 *
 * D:\Java\jdk1.8.0_333\bin\java.exe "-javaagent:D:\jetbrains\IntelliJ IDEA Community Edition 2022.2.2\lib\idea_rt.jar=62625:D:\jetbrains\IntelliJ IDEA Community Edition 2022.2.2\bin" -Dfile.encoding=UTF-8 -classpath D:\java\jdk1.8.0_333\jre\lib\charsets.jar;D:\java\jdk1.8.0_333\jre\lib\deploy.jar;D:\java\jdk1.8.0_333\jre\lib\ext\access-bridge-64.jar;D:\java\jdk1.8.0_333\jre\lib\ext\cldrdata.jar;D:\java\jdk1.8.0_333\jre\lib\ext\dnsns.jar;D:\java\jdk1.8.0_333\jre\lib\ext\jaccess.jar;D:\java\jdk1.8.0_333\jre\lib\ext\jfxrt.jar;D:\java\jdk1.8.0_333\jre\lib\ext\localedata.jar;D:\java\jdk1.8.0_333\jre\lib\ext\nashorn.jar;D:\java\jdk1.8.0_333\jre\lib\ext\sunec.jar;D:\java\jdk1.8.0_333\jre\lib\ext\sunjce_provider.jar;D:\java\jdk1.8.0_333\jre\lib\ext\sunmscapi.jar;D:\java\jdk1.8.0_333\jre\lib\ext\sunpkcs11.jar;D:\java\jdk1.8.0_333\jre\lib\ext\zipfs.jar;D:\java\jdk1.8.0_333\jre\lib\javaws.jar;D:\java\jdk1.8.0_333\jre\lib\jce.jar;D:\java\jdk1.8.0_333\jre\lib\jfr.jar;D:\java\jdk1.8.0_333\jre\lib\jfxswt.jar;D:\java\jdk1.8.0_333\jre\lib\jsse.jar;D:\java\jdk1.8.0_333\jre\lib\management-agent.jar;D:\java\jdk1.8.0_333\jre\lib\plugin.jar;D:\java\jdk1.8.0_333\jre\lib\resources.jar;D:\java\jdk1.8.0_333\jre\lib\rt.jar;C:\Users\zhouh\Desktop\java-virtual-machine-analysis\out\production\jdk-1.8-hotspot stack.overflow.error.StackOverflowError
 * 栈深度：33441
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at stack.overflow.error.StackOverflowError.createALotOfStackFrames(StackOverflowError.java:20)
 * 	at stack.overflow.error.StackOverflowError.createALotOfStackFrames(StackOverflowError.java:20)
 * 	at stack.overflow.error.StackOverflowError.createALotOfStackFrames(StackOverflowError.java:20)
 * 	...
 *
 *  如果设置线程栈大小为1m
 * 	-XX:ThreadStackSize=1m
 *
 * 	栈深度：23522
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at stack.overflow.error.StackOverflowError.createALotOfStackFrames(StackOverflowError.java:30)
 * 	at stack.overflow.error.StackOverflowError.createALotOfStackFrames(StackOverflowError.java:30)
 * 	at stack.overflow.error.StackOverflowError.createALotOfStackFrames(StackOverflowError.java:30)
 * 	...
 */
public class StackOverflowError {
    // 栈深度
    private static int depth = 0;

    public static void main(String[] args) {
        try {
            createALotOfStackFrames(1);
        } finally {
            System.out.println("栈深度：" + depth);
        }
    }

    private static void createALotOfStackFrames(int depth) {
        StackOverflowError.depth++;
        createALotOfStackFrames(depth);
    }
}
