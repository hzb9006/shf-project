package dubbo.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dubbo.mapper.HseHouseImageMapper;
import dubbo.service.HseHouseImageService;
import model.HseHouseImage;
import org.apache.dubbo.config.annotation.DubboService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 大饼干
 * @description 针对表【hse_house_image(房源图片)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class HseHouseImageServiceImpl extends ServiceImpl<HseHouseImageMapper, HseHouseImage>
        implements HseHouseImageService {

    @Autowired
    HseHouseImageMapper houseImageMapper;

    @Override
    public List<HseHouseImage> getHouseImgesByHouseIdAndType(Long houseId, Integer type) {
        return houseImageMapper.getHouseImgesByHouseIdAndType(houseId,type);

    }

    @Override
    public void delete(Long id) {
        HseHouseImage hseHouseImage = this.getById(id);
        hseHouseImage.setIsDeleted(1);
        this.updateById(hseHouseImage);
    }
}




