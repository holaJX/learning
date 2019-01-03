package karp.类加载器;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: pjx
 * @Date: 2018/12/21 15:07
 * @Version 1.0
 */
public class FileSystemClassLoader extends  ClassLoader {

    private String classLoaderName;
    private String path;

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileSystemClassLoader(ClassLoader parent, String classLoaderName, String path) {
        super(parent);
        this.classLoaderName = classLoaderName;
        this.path = path;
    }

    public FileSystemClassLoader(String classLoaderName, String path) {
        this.classLoaderName = classLoaderName;
        this.path = path;
    }

    @Override
    public String toString() {
        return this.classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = readClassFile(name);
        return this.defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] readClassFile(String name) {
        FileInputStream fileInputStream = null;
        byte[] returnBytes = null;

        name = name.replaceAll("\\.", "/");
        String filePath = this.path + name + ".class";
        try {
            fileInputStream = new FileInputStream(filePath);
            returnBytes = new byte[fileInputStream.available()];
            fileInputStream.read(returnBytes);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnBytes;
    }
}
