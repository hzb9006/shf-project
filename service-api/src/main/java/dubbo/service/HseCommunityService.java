package dubbo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import model.HseCommunity;
import model.HseCommunityDto;

import java.util.List;
import java.util.Map;

/**
* @author 大饼干
* @description 针对表【hse_community(小区信息)】的数据库操作Service
* @createDate 2022-10-18 16:32:13
*/
public interface HseCommunityService extends IService<HseCommunity> {

    PageInfo<HseCommunityDto> getAllBypage(Map<String, Object> filters);

    List<HseCommunity> findAll();
}
