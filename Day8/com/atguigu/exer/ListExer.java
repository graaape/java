package com.atguigu.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListExer {
    @Test
    public void testListRemove(){
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    private  void updateList(List list){
        //list.remove(2);//按索引删除
        list.remove(new Integer(2));//按数据删除
    }
}
