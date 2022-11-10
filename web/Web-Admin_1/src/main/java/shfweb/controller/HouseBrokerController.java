package shfweb.controller;

import dubbo.service.AclAdminService;
import dubbo.service.HseHouseBrokerService;
import lombok.extern.slf4j.Slf4j;
import model.AclAdmin;
import model.HseHouseBroker;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/houseBroker")
@Controller
@Slf4j
public class HouseBrokerController {
    @DubboReference
    private AclAdminService adminService;

    @DubboReference
    HseHouseBrokerService houseBrokerService;

     // 去添加经纪人的页面
    @RequestMapping("/create")
    public String goAddPage(@RequestParam("houseId") Long houseId, ModelMap map){
        // 将房源id放到request域中
        map.addAttribute("houseId",houseId);

        // 获取所有的用户--调用AdminService中获取所有用户的方法
        List<AclAdmin> adminList=adminService.findAll();
        map.addAttribute("adminList",adminList);

        return "houseBroker/create";

    }

    // 保存经纪人
    @RequestMapping("/save")
    public String save(HseHouseBroker houseBroker){
        // 根据经纪人的id查询经纪人的信息
        AclAdmin admin = adminService.getById(houseBroker.getBrokerId());
        houseBroker.setBrokerName(admin.getName());
        houseBroker.setBrokerHeadUrl(admin.getHeadUrl());

        // 保存
        houseBrokerService.save(houseBroker);

        return "common/successPage";


    }

    // 去修改经纪人的页面
    @RequestMapping("/edit/{id}")
    public String goAddpage(@PathVariable("id") Long id,ModelMap map){
        HseHouseBroker broker = houseBrokerService.getById(id);
        map.addAttribute("houseBroker",broker);
        // 获取所有的用户--调用AdminService中获取所有用户的方法
        List<AclAdmin> adminList=adminService.findAll();
        map.addAttribute("adminList",adminList);

        return "houseBroker/edit";

    }

    // 更新经纪人
    @RequestMapping("/update")
    public String update(HseHouseBroker houseBroker){
        // 根据经纪人的id查询经纪人的信息
        AclAdmin admin = adminService.getById(houseBroker.getBrokerId());
        houseBroker.setBrokerName(admin.getName());
        houseBroker.setBrokerHeadUrl(admin.getHeadUrl());

        // 更新
        houseBrokerService.updateById(houseBroker);
        return "common/successPage";

    }

    // 删除
    @RequestMapping("/delete/{houseId}/{brokerId}")
    public String delete(@PathVariable("houseId")Long houseId,@PathVariable("brokerId")Long brokerId){
        // 调用删除方法
        houseBrokerService.delete(brokerId);
        // 重定向到查询房源详情的方法
        return "redirect:/house/"+houseId;
    }

}
