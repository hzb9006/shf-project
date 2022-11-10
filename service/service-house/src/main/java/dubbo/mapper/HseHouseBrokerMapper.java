package dubbo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import model.HseHouseBroker;
import model.HseHouseImage;
import model.HseHouseUser;

import java.util.List;

/**
* @author 大饼干
* @description 针对表【hse_house_broker(房源经纪人)】的数据库操作Mapper
* @createDate 2022-10-18 16:32:14
* @Entity generator.model.HseHouseBroker
*/
public interface HseHouseBrokerMapper extends BaseMapper<HseHouseBroker> {
    // 根据房源的id查询该房源对应的经纪人
    List<HseHouseBroker> getHouseBrokerByHouseId(Long houseId);


}




