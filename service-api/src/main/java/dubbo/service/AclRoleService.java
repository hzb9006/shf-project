package dubbo.service;


import com.baomidou.mybatisplus.extension.service.IService;

import com.github.pagehelper.PageInfo;
import model.AclRole;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
* @author 大饼干
* @description 针对表【acl_role(角色)】的数据库操作Service
* @createDate 2022-10-18 16:32:14
*/
public interface AclRoleService extends IService<AclRole> {

    List<AclRole> finAll();

    void saveEmp(AclRole aclRole);

    void deleteEmp(Integer id);

    void updateEmp(ModelMap model, Integer id);

    void updateSaveEmp(AclRole aclRole);

    PageInfo<AclRole> pageEmp(Map<String, Object> filters);
}
