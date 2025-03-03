package com.yuan.clazzloadtest;// FILEPATH: jar://C:/Program Files/Java/jdk1.8.0_172/src.zip!/java/lang/ClassLoader.java

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

// 自定义类加载器，用于解密并加载加密的 JAR 文件
class DecryptingClassLoader extends URLClassLoader {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private final byte[] key;

    // 构造函数，接收 JAR 文件的 URL 数组和加密密钥
    public DecryptingClassLoader(URL[] urls, byte[] key) {
        super(urls, ClassLoader.getSystemClassLoader());
        this.key = key;
    }

    // 重写 findClass 方法，用于查找并加载类
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 将类名转换为 JAR 中的路径
            String path = name.replace('.', '/').concat(".class");
            // 遍历所有 JAR 文件
            for (URL url : getURLs()) {
                // 打开 JAR 文件
                try (JarFile jarFile = new JarFile(new File(url.toURI()))) {
                    // 获取 JAR 中的类条目
                    JarEntry entry = jarFile.getJarEntry(path);
                    if (entry != null) {
                        // 读取加密的类数据
                        try (InputStream is = jarFile.getInputStream(entry)) {
                            byte[] encryptedBytes = readAllBytes(is);
                            // 解密类数据
                            //byte[] decryptedBytes = decrypt(encryptedBytes);
                            // 定义类
                           // return defineClass(name, decryptedBytes, 0, decryptedBytes.length);
                            return defineClass(name, encryptedBytes, 0, encryptedBytes.length);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new ClassNotFoundException(name, e);
        }
        return super.findClass(name);
    }

    // 读取输入流中的所有字节
    private byte[] readAllBytes(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }

    // 解密方法，使用 AES 算法
    private byte[] decrypt(byte[] encryptedBytes) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedBytes);
    }

    // 新增方法，用于获取 JAR 包中所有类的路径
    public java.util.List<String> getAllClassPaths() {
        java.util.List<String> classPaths = new java.util.ArrayList<>();
        for (URL url : getURLs()) {
            try (JarFile jarFile = new JarFile(new File(url.toURI()))) {
                java.util.Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry entry = entries.nextElement();
                    if (entry.getName().endsWith(".class")) {
                        String classPath = entry.getName().replace('/', '.').substring(0, entry.getName().length() - 6);
                        classPaths.add(classPath);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return classPaths;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        // 加密密钥，需要和加密时使用的密钥一致
        byte[] key = "0123456789abcdef".getBytes();
        // 加密的 JAR 文件路径
        URL jarUrl = new File("D:\\java\\gitCode\\liuxiaoy\\demo\\target\\demo-1.0-SNAPSHOT.jar").toURI().toURL();
        // 创建自定义类加载器
        DecryptingClassLoader classLoader = new DecryptingClassLoader(new URL[]{jarUrl}, key);
        // 加载类
        List<String> allClassPaths = classLoader.getAllClassPaths();
        for (String allClassPath : allClassPaths) {
            try {
                Class<?> clazz = classLoader.loadClass(allClassPath);
                // 创建类的实例
                Object instance = clazz.getDeclaredConstructor().newInstance();
                // 调用类的方法
                clazz.getMethod("yourMethod").invoke(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
