package sort;

import list.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort implements Sort{
    @Override
    public void sort(int[] arr) {
        int min = getMin(arr);
        int max = getMax(arr);


        int bucketCount =Math.max(5,(int) Math.ceil(arr.length*0.5));

        //桶的大小即为每个桶中元素的大小范围,比如第一个桶存1-10，第二个桶存11-20
        int bucketSize = (max-min)/bucketCount+1;


        //创建桶
        List<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i]=new ArrayList<>();
        }


        //元素存桶
        for (int value:arr){
            int index = (value-min)/bucketSize;
            buckets[index].add(value);
        }
        //每个桶独立排序
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);
        }
        //合并桶到原数组
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++]=buckets[i].get(j);
            }
        }
    }
}
