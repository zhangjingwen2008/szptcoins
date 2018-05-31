package com.zjingwen.szptcoins.test;


import com.zjingwen.szptcoins.blockchain.Block;
import com.zjingwen.szptcoins.blockchain.BlockUtils;
import com.zjingwen.szptcoins.utils.Encryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Test {

    private static List<Block> blockChain = new LinkedList<>();

    public static void main(String[] args) throws Exception {


        //创世块
        Block genesisBlock=new Block();
        genesisBlock.setHeight(0);
        genesisBlock.setPreHash("0000000000000000000000000000000000000000000000000000000000000000");
        genesisBlock.setMerkleRoot("4a5e1e4baab89f3a32518a88c31bc87f618f76673e2cc77ab2127b7afdeda33b");
        genesisBlock.setVersion("1");
        genesisBlock.setTimeStamp(Integer.toHexString((int)new Date().getTime()));
        genesisBlock.setBits(Integer.toHexString(486604799));


//        for(long i=1;;i++){
//            genesisBlock.setNonce(String.format("%x",i));
//            String hash= BlockUtils.calHash(genesisBlock);
//
//            if(!BlockUtils.isHashValid(hash,genesisBlock.getBits())){
//                System.out.println("need more work: "+hash+"【"+i+"】"+String.valueOf(i).length());
//            }else{
//                System.out.println("work down! "+hash+"【"+i+"】");
//                genesisBlock.setHash(hash);
//                break;
//            }
//        }

        for(long i=354619875;;i++){
            genesisBlock.setNonce(String.format("%x",i));
            String hash= BlockUtils.calHash(genesisBlock);

//            if(!BlockUtils.isHashValid(hash,genesisBlock.getBits())){
            if(!hash.startsWith("0")){
                System.out.println("need more work: "+hash+"【"+i+"】"+String.valueOf(i).length());
            }else{
                System.out.println("work down! "+"00000000"+hash.substring(1,64)+"【"+i+"】");
                genesisBlock.setHash(hash);
                break;
            }
        }

        blockChain.add(genesisBlock);


    }




}
