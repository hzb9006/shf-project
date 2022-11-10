package dubbo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import model.HseHouse;
import org.apache.ibatis.annotations.Param;
import vo.HouseQueryVo;
import vo.HouseVo;

import java.util.List;

/**
* @author 大饼干
* @description 针对表【hse_house(房源表)】的数据库操作Mapper
* @createDate 2022-10-18 16:32:14
* @Entity generator.model.HseHouse
*/
public interface HseHouseMapper extends BaseMapper<HseHouse> {

    List<HseHouse> findAll(HseHouse hseHouse);


    Page<HouseVo> findPageList(@Param(value = "houseQueryVo") HouseQueryVo houseQueryVo); // 此处必须加上注解，否则有bug
}




