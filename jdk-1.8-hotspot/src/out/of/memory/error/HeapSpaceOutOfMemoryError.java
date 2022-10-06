package out.of.memory.error;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆空间内存溢出错误
 * 1. 创建大量的不能被垃圾回收的小对象
 * 2. 创建少量的不能被垃圾回收的大对象
 * 为了方便测试，堆内存设置为 10M
 * -XX:InitialHeapSize=10m -XX:MaxHeapSize=10m -XX:+PrintGC -XX:+PrintGCDetails
 *
 * [GC (Allocation Failure) [PSYoungGen: 1781K->488K(2560K)] 7925K->6812K(9728K), 0.0007143 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 488K->488K(2560K)] 6812K->6868K(9728K), 0.0004309 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 488K->0K(2560K)] [ParOldGen: 6380K->6783K(7168K)] 6868K->6783K(9728K), [Metaspace: 3318K->3318K(1056768K)], 0.0037951 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 0K->0K(2560K)] 6783K->6783K(9728K), 0.0002402 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2560K)] [ParOldGen: 6783K->6765K(7168K)] 6783K->6765K(9728K), [Metaspace: 3318K->3318K(1056768K)], 0.0037845 secs] [Times: user=0.14 sys=0.00, real=0.01 secs]
 * Heap
 *  PSYoungGen      total 2560K, used 61K [0x00000000ffd00000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 2048K, 3% used [0x00000000ffd00000,0x00000000ffd0f748,0x00000000fff00000)
 *   from space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
 *   to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 *  ParOldGen       total 7168K, used 6765K [0x00000000ff600000, 0x00000000ffd00000, 0x00000000ffd00000)
 *   object space 7168K, 94% used [0x00000000ff600000,0x00000000ffc9b730,0x00000000ffd00000)
 *  Metaspace       used 3352K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 366K, capacity 388K, committed 512K, reserved 1048576K
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at out.of.memory.error.HeapSpaceOutOfMemoryError.createBigObjects(HeapSpaceOutOfMemoryError.java:33)
 * 	at out.of.memory.error.HeapSpaceOutOfMemoryError.main(HeapSpaceOutOfMemoryError.java:26)
 */
public class HeapSpaceOutOfMemoryError {
    private static final int SIZE_1M = 1024 * 1024;

    public static void main(String[] args) {
        createBigObjects();
    }

    private static void createBigObjects() {
        List<char[]> list = new ArrayList<>();
        // 创建10个大对象
        for (int i = 0; i < 10; i++) {
            list.add(new char[SIZE_1M]);
        }
    }
}
