package dubbo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import model.HseHouseImage;

import java.util.List;

/**
* @author 大饼干
* @description 针对表【hse_house_image(房源图片)】的数据库操作Mapper
* @createDate 2022-10-18 16:32:13
* @Entity generator.model.HseHouseImage
*/
public interface HseHouseImageMapper extends BaseMapper<HseHouseImage> {
    // 根据房源id和房产类型查询房源或者房产图片
    List<HseHouseImage> getHouseImgesByHouseIdAndType(Long houseId,Integer type);


}




