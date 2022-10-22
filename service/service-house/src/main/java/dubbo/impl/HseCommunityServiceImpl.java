package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseCommunityMapper;
import dubbo.service.HseCommunityService;
import model.HseCommunity;
import org.apache.dubbo.config.annotation.DubboService;


/**
 * @author 大饼干
 * @description 针对表【hse_community(小区信息)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:13
 */
@DubboService
public class HseCommunityServiceImpl extends ServiceImpl<HseCommunityMapper, HseCommunity>
        implements HseCommunityService {

}




