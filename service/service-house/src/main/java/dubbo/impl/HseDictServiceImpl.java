package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseDictMapper;
import dubbo.service.HseDictService;
import lombok.extern.slf4j.Slf4j;
import model.HseDict;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 大饼干
 * @description 针对表【hse_dict(组织架构表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
@Slf4j
public class HseDictServiceImpl extends ServiceImpl<HseDictMapper, HseDict>
        implements HseDictService {

    @Autowired // mapper接口和service接口实现类在一个模块，所以不需要使用dubbo引用
    HseDictMapper dictMapper;

    @Override
    public List<Map<String, Object>> findZnodes(Long id) {
        // 返回数据[{ id:2, isParent:true, name:"随意勾选 2"}]
        //根据id获取子节点数据
        //判断该节点是否是父节点
        //全部权限列表


        //获取子节点数据列表---这是自己写SQL语句
        List<HseDict> listByParentId = dictMapper.findListByParentId(id);

        //构建ztree数据
        // 判断根据父节点id查到的每一个子节点数据是否又是一个父节点--- 这是使用MybatisPlus内置的函数
        List<Map<String,Object>> ZNodes=new ArrayList<>();

//        for (HseDict hseDict : listByParentId) {
//            LambdaQueryWrapper<HseDict> queryWrapper=new LambdaQueryWrapper();
//            queryWrapper.eq(HseDict::getParentId,hseDict.getId());
//            long count = this.count(queryWrapper);
//            Map<String,Object> map=new HashMap<>();
//            map.put("id",hseDict.getId());
//            if (count>0){
//                map.put("isParent",true);
//            }else {
//                map.put("isParent",false);
//            }
//            map.put("name",hseDict.getName());
//            ZNodes.add(map);
//        }
//        return ZNodes;



//       todo: 如果使用以下代码报空指针异常，不知道为啥

        for (HseDict hseDict : listByParentId) {
            Integer count = dictMapper.countIsParent(hseDict.getId());
            Map<String,Object> map=new HashMap<>();
            map.put("id",hseDict.getId());
            if (count>0){
                map.put("isParent",true);
            }else {
                map.put("isParent",false);
            }
            map.put("name",hseDict.getName());
            ZNodes.add(map);
        }
        return ZNodes;



    }

    @Override
    public List<HseDict> findDictByid(Long id) {
        return (List<HseDict>) dictMapper.selectById(id);
    }


    @Override
    public List<HseDict> findDictByDictCode(String dictCode) {
        // 1. 根据dict_code查询对应的数据
        HseDict dictByDictCode = dictMapper.getDictByDictCode(dictCode);
        // 2.查询对应数据的id，并且根据该id，查出parent_id为该id的子节点
        Long id = dictByDictCode.getId();
        List<HseDict> listByParentId = dictMapper.findListByParentId(id);
        return listByParentId;
    }

    @Override
    public List<HseDict> findListByParentIds(Long areaId) {
        return dictMapper.findListByParentIds(areaId);
    }
}




