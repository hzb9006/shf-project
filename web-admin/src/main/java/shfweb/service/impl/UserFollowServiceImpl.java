package shfweb.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import shfweb.mapper.UserFollowMapper;
import model.UserFollow;
import org.springframework.stereotype.Service;
import shfweb.service.UserFollowService;

/**
* @author 大饼干
* @description 针对表【user_follow(用户关注表)】的数据库操作Service实现
* @createDate 2022-10-18 16:32:13
*/
@Service
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, UserFollow>
    implements UserFollowService {

}




