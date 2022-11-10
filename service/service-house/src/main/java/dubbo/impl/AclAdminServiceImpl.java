package dubbo.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.AclAdminMapper;
import dubbo.service.AclAdminService;
import model.AclAdmin;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 大饼干
 * @description 针对表【acl_admin(用户表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:13
 */
@DubboService
public class AclAdminServiceImpl extends ServiceImpl<AclAdminMapper, AclAdmin>
        implements AclAdminService {

    @Autowired
    AclAdminMapper aclAdminMapper;
    @Override
    public List<AclAdmin> findAll() {
        return aclAdminMapper.findAll();
}}




