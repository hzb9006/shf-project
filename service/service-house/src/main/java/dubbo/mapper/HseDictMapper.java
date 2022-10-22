package dubbo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import model.HseDict;

import java.util.List;

/**
* @author 大饼干
* @description 针对表【hse_dict(组织架构表)】的数据库操作Mapper
* @createDate 2022-10-18 16:32:14
* @Entity generator.model.HseDict
*/
public interface HseDictMapper extends BaseMapper<HseDict> {
    // 和数据库的操作就写在这边,为了练手，此处不使用MybatisPlus，而是使用Mybatis，练习SQL语句
    // 1、根据父id获取下级列表：findListByParentId
    //2、通过父id获取子节点的数量判断是否是父节点
    List<HseDict> findListByParentId(Long parentId);


    // 判断该节点是否为父节点
    Integer countIsParent(Long id);
}




