package dubbo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import model.HseDict;

import java.util.List;
import java.util.Map;

/**
* @author 大饼干
* @description 针对表【hse_dict(组织架构表)】的数据库操作Service
* @createDate 2022-10-18 16:32:14
*/
public interface HseDictService extends IService<HseDict> {

    // 返回json格式的List<map> 给前端渲染数据字典
    List<Map<String,Object>> findZnodes(Long id);

    // 根据id获取数据
    public  List<HseDict> findDictByid(Long id);


    // 小区管理: 1. 根据编码dictCode获取dict数据,然后根据查询到的dict数据，获取对应的id，然后根据id查询parent_id=id 的子节点
    public  List<HseDict> findDictByDictCode(String dictCode);


    // 根据父id返回子节点的方法
    List<HseDict> findListByParentIds(Long areaId);
}
