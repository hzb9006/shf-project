package dubbo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import model.HseHouseBroker;
import model.HseHouseImage;
import model.HseHouseUser;

import java.util.List;

/**
* @author 大饼干
* @description 针对表【hse_house_user(房东信息表)】的数据库操作Service
* @createDate 2022-10-18 16:32:14
*/
public interface HseHouseUserService extends IService<HseHouseUser> {

    List<HseHouseUser> getHouseUsersByHouseId(Long houseId);

    void delete(Long houseUserId);
}
