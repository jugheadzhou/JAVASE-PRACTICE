package com.jugheadzhou.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName: IoTest
 * @Description: 练习io流
 * 在电脑D盘下创建一个文件为HelloWorld.txt文件，
 * 判断他是文件还是目录，再创建一个目录IOTest,
 * 之后将HelloWorld.txt移动到IOTest目录下去；
 * 之后遍历IOTest这个目录下的文件
 * @Author: zhaoRong
 * @Create: 2019/6/20 16:11
 **/
public class IoTest {

    public static void main(String[] args) {
        String fileName = "HelloWorld.txt";
        String directoryPath_d = "D://";
        String directoryPath = "D://IOTest";
        IoTest ioTest = new IoTest();
        File helloFile = ioTest.createFile(directoryPath_d, fileName);
        File IOFileDirectory = ioTest.createDirectory(directoryPath);
        ioTest.moveFile(IOFileDirectory, helloFile);
        ioTest.fileDirectoryToString(directoryPath);

    }

    /**
     * 创建文件
     *
     * @param directoryPath
     * @param fileName
     */
    public File createFile(String directoryPath, String fileName) {
        File file = new File(directoryPath, fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException i) {
            i.printStackTrace();
        }
        if (file.isDirectory()) {
            System.out.println(fileName + "是目录！");
        } else {
            System.out.println(fileName + "是文件！");
        }
        return file;
    }

    /**
     * 创建目录
     *
     * @param directoryPath
     */
    public File createDirectory(String directoryPath) {
        File file = new File(directoryPath);
        if (file.exists()) {
            file.delete();
        }
        file.mkdir();
        return file;
    }

    /**
     * 移动文件
     *
     * @param fileDirectory
     * @param file
     */
    public void moveFile(File fileDirectory, File file) {
        File file1 = new File(fileDirectory.getPath() + "/" + file.getName());
        boolean flag = file.renameTo(file1);
        if (flag) {
            System.out.println("移动文件成功！");
        } else {
            System.out.println("移动文件失败！");
        }
    }

    /**
     * 遍历目录下的文件
     *
     * @param fileDirectory
     */
    public void fileDirectoryToString(String fileDirectory) {
        File file = new File(fileDirectory);
        String[] strings = file.list();
        System.out.println(fileDirectory + "目录下的文件：" + Arrays.toString(strings));
    }
}
