package shfweb.Controller;

import com.github.pagehelper.PageInfo;
import dubbo.service.*;
import model.*;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import vo.HouseQueryVo;
import vo.HouseVo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/house")
public class  HouseController {

    @DubboReference
    private HseHouseService houseService;

    @DubboReference
    HseCommunityService communityService;

    @DubboReference
    HseHouseImageService houseImageService;

    @DubboReference
    HseHouseBrokerService houseBrokerService;

    @DubboReference
    UserFollowService userFollowService;

    // 分页及带条件查询的方法
    @RequestMapping("/list/{pageNum}/{pageSize}")
    public Result findPageList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @RequestBody HouseQueryVo houseQueryVo){
        // 调用houseService中前端分页及其带条件查询的方法
       PageInfo<HouseVo> pageInfo= houseService.findPageList(pageNum,pageSize,houseQueryVo);
       return Result.ok(pageInfo);
    }

    // 查看房源详情
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") long id, HttpServletRequest request){
        // 查询房源信息
        HseHouse house = houseService.getById(id);
        // 查询小区信息
        HseCommunity community = communityService.getById(house.getCommunityId());
        // 获取房源图片
        List<HseHouseImage> houseImage1List = houseImageService.getHouseImgesByHouseIdAndType(id, 1);
        // 获取经纪人
        List<HseHouseBroker> houseBrokerList = houseBrokerService.getHouseBrokerByHouseId(id);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("house",house);
        map.put("community",community);
        map.put("houseImage1List",houseImage1List);
        map.put("houseBrokerList",houseBrokerList);

        // 查看是否关注房源
        Boolean isFollowed=false;
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");
        if (user!=null){
            // 证明已经登录--则查看是否关注该房源
           isFollowed= userFollowService.ifFollow(user.getId(),id);

        }
        map.put("isFollow",isFollowed);
        return Result.ok(map);


    }

}
