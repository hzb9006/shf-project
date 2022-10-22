package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.AclAdminRoleMapper;
import dubbo.service.AclAdminRoleService;
import model.AclAdminRole;
import org.apache.dubbo.config.annotation.DubboService;


/**
 * @author 大饼干
 * @description 针对表【acl_admin_role(用户角色)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class AclAdminRoleServiceImpl extends ServiceImpl<AclAdminRoleMapper, AclAdminRole>
        implements AclAdminRoleService {

}




