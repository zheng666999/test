package com.background.demo.util;
import com.background.demo.entity.Pivilege;

import java.util.ArrayList;
import java.util.List;

public class BasicTree implements Cloneable
{
    //节点数据
    public Pivilege data;
    //孩子节点
    public List<BasicTree> children;
    public BasicTree(){
        data=null;
        children=new ArrayList<BasicTree>();
    }

    public void createNode(Pivilege data){
        this.data=data;
    }


    @Override
    public Object clone() {
        BasicTree bt = null;
        try{
                    bt = (BasicTree)super.clone();
              }catch(CloneNotSupportedException e) {
                   e.printStackTrace();
              }
            return bt;
       }
}
