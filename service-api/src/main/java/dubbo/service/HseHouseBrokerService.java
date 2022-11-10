package dubbo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import model.HseHouseBroker;
import model.HseHouseImage;
import model.HseHouseUser;

import java.util.List;

/**
* @author 大饼干
* @description 针对表【hse_house_broker(房源经纪人)】的数据库操作Service
* @createDate 2022-10-18 16:32:14
*/
public interface HseHouseBrokerService extends IService<HseHouseBroker> {
    List<HseHouseBroker> getHouseBrokerByHouseId(Long houseId);


    void delete(Long brokerId);
}
