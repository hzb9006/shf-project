package dubbo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import model.UserFollow;
import vo.UserFollowVo;

/**
* @author 大饼干
* @description 针对表【user_follow(用户关注表)】的数据库操作Service
* @createDate 2022-10-18 16:32:13
*/
public interface UserFollowService extends IService<UserFollow> {
    // 关注房源
    void follow(Long id, Long houseId);


    Boolean ifFollow(Long id, long id1);

    PageInfo<UserFollowVo> findPageList(Integer pageNum, Integer pageSize, Long userId);
}
