package com.tdtk.springcloud;

import org.csource.fastdfs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URLDecoder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {


    @Before
    public  void  Before(){

        System.out.println("======================这是测试方法执行之前============================");

    }

    @After
    public  void  After(){

        System.out.println("======================这是测试方法执行之后============================");

    }




    @Test
    public  void  testFind(){

        System.out.println("======================这是测试查询方法============================");

    }




    @Test
    public  void  testSave(){

        System.out.println("======================这是测试保存方法============================");

    }



    private String file_ext_name = "mp3";
    private String local_filename = "E://videos_dev//bgm//003_ds_40.mp3";

    @Test
    public void testFdfs() throws Exception{
        //获取fdfs_client配置文件路径
        String confPath = this.getClass().getResource("/fdfs_client.conf").getPath();
        //如果路径中有中文，需要处理中文乱码问题
        confPath = URLDecoder.decode(confPath,"utf-8");
        //加载fdfs_client配置文件
        ClientGlobal.init(confPath);
        //创建TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //创建TrackerServer
        TrackerServer trackerServer = trackerClient.getConnection();
        //创建storageServer
        StorageServer storageServer = null;
        //创建StorageClient1，客户端文件上传时，可以指定上传的服务期地址，也可以有trackerServer调度
        StorageClient1 client1 = new StorageClient1(trackerServer,storageServer);
        //调用StorageClient1的api方法完成文件的上传操作
        String upload_file1 = client1.upload_file1(local_filename, file_ext_name, null);
        //输出上传文件的file_id
        System.out.println(upload_file1);
    }


}
