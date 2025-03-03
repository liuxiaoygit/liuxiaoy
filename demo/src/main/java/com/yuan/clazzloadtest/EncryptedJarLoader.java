package com.yuan.clazzloadtest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec; 
import java.io.ByteArrayOutputStream; 
import java.io.InputStream; 
import java.net.URL; 
import java.net.URLClassLoader; 
import java.util.Enumeration; 
import java.util.jar.JarEntry; 
import java.util.jar.JarFile; 
 
public class EncryptedJarLoader extends URLClassLoader {
    // AES密钥（生产环境应从安全来源获取）
    private static final byte[] KEY = "my-secret-key-123".getBytes();
    
    public EncryptedJarLoader(URL[] urls) {
        super(urls, ClassLoader.getSystemClassLoader().getParent()); 
    }
 
    @Override 
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 将类名转换为文件路径 
            String path = name.replace('.',  '/').concat(".class");
            
            // 遍历所有JAR包查找类文件 
            for (URL url : getURLs()) {
                JarFile jar = new JarFile(url.getFile()); 
                Enumeration<JarEntry> entries = jar.entries(); 
                
                while (entries.hasMoreElements())  {
                    JarEntry entry = entries.nextElement(); 
                    if (entry.getName().equals(path))  {
                        // 读取加密字节流 
                        InputStream is = jar.getInputStream(entry); 
                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                        
                        int nRead;
                        byte[] data = new byte[1024];
                        while ((nRead = is.read(data,  0, data.length))  != -1) {
                            buffer.write(data,  0, nRead);
                        }
                        
                        // AES解密 
                        byte[] encrypted = buffer.toByteArray(); 
                        byte[] decrypted = decrypt(encrypted);
                        
                        // 定义类对象 
                        return defineClass(name, decrypted, 0, decrypted.length); 
                    }
                }
            }
        } catch (Exception e) {
            throw new ClassNotFoundException(name, e);
        }
        return super.findClass(name); 
    }
 
    private byte[] decrypt(byte[] data) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(KEY, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
        cipher.init(Cipher.DECRYPT_MODE,  keySpec);
        return cipher.doFinal(data); 
    }
 
    public static void main(String[] args) throws Exception {
        // 加载加密JAR（示例路径）
        URL jarUrl = new URL("file:///path/to/encrypted.jar"); 
        
        EncryptedJarLoader loader = new EncryptedJarLoader(new URL[]{jarUrl});
        
        // 加载目标类 
        Class<?> clazz = loader.loadClass("com.example.SecretClass"); 
        
        // 反射调用方法 
        Object instance = clazz.getDeclaredConstructor().newInstance(); 
        clazz.getMethod("execute").invoke(instance); 
    }
}