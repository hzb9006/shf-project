package dubbo.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseHouseUserMapper;
import dubbo.service.HseHouseUserService;
import model.HseHouseBroker;
import model.HseHouseUser;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 大饼干
 * @description 针对表【hse_house_user(房东信息表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class HseHouseUserServiceImpl extends ServiceImpl<HseHouseUserMapper, HseHouseUser>
        implements HseHouseUserService {

    @Autowired
    HseHouseUserMapper houseUserMapper;

    @Override
    public List<HseHouseUser> getHouseUsersByHouseId(Long houseId) {
        return houseUserMapper.getHouseUsersByHouseId(houseId);
    }

    @Override
    public void delete(Long houseUserId) {
        LambdaQueryWrapper<HseHouseUser> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(HseHouseUser::getHouseId,houseUserId);
        HseHouseUser houseUser = this.getOne(queryWrapper);
        houseUser.setIsDeleted(1);
        // 注意在对查询出来的数据进行更新属性后，要保存到数据库
        this.updateById(houseUser);
    }
}




