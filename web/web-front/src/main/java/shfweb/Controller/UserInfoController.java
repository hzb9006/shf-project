package shfweb.Controller;

import dubbo.service.UserInfoService;
import io.netty.handler.codec.http.HttpRequest;
import model.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import result.ResultCodeEnum;
import util.MD5;
import vo.LoginVo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/userInfo")
@RestController
public class UserInfoController {

    @DubboReference
    UserInfoService userInfoService;

    @RequestMapping("/sendCode/{phoneNum}")
    public Result sendCode(@PathVariable("phoneNum")String phoneNum, HttpServletRequest request){
        // 设置验证码为888
        String code="8888";
        // 将验证码放到session中
        request.getSession().setAttribute("code",code);

        // 将验证码响应给前端
        return Result.ok(code);

    }

    // 登录
    @RequestMapping("/login")
    public Result login(@RequestBody LoginVo loginVo,HttpServletRequest request){
    // 获取用户手机号和密码
        String phone=loginVo.getPhone();
        String password=loginVo.getPassword();
        // 验空
        if (StringUtils.isAllBlank(password) || StringUtils.isAllBlank(password)){
            return Result.build(null, ResultCodeEnum.CODE_ERROR);
        }
        // 根据手机号密码查询用户信息
        UserInfo userInfoByPhone = userInfoService.getUserInfoByPhone(phone);
        if (userInfoByPhone==null){
            // 账户不存在
            return Result.build(null,ResultCodeEnum.ACCOUNT_ERROR);
        }

        // 验证密码是否正确
        if (!MD5.encrypt(password).equals(userInfoByPhone.getPassword())){
            // 密码不正确
            return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }

        // 验证用户是否被禁用
        if (userInfoByPhone.getStatus()==0){
            // 用户已经锁定
            return Result.build(null,ResultCodeEnum.ACCOUNT_LOCK_ERROR);
        }
        // 登录成功
        // 将用户信息放到session域中，目的是为了让后端判断用户是否已经登录
        request.getSession().setAttribute("user",userInfoByPhone);

        // 创建一个map，map中必须存放nickName,前端需要
        Map map=new HashMap();
        map.put("nickName",userInfoByPhone.getNickName());
        map.put("phone",phone);
        return Result.ok(map);
    }
    // 登出
    @RequestMapping("/logout")
    public Result logout(HttpServletRequest request){
        //将session域中的user对象移除
        request.getSession().removeAttribute("user");
        return Result.ok();


    }

}
