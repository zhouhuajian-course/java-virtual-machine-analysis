package magic.number.checker;

/**
 * Java .class 文件 16进制 使用0xcafebabe 开头
 * 用来标识这个文件是 Java 的类字节码文件
 *
 * café noun [ C ] (also cafe) /ˈkæf.eɪ/ a restaurant where simple and usually quite cheap meals are served
 * （一般不供应酒类的）小餐馆，小饭馆，咖啡馆
 * babe noun [ C ] /beɪb/ a small baby
 * 婴儿，婴孩
 *
 * Magic number (programming)
 * A constant numerical or text value used to identify a file format or protocol; for files, see List of file signatures
 *
 * 1. javac -encoding UTF-8 magic/number/checker/CafeBabe.java
 * 2. java magic/number/checker/CafeBabe
 * 3. UltraEdit修改0xCAFEBABE为0xCAFEAAAA
 * 4. java magic/number/checker/CafeBabe
 *
 * Error: A JNI error has occurred, please check your installation and try again
 * Exception in thread "main" java.lang.ClassFormatError: Incompatible magic value 3405687466 in class file magic/number/checker/CafeBabe
 *         at java.lang.ClassLoader.defineClass1(Native Method)
 *         at java.lang.ClassLoader.defineClass(ClassLoader.java:756)
 *         at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
 *         at java.net.URLClassLoader.defineClass(URLClassLoader.java:473)
 *         at java.net.URLClassLoader.access$100(URLClassLoader.java:74)
 *         at java.net.URLClassLoader$1.run(URLClassLoader.java:369)
 *         at java.net.URLClassLoader$1.run(URLClassLoader.java:363)
 *         at java.security.AccessController.doPrivileged(Native Method)
 *         at java.net.URLClassLoader.findClass(URLClassLoader.java:362)
 *         at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
 *         at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:355)
 *         at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
 *         at sun.launcher.LauncherHelper.checkAndLoadMain(LauncherHelper.java:601)
 *
 * JNI: Java Native Interface
 * 0xCAFE BABE: 3405691582
 * 0xCAFE AAAA: 3405687466
 */
public class CafeBabe {

    public static void main(String[] args) {
        System.out.println("测试0xCAFEBABE修改为0xCAFEAAAA");
    }

}
