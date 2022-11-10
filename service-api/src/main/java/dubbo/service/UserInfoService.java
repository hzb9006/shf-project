package dubbo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import model.UserInfo;

/**
* @author 大饼干
* @description 针对表【user_info(用户表)】的数据库操作Service
* @createDate 2022-10-18 16:32:14
*/
public interface UserInfoService extends IService<UserInfo> {

    UserInfo getUserInfoByPhone(String phone);
}
