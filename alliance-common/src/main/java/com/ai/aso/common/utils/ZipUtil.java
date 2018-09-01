package com.ai.aso.common.utils;/**
 * Created by DK on 2017/10/19.
 */


import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author dk
 * @create 2017-10-19-16:26
 **/
public class ZipUtil {

    /**
     * 压缩zip
     * @param fileString
     * @return
     */
    public static byte[] zip(String fileString){
        byte[] b = null;
        byte[] data = fileString.getBytes();
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zip = new ZipOutputStream(bos);
            ZipEntry entry = new ZipEntry("zip");
            entry.setSize(data.length);
            zip.putNextEntry(entry);
            zip.write(data);
            zip.closeEntry();
            zip.close();
            b= bos.toByteArray();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  b;
    }

    public static void main(String[] args) {
        String s = "张三";
        byte[] f = zip(s);
        byte[] a = Base64.encodeBase64(f);
        System.out.println(s);
        System.out.println(f.toString());
        System.out.println(a.toString());
    }

}
