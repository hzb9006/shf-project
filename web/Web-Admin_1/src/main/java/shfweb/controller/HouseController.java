package shfweb.controller;

import com.github.pagehelper.PageInfo;
import dubbo.service.*;
import lombok.extern.slf4j.Slf4j;
import model.*;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/house")
public class HouseController extends indexController{
    @DubboReference
    HseHouseService houseService;

    @DubboReference
    HseCommunityService communityService;

    @DubboReference
    HseDictService dictService;

    @DubboReference
    HseHouseBrokerService hseHouseBrokerService;

    @DubboReference
    HseHouseImageService hseHouseImageService;

    @DubboReference
    HseHouseUserService hseHouseUserService;




    // 分页带条件查询
    @RequestMapping
    public String index(ModelMap map, HttpServletRequest request,HseHouse hseHouse){
        // 1.通过自己封装的getfilter获取分页请求的参数,pageNum和paheSize和参数名等
        Map<String, Object> filters = getFilters(request);
        // 2.把这些参数放入请求域
        map.addAttribute("filters",filters);

        // 3.调用service进行分页查询
       PageInfo<HseHouse> pageInfo= houseService.pageHouse(hseHouse,filters);

       // 4.放到请求域
        map.addAttribute("page",pageInfo);

        // 5. 获取所有的小区
        List<HseCommunity> communityList=communityService.findAll();

        // 6. 获取所有的户型--从dict表获取，其中父id=1000的是户型信息
        List<HseDict> houseTypeList = dictService.findDictByDictCode("houseType");

        // 7. 获取所有的楼层
        List<HseDict> floorList = dictService.findDictByDictCode("floor");

        // 8.获取建筑结构
        List<HseDict> buildStructureList = dictService.findDictByDictCode("buildStructure");

        // 9. 获取朝向
        List<HseDict> directionList = dictService.findDictByDictCode("direction");

        // 10. 获取装修情况
        List<HseDict> decorationList = dictService.findDictByDictCode("decoration");

        // 11. 获取房屋用途
        List<HseDict> houseUseList = dictService.findDictByDictCode("houseUse");

        // 将以上信息放到request域中
        map.addAttribute("communityList",communityList);
        map.addAttribute("houseTypeList",houseTypeList);
        map.addAttribute("floorList",floorList);
        map.addAttribute("buildStructureList",buildStructureList);
        map.addAttribute("directionList",directionList);
        map.addAttribute("decorationList",decorationList);
        map.addAttribute("houseUseList",houseUseList);
        return "house/index";
    }

//     去添加的页面
    @RequestMapping("/create")
    public String goAddpage(ModelMap map){
        // 5. 获取所有的小区
        List<HseCommunity> communityList=communityService.findAll();

        // 6. 获取所有的户型--从dict表获取，其中父id=1000的是户型信息
        List<HseDict> houseTypeList = dictService.findDictByDictCode("houseType");

        // 7. 获取所有的楼层
        List<HseDict> floorList = dictService.findDictByDictCode("floor");

        // 8.获取建筑结构
        List<HseDict> buildStructureList = dictService.findDictByDictCode("buildStructure");

        // 9. 获取朝向
        List<HseDict> directionList = dictService.findDictByDictCode("direction");

        // 10. 获取装修情况
        List<HseDict> decorationList = dictService.findDictByDictCode("decoration");

        // 11. 获取房屋用途
        List<HseDict> houseUseList = dictService.findDictByDictCode("houseUse");

        // 将以上信息放到request域中
        map.addAttribute("communityList",communityList);
        map.addAttribute("houseTypeList",houseTypeList);
        map.addAttribute("floorList",floorList);
        map.addAttribute("buildStructureList",buildStructureList);
        map.addAttribute("directionList",directionList);
        map.addAttribute("decorationList",decorationList);
        map.addAttribute("houseUseList",houseUseList);
        return "house/create";
    }

    // 添加房源
    @RequestMapping("/save")
    public String save(HseHouse hseHouse){
        // 调用service中的方法
        houseService.save(hseHouse);
        return "common/successPage";
    }

    // 去修改的页面
    @RequestMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id,ModelMap map,HttpServletRequest request){
        HseHouse houseServiceById = houseService.getById(id);
        map.addAttribute("house",houseServiceById);
        // 将小区和数据字典中的数据放到request域中
        setRequestAttribute(map);
        return "house/edit";
    }

    // 修改
    @RequestMapping("/update")
    public String update(HseHouse hseHouse){
        // 调用service中的方法
        houseService.updateById(hseHouse);
        return "common/successPage";
    }

    // 删除
    @RequestMapping("delete/{id}")
    public String deleteCommunity(@PathVariable("id") Long id){
        HseHouse byId = houseService.getById(id);
        byId.setIsDeleted(1);
        houseService.updateById(byId);
        return "redirect:/house";

    }

//    发布
    @RequestMapping("/publish/{houseId}/{status}")
    public String publish(@PathVariable("houseId") Long houseId,@PathVariable("status") Integer status){
         // 调用service中的发布或者取消发布的方法
        houseService.publish(houseId,status);
        return "redirect:/house";
    }

//    查看房源详情
    @RequestMapping("/{houseId}")
    public String show(@PathVariable("houseId") Long houseId,ModelMap map){
        // 1, 根据houseId查询房源信息
        HseHouse house = houseService.getByhouseIdWithName(houseId);
        // 将房源信息放到request域中
        map.addAttribute("house",house);

        // 2. 调用community中查询小区的--根据小区id
        Long communityId = house.getCommunityId();
        HseCommunity community = communityService.getById(communityId);

        // 将小区信息放到request域中
        map.addAttribute("community",community);

        // 查询房源图片
        List<HseHouseImage> houseImage1List = hseHouseImageService.getHouseImgesByHouseIdAndType(houseId, 1);
        map.addAttribute("houseImage1List",houseImage1List);

        // 查询房产图片
        List<HseHouseImage> houseImage2List = hseHouseImageService.getHouseImgesByHouseIdAndType(houseId, 0);
        map.addAttribute("houseImage2List",houseImage2List);

        // 查询经纪人
        List<HseHouseBroker> houseBrokerList = hseHouseBrokerService.getHouseBrokerByHouseId(houseId);
        map.addAttribute("houseBrokerList",houseBrokerList);

        // 查询房东
        List<HseHouseUser> houseUserList = hseHouseUserService.getHouseUsersByHouseId(houseId);
        map.addAttribute("houseUserList",houseUserList);



        return "house/show";
    }


//    获取所有小区及其数据字典中数据并且放到request域中
    public void setRequestAttribute(ModelMap map ){
        // 5. 获取所有的小区
        List<HseCommunity> communityList=communityService.findAll();

        // 6. 获取所有的户型--从dict表获取，其中父id=1000的是户型信息
        List<HseDict> houseTypeList = dictService.findDictByDictCode("houseType");

        // 7. 获取所有的楼层
        List<HseDict> floorList = dictService.findDictByDictCode("floor");

        // 8.获取建筑结构
        List<HseDict> buildStructureList = dictService.findDictByDictCode("buildStructure");

        // 9. 获取朝向
        List<HseDict> directionList = dictService.findDictByDictCode("direction");

        // 10. 获取装修情况
        List<HseDict> decorationList = dictService.findDictByDictCode("decoration");

        // 11. 获取房屋用途
        List<HseDict> houseUseList = dictService.findDictByDictCode("houseUse");

        // 将以上信息放到request域中
        map.addAttribute("communityList",communityList);
        map.addAttribute("houseTypeList",houseTypeList);
        map.addAttribute("floorList",floorList);
        map.addAttribute("buildStructureList",buildStructureList);
        map.addAttribute("directionList",directionList);
        map.addAttribute("decorationList",decorationList);
        map.addAttribute("houseUseList",houseUseList);
    }





}
