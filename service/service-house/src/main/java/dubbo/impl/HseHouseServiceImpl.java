package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseHouseMapper;
import dubbo.service.HseHouseService;
import model.HseHouse;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 大饼干
 * @description 针对表【hse_house(房源表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class HseHouseServiceImpl extends ServiceImpl<HseHouseMapper, HseHouse>
        implements HseHouseService {

}




