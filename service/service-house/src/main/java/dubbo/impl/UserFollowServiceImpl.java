package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.UserFollowMapper;
import dubbo.service.UserFollowService;
import model.UserFollow;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 大饼干
 * @description 针对表【user_follow(用户关注表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:13
 */
@DubboService
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, UserFollow>
        implements UserFollowService {

}




