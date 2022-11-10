package dubbo.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dubbo.mapper.HseCommunityMapper;
import dubbo.mapper.HseDictMapper;
import dubbo.service.HseCommunityService;
import dubbo.service.HseDictService;
import model.HseCommunity;
import model.HseCommunityDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import util.CastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author 大饼干
 * @description 针对表【hse_community(小区信息)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:13
 */
@DubboService
public class HseCommunityServiceImpl extends ServiceImpl<HseCommunityMapper, HseCommunity>
        implements HseCommunityService {
    @Autowired
    HseDictService dictService;
    @Autowired
    HseDictMapper dictMapper;


    // todo: 这里使用了filter和CastUtil，如果自己做怎么写？

    /**
     * 分页查询--参数可以是name，区域和板块id三个
     *
     * @param filters
     * @return
     */
    @Override
    public PageInfo<HseCommunityDto> getAllBypage(Map<String, Object> filters) {
        // 1.获取请求的参数
        Object pageNumObj = filters.get("pageNum");
        Object pageSizObj = filters.get("pageSize");
        Object nameObj = filters.get("name");

        // 2. 使用工具类转化类型
        int pageNum = CastUtil.castInt(pageNumObj);
        int pageSize = CastUtil.castInt(pageSizObj);
        String name = CastUtil.castString(nameObj);

        // 3. 开启分页插件
       PageHelper.startPage(pageNum,pageSize);

        // 3 . 紧跟的查询就是一个分页查询-必须紧跟，这样才能保证安全分页, PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象
        LambdaQueryWrapper<HseCommunity> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank("name"),HseCommunity::getName,name);
        queryWrapper.eq(HseCommunity::getIsDeleted,0);
        List<HseCommunity> hseCommunities = this.list(queryWrapper);
        List<HseCommunityDto> CommunityDto =new ArrayList<>();

        // todo: 为了给页面返回区域名字和板块名字，又因为实体类的属性和对应的sql语句是一样的，所以新增一个实体类，后续可以改进，自己写sql，而不是使用Mp生成
        for (HseCommunity hseCommunity : hseCommunities) {
            HseCommunityDto hseCommunityDto = new HseCommunityDto();
            BeanUtils.copyProperties(hseCommunity,hseCommunityDto,"areaName","plateName");
                Long areaId = hseCommunity.getAreaId();
                Long plateId = hseCommunity.getPlateId();
                // 根据id去数据字典里面查询对应的名字
                String areaName = dictMapper.getNameByid(areaId);
                String plateName = dictMapper.getNameByid(plateId);
            hseCommunityDto.setAreaName(areaName);
            hseCommunityDto.setPlateName(plateName);
            CommunityDto.add(hseCommunityDto);
        }


        // 4. 使用pageinfo包装list
        PageInfo<HseCommunityDto> hseCommunityPageInfo = new PageInfo<>(CommunityDto);

        return hseCommunityPageInfo;

    }

    @Override
    public List<HseCommunity> findAll() {
        LambdaQueryWrapper<HseCommunity> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(HseCommunity::getIsDeleted,0);
        List<HseCommunity> list = this.list(queryWrapper);
        return list;
    }
}




