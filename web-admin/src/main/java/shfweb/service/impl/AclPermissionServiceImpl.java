package shfweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import shfweb.mapper.AclPermissionMapper;
import model.AclPermission;
import org.springframework.stereotype.Service;
import shfweb.service.AclPermissionService;

/**
* @author 大饼干
* @description 针对表【acl_permission(权限)】的数据库操作Service实现
* @createDate 2022-10-18 16:32:14
*/
@Service
public class AclPermissionServiceImpl extends ServiceImpl<AclPermissionMapper, AclPermission>
    implements AclPermissionService {

}




