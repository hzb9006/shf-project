package dubbo.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseHouseBrokerMapper;
import dubbo.service.HseHouseBrokerService;
import model.HseHouseBroker;
import org.apache.dubbo.config.annotation.DubboService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 大饼干
 * @description 针对表【hse_house_broker(房源经纪人)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class HseHouseBrokerServiceImpl extends ServiceImpl<HseHouseBrokerMapper, HseHouseBroker>
        implements HseHouseBrokerService {

    @Autowired
    HseHouseBrokerMapper houseBrokerMapper;

    @Override
    public List<HseHouseBroker> getHouseBrokerByHouseId(Long houseId) {
       return houseBrokerMapper.getHouseBrokerByHouseId(houseId);
    }

    @Override
    public void delete(Long brokerId) {
        LambdaQueryWrapper<HseHouseBroker> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(HseHouseBroker::getId,brokerId);
        HseHouseBroker hseHouseBroker = this.getOne(queryWrapper);
        hseHouseBroker.setIsDeleted(1);
        // 注意在对查询出来的数据进行更新属性后，要保存到数据库
        this.updateById(hseHouseBroker);

    }
}




