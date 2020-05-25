import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/5/25
 * @Content:
 */

/**
 * 优先级队列
 * 要往PriorityQueue里面放东西一定是可比较大小的
 *
 * 底层是一棵二叉树
 *
 */
public class TestDemo {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.createHeap(array);
        testHeap.show();
        testHeap.push(80);
        testHeap.show();
        testHeap.pop();
        testHeap.show();
        System.out.println("排序");
        testHeap.heapSort();
        testHeap.show();
    }


    public static void main2(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(10);
        priorityQueue.offer(2);
        priorityQueue.offer(21);
        priorityQueue.offer(8);

        System.out.println(priorityQueue.peek());

    }


    public static void main1(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    }
}
