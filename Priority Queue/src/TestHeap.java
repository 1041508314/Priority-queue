/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/5/25
 * @Content:
 */

import java.util.Arrays;

/**
 *
 * 堆
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap(){
        this.elem = new int[10];
    }

    /**
     *
     * root 代表的是每颗子树的开始位置
     * len 代表的是结束位置
     * @param root
     * @param len
     */
    public void adjustDown(int root,int len){
        int parent = root;
        int child = 2*parent+1;
        while(child < len){
            //1.找左右孩子 判断是否有左右孩子 有的话找到最大值 c下标表示最大值下标
            if(child+1 < len && this.elem[child] < this.elem[child+1]){
                child++;
            }
            if(this.elem[child] > this.elem[parent]){
                //进行交换
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }

    public void createHeap(int[] array){
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //i代表每颗子树根节点下标
        for (int i = (this.usedSize-1-1)/2; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }
    }


    /**
     * 堆的插入
     * 向上调整
     * 插入数据val
     * @param val
     */
    public void push(int val){
        //判断当前堆是不是满的 --》 扩容
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //放到数组的最后一个位置
        this.elem[this.usedSize] = val;
        this.usedSize++;
        //进行调整
        adjustUp(this.usedSize-1);
    }

    public void adjustUp(int child){
        int parent = (child-1)/2;
        while(child > 0){
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child - 1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }
    public void show(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    /**
     *
     * 堆的删除
     */
    public void pop(){
        //是否是空的
        if(isEmpty()){
            return;
        }
        //最后一个元素和堆顶元素进行交换
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;
        //调整0号下标这棵树
        adjustDown(0,this.usedSize);
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }


    public  int peek() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[0];
    }


    /**
     * 堆排序
     */
    public void heapSort(){
        int end = this.usedSize-1;
        while(end > 0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }
}
