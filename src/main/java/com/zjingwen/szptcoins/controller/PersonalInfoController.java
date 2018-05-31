package com.zjingwen.szptcoins.controller;

import com.zjingwen.szptcoins.blockchain.BlockWallet;
import com.zjingwen.szptcoins.pojo.*;
import com.zjingwen.szptcoins.service.*;
import com.zjingwen.szptcoins.utils.ImageUtil;
import com.zjingwen.szptcoins.utils.StringUtil;
import com.zjingwen.szptcoins.utils.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("")
public class PersonalInfoController {

    @Autowired
    UserService userService;
    @Autowired
    PersonalInfoService personalInfoService;
    @Autowired
    MajorService majorService;
    @Autowired
    AcademyService academyService;
    @Autowired
    EstateService estateService;
    @Autowired
    WalletService walletService;

    @RequestMapping("personalInfo")
    public String personalInfo(HttpSession session, Model model) {

        //获取当前登录用户
        User u = (User) session.getAttribute("user");
        PersonalInfo personalInfo = personalInfoService.get(u.getId());

        //获取年级
        int level = personalInfoService.getLevel(personalInfo.getStuNum());
        personalInfo.setLevel(level);
        personalInfoService.update(personalInfo);
        String degree = null;
        switch (level) {
            case 1:
                degree = "大一";
                break;
            case 2:
                degree = "大二";
                break;
            case 3:
                degree = "大三";
                break;
            default:
                degree = "已毕业";
                break;
        }

        //获取学院
        Academy a = academyService.get(personalInfo.getaId());
        String academy = a.getaName();

        //获取专业
        Major m = majorService.get(personalInfo.getmId());
        String majorName = m.getmName();

        //获取学力
        Estate e = estateService.get(u.getId());

        //获得钱包信息
        Wallet wallet=walletService.get(u.getId());


        model.addAttribute("personalInfo", personalInfo);
        model.addAttribute("degree", degree);
        model.addAttribute("academy", academy);
        model.addAttribute("major", majorName);
        model.addAttribute("estate", e);
        model.addAttribute("wallet", wallet);

        return "fore/personalInfo";
    }

    @RequestMapping("forePersonalInfoEdit")
    public String forePersonalInfoEdit(Model model, User user, PersonalInfo personalInfo) {
        User u = userService.get(user.getUsername());
        personalInfo.setuId(u.getId());
        personalInfoService.update(personalInfo);

        model.addAttribute("personalInfo", personalInfo);

        return "redirect:personalInfo";
    }

    @RequestMapping("forePersonalImageEdit")
    public String forePersonalImageEdit(HttpSession session, UploadedImageFile uploadedImageFile) {
        User u = (User) session.getAttribute("user");
        PersonalInfo p = personalInfoService.get(u.getId());
        int stuNum = p.getStuNum();

        String fileName = stuNum + ".jpg";
        String imgFolder = session.getServletContext().getRealPath("img/stuImg");
        File f = new File(imgFolder, fileName);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }


        try {
            uploadedImageFile.getImage().transferTo(f);
            BufferedImage img = ImageUtil.change2jpg(f);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        p.setImg("img/stuImg/" + fileName);
        personalInfoService.update(p);

        return "redirect:personalInfo";
    }
}
