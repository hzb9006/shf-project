package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseHouseImageMapper;
import dubbo.service.HseHouseImageService;
import model.HseHouseImage;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 大饼干
 * @description 针对表【hse_house_image(房源图片)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class HseHouseImageServiceImpl extends ServiceImpl<HseHouseImageMapper, HseHouseImage>
        implements HseHouseImageService {

}




