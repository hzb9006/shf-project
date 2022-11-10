package dubbo.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dubbo.mapper.UserFollowMapper;
import dubbo.service.HseDictService;
import dubbo.service.UserFollowService;
import lombok.extern.slf4j.Slf4j;
import model.HseDict;
import model.UserFollow;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import vo.UserFollowVo;

import java.util.List;

/**
 * @author 大饼干
 * @description 针对表【user_follow(用户关注表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:13
 */
@DubboService
@Slf4j
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, UserFollow>
        implements UserFollowService {

    @Autowired
    UserFollowMapper userFollowMapper;

    @DubboReference
    HseDictService dictService;

    @Override
    public void follow(Long id, Long houseId) {
        // 创建userfollow对象
        UserFollow userFollow = new UserFollow();
        userFollow.setUserId(id);
        userFollow.setHouseId(houseId);
        userFollowMapper.insert(userFollow);


    }

    @Override
    public Boolean ifFollow(Long id, long id1) {
        Integer count=userFollowMapper.getcountByuserIdAndHouseId(id,id1);

        if (count==0){
            // 未关注该房源
            return false;
        }
        return true;
    }

    @Override
    public PageInfo<UserFollowVo> findPageList(Integer pageNum, Integer pageSize, Long userId) {
        // 开启分页
        PageHelper.startPage(pageNum,pageSize);
        // 调用分页查询的方法
        Page<UserFollowVo> userFollowVo=userFollowMapper.findPageList(userId);
        log.info("查询到的数据是{}",userFollowVo);
        // 遍历userFollowVo，赋值name
        for (UserFollowVo followVo : userFollowVo) {
            // 根据housetypeid查询到对应的housetypename--查询数据字典，通过id查询到name
            Long houseTypeId = followVo.getHouseTypeId();
            followVo.setHouseTypeName(dictService.getById(houseTypeId).getName());

            Long floorId = followVo.getFloorId();
            followVo.setFloorName(dictService.getById(floorId).getName());

            Long directionId = followVo.getDirectionId();
            followVo.setDirectionName(dictService.getById(directionId).getName());

        }

        // 使用PageInfo包装我们查询的结果并且返回
        return new PageInfo<>(userFollowVo, 3);
    }
}




