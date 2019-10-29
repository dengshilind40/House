package com.team.house.pcontroller;

import com.team.house.domain.Users;
import com.team.house.utils.sms.SentMsgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller(value = "smsController")
public class SmsController {
    @RequestMapping("sendCode")
    @ResponseBody
    public Map<String,Object> sendCode(String sendPhone,HttpSession session) {
        //随机数
        int randCode = (int) (Math.random() * 10000) ;
        //创建消息
        String msg = "验证码是"+randCode;
        //发送验证码
        int result = SentMsgUtil.sendMsg(sendPhone, msg);
        //将随机数保存在session中
        session.setAttribute("saveCode",randCode);
        Map<String,Object> map=new HashMap<>();
        map.put("result",result);
        return map;
    }

    //登陆验证
    @RequestMapping("login2")

    public String login(String code, HttpSession session){
        //获取session保存的验证码
        Object obj = session.getAttribute("saveCode");
        //比较验证码
        if(code.equals(obj.toString())){
            //重定向跳转到房屋信息的方法中
            return "redirect:getHouseByUser.do";//后台管理
        }else {
            return "login";//登陆页面
        }
    }

}