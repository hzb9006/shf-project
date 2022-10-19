package shfweb.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import shfweb.mapper.UserInfoMapper;
import model.UserInfo;
import org.springframework.stereotype.Service;
import shfweb.service.UserInfoService;

/**
* @author 大饼干
* @description 针对表【user_info(用户表)】的数据库操作Service实现
* @createDate 2022-10-18 16:32:14
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

}




