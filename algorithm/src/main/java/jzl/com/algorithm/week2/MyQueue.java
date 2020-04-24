package jzl.com.algorithm.week2;

/**
 * com.example.administrator.mytemplateapplication.network.utils
 * Created by kingj on 2020/3/27 0027.
 */
public class MyQueue {

    private int [] queue = new int[1];
    private int pointer = -1;
    private int start = 0;

    public void enqueue(int i){
        pointer++;
        if(pointer >=queue.length){
            resizeArray();
        }
        queue[pointer] = i;
    }

    private void resizeArray() {
        int [] newArray = new int[queue.length*2];
        for (int i=0;i<queue.length;i++){
            newArray[i] = queue[i];
        }
        queue = newArray;
    }

    public int dequeue(){
        if (pointer == -1){
            return -1;
        }
        if (start>pointer){
            return -1;
        }
        int result = queue[start];
        start++;
        if ((pointer-start)<queue.length/4){
            downsizeArray();
        }
        return result;
    }

    private void downsizeArray() {
        int [] newArray = new int[queue.length/2];
        for (int i=0;i<=pointer;i++){
            newArray[i] = queue[i];
        }
        queue = newArray;
        start=0;
    }
//todo 完成这个类
}
