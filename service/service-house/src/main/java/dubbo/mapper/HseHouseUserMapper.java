package dubbo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import model.HseHouseUser;

import java.util.List;

/**
* @author 大饼干
* @description 针对表【hse_house_user(房东信息表)】的数据库操作Mapper
* @createDate 2022-10-18 16:32:14
* @Entity generator.model.HseHouseUser
*/
public interface HseHouseUserMapper extends BaseMapper<HseHouseUser> {
    // 根据房源id查询该房源的房东
    List<HseHouseUser> getHouseUsersByHouseId(Long houseId);


}




