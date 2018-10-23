package com.tdtk.springcloud.entities;

import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{//必须序列化
    private Long  deptno;   //主键
    private String  dname;   //部门名称
    private String  db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname){
        super();
        this.dname = dname;
    }

//    public static void main(String args[]){
//        //链式编程
//        Dept dept = new Dept().setDeptno(3L).setDname("张三").setDb_source("mysql_01");
//
//        System.out.println(dept);
//    }
}



