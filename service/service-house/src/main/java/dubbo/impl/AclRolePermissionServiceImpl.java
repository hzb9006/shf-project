package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.AclRolePermissionMapper;
import dubbo.service.AclRolePermissionService;
import model.AclRolePermission;
import org.apache.dubbo.config.annotation.DubboService;


/**
 * @author 大饼干
 * @description 针对表【acl_role_permission(角色权限)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:13
 */
@DubboService
public class AclRolePermissionServiceImpl extends ServiceImpl<AclRolePermissionMapper, AclRolePermission>
        implements AclRolePermissionService {

}




