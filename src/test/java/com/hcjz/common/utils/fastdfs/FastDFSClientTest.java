package com.hcjz.common.utils.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FastDFSClientTest {

    @Test
    public void upload() throws IOException,MyException {
        // 1.导入jar包依赖
        // 2.加载配置文件（配置文件的内容是tracker服务器的地址）
        ClientGlobal.init("E:\\hjmall\\hjmall-common\\src\\test\\resources\\fdfs_client.conf");
        // 3.创建tarckerClient对象
        TrackerClient trackerClient = new TrackerClient();
        // 4.通过tarckerClient创建爱你trackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5.声明strogageServer对象
        StorageServer storageServer = null;
        // 6.创建StoageClient对象
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7.使用StoageClient完成图片的上传
        String[] strings = storageClient.upload_file("C:\\Users\\汪成胜\\Pictures\\reso\\002.jpg", "jpg", null);
        // 8.遍历返回的数组
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void uploadLocal() throws IOException,MyException {
        File file = new File("C:\\Users\\汪成胜\\Pictures\\reso\\002.jpg");
        String[] uploadFile = FastDFSClient.uploadLocal(file);
        for (String s : uploadFile
                ) {
            System.out.println(s);
        }
    }


    @Test
    public void getFile() {
        File file = new File("C:\\Users\\汪成胜\\Pictures\\reso\\002.jpg");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
    }

    @Test
    public void downFile() {
        InputStream downFile = FastDFSClient.downFile("group1", "M00/00/00/wKgAbVy6l3SAD1PPAAYxp8XKoLM637.jpg");
    }

    @Test
    public void deleteFile() throws Exception {
        FastDFSClient.deleteFile("group1","M00/00/00/wKgAbVy6tP6AFaolAAYxp8XKoLM57..jpg");
    }
}