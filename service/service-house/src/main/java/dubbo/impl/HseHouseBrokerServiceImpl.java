package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseHouseBrokerMapper;
import dubbo.service.HseHouseBrokerService;
import model.HseHouseBroker;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 大饼干
 * @description 针对表【hse_house_broker(房源经纪人)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class HseHouseBrokerServiceImpl extends ServiceImpl<HseHouseBrokerMapper, HseHouseBroker>
        implements HseHouseBrokerService {

}




