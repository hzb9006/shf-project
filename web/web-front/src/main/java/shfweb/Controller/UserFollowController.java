package shfweb.Controller;

import com.github.pagehelper.PageInfo;
import dubbo.service.UserFollowService;
import model.UserFollow;
import model.UserInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.ibatis.annotations.Param;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import vo.UserFollowVo;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/userFollow")
public class UserFollowController {

    @DubboReference
    UserFollowService userFollow;

    @RequestMapping("/auth/follow/{houseId}")
    public Result follow(@PathVariable("houseId") Long houseId, HttpServletRequest request){
        // 获取user对象
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");
        // 调用service层中关注房源的方法
        userFollow.follow(user.getId(),houseId);
        return Result.ok();
    }

    // 查询我的关注
    @RequestMapping("/auth/list/{pageNum}/{pageSize}")
    public Result myFoloow(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize,HttpServletRequest request){
        // 从session域中获取user对象
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");
        Long userId = user.getId();
        // 调用分页查询的方法
        PageInfo<UserFollowVo> pageinfo=userFollow.findPageList(pageNum,pageSize,userId);
        return Result.ok(pageinfo);

    }
}
