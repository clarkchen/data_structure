package Sort.RadixSort;

/**
 * Created by chenxi on 15/4/29.
 */
public class Solution {

    //返回 value 至的 第 index 位
    //例如  (1345,0) 则返回的时 5 ,(1345, 1) 则返回的时 4
    int getValueFromIndex(int value, int index)
    {
         for(int i=0;i<index && value >0; i++)
       {
           value = value/10;
       }
       return  value %10;
    }

    void sort(int[] values)
    {
        MyList[] lists = new MyList [10];
        for(int i =0;i<lists.length;i++)
        {
            lists[i] =  new MyList();
        }


        Solution slu =  new Solution();

        //表示从现在正在检验的位数
        int index = 0;
        //如果  lists[0] 上集中了全部的元素,则排序结束
        boolean isNotFinish = true;
        while(isNotFinish)
        {

            isNotFinish = false;
            //values 进入 链表数组 lists
            //遍历数组的一种特殊用法, 依次遍历 values 中的每一个元素
            for (int v : values)
            {
                //获得 index 位 上的数字
                int list_index = slu.getValueFromIndex(v, index);
                //按照数字找到 对应的 list 进行插入
                lists[list_index].inserFromTail(v);
                if (!isNotFinish && list_index>0) isNotFinish = true;
            }

            //除了0以外的其他 lists 元素上没有数据了,表示排序已经完成
            if (!isNotFinish) break;

            //链表数组 填充 values数组
            for(int i=0, j=0;i<lists.length;i++)
            {
                Node cur = lists[i].popFromHead();

                if(cur==null) continue;

                while(cur !=null)
                {
                    values[j] = cur.value;
                    cur = lists[i].popFromHead();
                    j++;
                }
            }
            index += 1;
        }

    }

}
