package com.zwzf.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 对字符串数据进行MD5/SHA1哈希散列运算
 * @author q
 */
public class EntryptUtil {
    /**
     * MD5加密
     *
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String md5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes());
        StringBuilder sb = new StringBuilder();
        byte[] bits = md.digest();
        for (int i = 0; i < bits.length; i++) {
            int a = bits[i];
            if (a < 0) {
                a += 256;
            }
            if (a < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(a));
        }
        return sb.toString();
    }

    public String sha1(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(data.getBytes());
        StringBuffer buf = new StringBuffer();
        byte[] bits = md.digest();
        for (int i = 0; i < bits.length; i++) {
            int a = bits[i];
            if (a < 0) {
                a += 256;
            }
            if (a < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(a));
        }
        return buf.toString();
    }

    public String md5AndSha1(String password) throws NoSuchAlgorithmException {
        return sha1(md5(password));
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        EntryptUtil en = new EntryptUtil();
        String passwd =  en.md5AndSha1("xxx");
        System.out.println(passwd);
        //562bd6bdfb0d60ba000f06cbd5acfa5bad7aff16
    }
}
