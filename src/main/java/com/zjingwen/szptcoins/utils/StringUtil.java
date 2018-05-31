package com.zjingwen.szptcoins.utils;

import org.bouncycastle.jcajce.provider.digest.SHA256;

import java.security.Key;
import java.util.Base64;

public class StringUtil {

    //将Key类型转换为String类型
    public static String getStringFromKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    //10进制转16进制
    public static String toHexString(Integer x){
        return Integer.toHexString(x);
    }

    //16进制转10进制
    public static Integer toIntFromHex(String hex){
        return Integer.parseInt(hex,16);
    }

    //小端格式编码
    public static int toLittleEndian(int a) {
        return (((a & 0xFF) << 24) | (((a >> 8) & 0xFF) << 16) | (((a >> 16) & 0xFF) << 8) | ((a >> 24) & 0xFF));
    }

    //给数字加逗号
    public static String setToken(String decimal){
        int p=0;
        StringBuilder builder=new StringBuilder(decimal);
        for(int i=builder.lastIndexOf(".")-1;i>0;i--){
            p++;
            if(p==3){
                builder.insert(i,",");
                p=0;
            }
        }
        String result=builder.toString();

        //若小数皆为0，则不显示小数位
        int resu=Integer.parseInt(result.substring(result.lastIndexOf('.')+1,result.length()));
        if(resu==0){
            result=result.substring(0,result.lastIndexOf('.'));
        }

        return result;
    }



}
