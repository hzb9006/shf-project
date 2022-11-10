package dubbo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import model.HseHouse;
import vo.HouseQueryVo;
import vo.HouseVo;

import java.util.Map;

/**
* @author 大饼干
* @description 针对表【hse_house(房源表)】的数据库操作Service
* @createDate 2022-10-18 16:32:14
*/
public interface HseHouseService extends IService<HseHouse> {

    PageInfo<HseHouse> pageHouse(HseHouse hseHouse, Map<String, Object> filters);

    // 发布或取消发布
    void publish(Long houseId, Integer status);

    HseHouse getByhouseIdWithName(Long houseId);

//    前端分页及其带条件查询的方法
    PageInfo<HouseVo> findPageList(Integer pageNum, Integer pageSize, HouseQueryVo houseQueryVo);
}
