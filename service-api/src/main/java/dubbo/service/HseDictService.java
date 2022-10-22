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

}
