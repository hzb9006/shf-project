package dubbo.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.AclPermissionMapper;
import dubbo.service.AclPermissionService;
import model.AclPermission;
import org.apache.dubbo.config.annotation.DubboService;


/**
 * @author 大饼干
 * @description 针对表【acl_permission(权限)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class AclPermissionServiceImpl extends ServiceImpl<AclPermissionMapper, AclPermission>
        implements AclPermissionService {

}




