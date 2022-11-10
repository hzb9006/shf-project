package dubbo.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dubbo.mapper.HseDictMapper;
import dubbo.mapper.HseHouseMapper;
import dubbo.service.HseHouseService;
import model.HseCommunityDto;
import model.HseHouse;
import model.HseHouseDto;
import org.apache.dubbo.config.annotation.DubboService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import util.CastUtil;
import vo.HouseQueryVo;
import vo.HouseVo;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author 大饼干
 * @description 针对表【hse_house(房源表)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class HseHouseServiceImpl extends ServiceImpl<HseHouseMapper, HseHouse>
        implements HseHouseService {

    @Autowired
    HseHouseMapper houseMapper;


    @Autowired
    HseDictMapper dictMapper;

    @Override
    public PageInfo<HseHouse> pageHouse(HseHouse hseHouse, Map<String, Object> filters) {
        // 1.获取请求的参数
        Object pageNumObj = filters.get("pageNum");
        Object pageSizObj = filters.get("pageSize");
//        Object nameObj = filters.get("name");



        // 2. 使用工具类转化类型
        int pageNum = CastUtil.castInt(pageNumObj);
        int pageSize = CastUtil.castInt(pageSizObj);
//        String name = CastUtil.castString(nameObj);

        // 3. 开启分页插件
        PageHelper.startPage(pageNum,pageSize);

        // 4.查询--这里使用mybtis
        List<HseHouse> houseMapperAll = houseMapper.findAll(hseHouse);

        // 5. 使用pageInfo 包装查询结果
        PageInfo<HseHouse> pageInfo = new PageInfo<>(houseMapperAll);
        return pageInfo;

    }

    @Override
    public void publish(Long houseId, Integer status) {
        HseHouse hseHouse = new HseHouse();
//        根据id查找对应的数据
        LambdaQueryWrapper<HseHouse> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(HseHouse::getId,houseId);
        HseHouse one = this.getOne(queryWrapper);
        one.setStatus(status);
        this.updateById(one);




    }

    @Override
    public HseHouse getByhouseIdWithName(Long houseId) {
        HseHouse house = this.getById(houseId);

//        注意，导入实体类的时候不需要注入
        HseHouseDto hseHouseDto = new HseHouseDto();
        BeanUtils.copyProperties(house,hseHouseDto);
        // 为housedto设置属性: private String houseTypename;
        hseHouseDto.setHouseTypeName(dictMapper.getNameByid(house.getHouseTypeId()));
        //    private String floorName;
        hseHouseDto.setFloorName(dictMapper.getNameByid(house.getFloorId()));
        //    private String buildStructureName;
        hseHouseDto.setBuildStructureName(dictMapper.getNameByid(house.getBuildStructureId()));
        //    private String directionName;
        hseHouseDto.setDirectionName(dictMapper.getNameByid(house.getDirectionId()));
        //    private String decorationName;
        hseHouseDto.setDecorationName(dictMapper.getNameByid(house.getDecorationId()));
        //    private String houseUseName;
        hseHouseDto.setHouseUseName(dictMapper.getNameByid(house.getHouseUseId()));


        return hseHouseDto;
    }

    @Override
    public PageInfo<HouseVo> findPageList(Integer pageNum, Integer pageSize, HouseQueryVo houseQueryVo) {
        // 开启分页
        PageHelper.startPage(pageNum,pageSize);
        // 前端分页及其带条件查询的方法
        Page<HouseVo> page=houseMapper.findPageList(houseQueryVo);
        // 遍历page
        for (HouseVo houseVo : page) {
            // 获取房屋的类型
            houseVo.setHouseTypeName(dictMapper.getNameByid(houseVo.getHouseTypeId()));

            // 获取楼层
           houseVo.setFloorName(dictMapper.getNameByid(houseVo.getFloorId()));
            // 获取房屋的朝向
            houseVo.setDirectionName(dictMapper.getNameByid(houseVo.getDirectionId()));
        }

        return new PageInfo<>(page,5);// 导航页数
    }
}




