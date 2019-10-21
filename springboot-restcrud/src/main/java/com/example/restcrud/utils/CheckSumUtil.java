package com.example.restcrud.utils;

import com.example.restcrud.enums.CheckSumAlgoType;
import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: hzl
 * @Description: 计算文件Checksum（校验和）工具类
 * 几种计算文件checksum的方法：
    使用java.security.MessageDigest
    使用org.apache.commons.codec.digest.DigestUtils
    使用com.google.common.io.Files.hash
 * @Date: Create in 2019/10/21 10:05
 * @Modified By:
 */
public class CheckSumUtil {
    /*方法一：使用java.security.MessageDigest*/
    public static String genChecksum1(File file, String checkSumAlgo) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(checkSumAlgo);
        messageDigest.update(Files.readAllBytes(file.toPath()));
        byte[] digestBytes = messageDigest.digest();

//        StringBuffer sb = new StringBuffer();
//        for (byte b : digestBytes) {
//            // & 是双目计算符，按位计算，&两边操作数对应位上全为1时，结果的该位值为1。否则该位值为0；
//            //0x开头代表16机制，0xff = 15*16^1+15*16^0=255;0x100=1*16^2+0+0=256
//            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
//        }
        String sb = DatatypeConverter.printHexBinary(digestBytes).toLowerCase();

        return sb.toString();
    }

    /* 方法二：使用org.apache.commons.codec.digest.DigestUtils */
    public static String genChecksum2(File file, CheckSumAlgoType checkSumAlgoType)      throws FileNotFoundException, IOException {
        String checksum = null;
        switch (checkSumAlgoType) {
            case MD5:
                checksum = DigestUtils.md5Hex(new FileInputStream(file));
                break;
            case SHA_1:
                checksum = DigestUtils.sha1Hex(new FileInputStream(file));
                break;
            case SHA_256:
                checksum = DigestUtils.sha256Hex(new FileInputStream(file));
                break;
            case SHA_512:
                checksum = DigestUtils.sha512Hex(new FileInputStream(file));
                break;
            default:
                checksum = DigestUtils.md5Hex(new FileInputStream(file));
        }
        return checksum;
    }

    /**方法三： 使用com.google.common.io.Files.hash */
    public static String genChecksum3(File file, CheckSumAlgoType checkSumAlgoType) throws IOException {

        String checksum = null;
        switch (checkSumAlgoType) {
            case MD5:
                checksum = com.google.common.io.Files.hash(file, Hashing.md5()).toString();
                break;
            case SHA_1:
                checksum = com.google.common.io.Files.hash(file, Hashing.sha1()).toString();
                break;
            case SHA_256:
                checksum = com.google.common.io.Files.hash(file, Hashing.sha256()).toString();
                break;
            case SHA_512:
                checksum = com.google.common.io.Files.hash(file, Hashing.sha512()).toString();
                break;
            default:
                checksum = com.google.common.io.Files.hash(file, Hashing.md5()).toString();
        }
        return checksum;
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        File file = new File("D:\\BaiduNetdiskDownload\\4070\\Adobe Acrobat DC 2018 SP.zip");//
        for (CheckSumAlgoType type : CheckSumAlgoType.values()) {
            System.out.println("采用" + type.getName() + "计算checksum");
            System.out.println(String.format("method=%s,checksum=%s", "genChecksum1", genChecksum1(file, type.getName())));
            System.out.println(String.format("method=%s,checksum=%s", "genChecksum2", genChecksum2(file, type)));
            System.out.println(String.format("method=%s,checksum=%s", "genChecksum3", genChecksum3(file, type)));
            System.out.println();
        }
        //采用MD5计算checksum
        //method=genChecksum1,checksum=d4e2218d5ff9eb08f5cd2da50a81bd3b
        //method=genChecksum2,checksum=d4e2218d5ff9eb08f5cd2da50a81bd3b
        //method=genChecksum3,checksum=d4e2218d5ff9eb08f5cd2da50a81bd3b

        //采用SHA-256计算checksum
        //method=genChecksum1,checksum=aef210c0d84239a2fded24ea45a6d410404aab32ef7f5741eb9bbd957606ddd8
        //method=genChecksum2,checksum=aef210c0d84239a2fded24ea45a6d410404aab32ef7f5741eb9bbd957606ddd8
        //method=genChecksum3,checksum=aef210c0d84239a2fded24ea45a6d410404aab32ef7f5741eb9bbd957606ddd8

        //采用SHA-512计算checksum
        //method=genChecksum1,checksum=4f116d6d34e7d34f53f52756226bf763d70dd3e13f7927b3f09747d78e01e31da01d62a4423146b4fcc85d9df85d5f1a78ef6cded83e744323cb6099e5c75d9b
        //method=genChecksum2,checksum=4f116d6d34e7d34f53f52756226bf763d70dd3e13f7927b3f09747d78e01e31da01d62a4423146b4fcc85d9df85d5f1a78ef6cded83e744323cb6099e5c75d9b
        //method=genChecksum3,checksum=4f116d6d34e7d34f53f52756226bf763d70dd3e13f7927b3f09747d78e01e31da01d62a4423146b4fcc85d9df85d5f1a78ef6cded83e744323cb6099e5c75d9b
        //
        //采用SHA1计算checksum
        //method=genChecksum1,checksum=0556867d09b1832fc50c17a05d447f28f0488637
        //method=genChecksum2,checksum=0556867d09b1832fc50c17a05d447f28f0488637
        //method=genChecksum3,checksum=0556867d09b1832fc50c17a05d447f28f0488637

    }

}
