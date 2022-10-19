package shfweb.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import shfweb.mapper.AclAdminMapper;
import model.AclAdmin;
import org.springframework.stereotype.Service;
import shfweb.service.AclAdminService;

/**
* @author 大饼干
* @description 针对表【acl_admin(用户表)】的数据库操作Service实现
* @createDate 2022-10-18 16:32:13
*/
@Service
public class AclAdminServiceImpl extends ServiceImpl<AclAdminMapper, AclAdmin>
    implements AclAdminService {

}




