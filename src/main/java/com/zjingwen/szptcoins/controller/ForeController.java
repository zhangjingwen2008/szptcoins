package com.zjingwen.szptcoins.controller;

import com.zjingwen.szptcoins.blockchain.BlockWallet;
import com.zjingwen.szptcoins.pojo.Estate;
import com.zjingwen.szptcoins.pojo.PersonalInfo;
import com.zjingwen.szptcoins.pojo.User;
import com.zjingwen.szptcoins.pojo.Wallet;
import com.zjingwen.szptcoins.service.EstateService;
import com.zjingwen.szptcoins.service.PersonalInfoService;
import com.zjingwen.szptcoins.service.UserService;
import com.zjingwen.szptcoins.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class ForeController {

    @Autowired
    UserService userService;
    @Autowired
    PersonalInfoService personalInfoService;
    @Autowired
    EstateService estateService;
    @Autowired
    WalletService walletService;

    @RequestMapping("forehome")
    public String forehome(Model model, HttpSession session) {

        User u = (User) session.getAttribute("user");

        if (u != null) {
            //获得学力power
            Estate e = estateService.get(u.getId());

            //Test:若无estate则初始化
            if(e==null){
                Estate es = new Estate();
                es.setUid(u.getId());
                es.setCoins(0l);
                es.setPower(0l);
                estateService.add(es);
            }

            model.addAttribute("estate", e);
        }

        return "fore/home";
    }

    //注册
    @RequestMapping("foreregister")
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName = "Exception")
    public String register(Model model, User user, PersonalInfo personalInfo) {

        //AC代码
        String username = user.getUsername();
        String password = user.getPassword();
        String mail = personalInfo.getMail();
        username = HtmlUtils.htmlEscape(username);

        user.setUsername(username);
        user.setPassword(password);
        personalInfo.setMail(mail);

        userService.add(user);

        /*
         Estate 个人资产初始化
         */
        User u = userService.get(username);
        Estate e = new Estate();
        e.setUid(u.getId());
        e.setCoins(0l);
        e.setPower(0l);
        estateService.add(e);

        /*
        PersonalInfo 个人信息初始化
         */
        int stu = personalInfoService.getMaxStuNum() + 1;
        personalInfo.setStuNum(stu);
        personalInfo.setStuPass(Integer.toString(stu));
        personalInfo.setmId(1);
        personalInfo.setaId(8);
        personalInfo.setuId((userService.get(username)).getId());
        personalInfoService.add(personalInfo);

        /*
        BlockWallet 个人钱包：生成公钥、私钥、地址
         */
        BlockWallet wallet=new BlockWallet();
        Wallet w=new Wallet();
        w.setPublicKey(wallet.getPublicKey());
        w.setPrivateKey(wallet.getPrivateKey());
        w.setWif(wallet.getPrivateKey_WIF());
        w.setWifCompressed(wallet.getPrivateKey_WIF_compressed());
        w.setBase58(wallet.getPrivateKey_Base58());
        w.setHash160(wallet.getHash160());
        w.setAddress(wallet.getCoinAddress());
        w.setUid(u.getId());
        walletService.add(w);

        return "redirect:registerSuccess";

    }

    @RequestMapping("foreRegistAjax")
    @ResponseBody
    public String foreCheck(@RequestParam String username) {
        username = HtmlUtils.htmlEscape(username);
        boolean isExist = userService.isExist(username);

        if (isExist) {
            return "fail";
        }
        return "success";
    }

    @RequestMapping("forelogin")
    public String forelogin(HttpSession session, Model model, User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        User u = userService.get(username, password);



        if (u == null) {
            String s = "用户名或密码错误";
            model.addAttribute("msg", s);
            return "fore/loginFailed";
        }

        PersonalInfo personalInfo = personalInfoService.get(u.getId());
        session.setAttribute("personalInfo", personalInfo);

        session.setAttribute("user", u);

        return "redirect:forehome";
    }

    @RequestMapping("forelogout")
    public String forelogout(HttpSession session) {
        session.removeAttribute("personalInfo");
        session.removeAttribute("user");
        return "redirect:forehome";
    }


}
