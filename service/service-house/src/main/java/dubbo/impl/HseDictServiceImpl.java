package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseDictMapper;
import dubbo.service.HseDictService;
import model.HseDict;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 大饼干
 * @description 针对表【hse_dict(组织架构表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class HseDictServiceImpl extends ServiceImpl<HseDictMapper, HseDict>
        implements HseDictService {

}




