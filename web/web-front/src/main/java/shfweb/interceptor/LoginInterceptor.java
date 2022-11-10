package shfweb.interceptor;

import model.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import result.Result;
import result.ResultCodeEnum;
import util.WebUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 重写preHandle方法，会在执行相应的controller层的方法执行进行判断和拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取session域中的user对象，来判断是否登录了
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");
        if (user==null){
            // 证明还没有登录
            Result<String> result = Result.build("还没登录", ResultCodeEnum.LOGIN_AUTH);
            // 使用工具类把对象转化为json，并且响应给前端
            WebUtil.writeJSON(response,result);
            return false;
        }



        return true;
    }
}
