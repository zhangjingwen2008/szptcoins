package com.zjingwen.szptcoins.controller;

import com.zjingwen.szptcoins.blockchain.BlockWallet;
import com.zjingwen.szptcoins.pojo.Wallet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PageController {

    @RequestMapping("registerPage")
    public String registerPage() {
        return "fore/register";
    }

    @RequestMapping("registerSuccess")
    public String registerSuccess() {
        return "fore/registerSuccess";
    }

    @RequestMapping("test")
    public String test(Model model){

        BlockWallet wallet=new BlockWallet();
        String publickey=wallet.getPublicKey();
//        Wallet w=new Wallet();
//        w.setPublicKey(wallet.getPublicKey());
//        w.setPrivateKey(wallet.getPrivateKey());
//        w.setWif(wallet.getPrivateKey_WIF());
//        w.setWifCompressed(wallet.getPrivateKey_WIF_compressed());
//        w.setBase58(wallet.getPrivateKey_Base58());

        model.addAttribute("wallet",wallet);
        model.addAttribute("pub",publickey);

        return "fore/test";
    }
}
