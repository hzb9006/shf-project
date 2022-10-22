package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseHouseUserMapper;
import dubbo.service.HseHouseUserService;
import model.HseHouseUser;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 大饼干
 * @description 针对表【hse_house_user(房东信息表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class HseHouseUserServiceImpl extends ServiceImpl<HseHouseUserMapper, HseHouseUser>
        implements HseHouseUserService {

}




