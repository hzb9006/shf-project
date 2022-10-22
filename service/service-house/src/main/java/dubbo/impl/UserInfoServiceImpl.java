package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.UserInfoMapper;
import dubbo.service.UserInfoService;
import model.UserInfo;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 大饼干
 * @description 针对表【user_info(用户表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {

}




