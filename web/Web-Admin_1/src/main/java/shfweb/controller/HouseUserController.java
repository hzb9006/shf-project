package shfweb.controller;

import dubbo.service.AclAdminService;
import dubbo.service.HseHouseBrokerService;
import dubbo.service.HseHouseUserService;
import model.AclAdmin;
import model.HseHouseBroker;
import model.HseHouseUser;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/houseUser")
public class HouseUserController {
    @DubboReference
    private HseHouseUserService houseUserService;

    @DubboReference
    HseHouseBrokerService houseBrokerService;

    // 去添加房东的页面
    @RequestMapping("/create")
    public String goAddPage(@RequestParam("houseId") Long houseId, ModelMap map){
        // 将房源id放到request域中
        map.addAttribute("houseId",houseId);

        return "houseUser/create";

    }

    // 添加房东
    @RequestMapping("/save")
    public String save(HseHouseUser houseUser){
       houseUserService.save(houseUser);

        return "common/successPage";


    }

    // 去修改房东的页面
    @RequestMapping("/edit/{id}")
    public String goAddpage(@PathVariable("id") Long id, ModelMap map){
        HseHouseUser houseUser = houseUserService.getById(id);
        map.addAttribute("houseUser",houseUser);

        return "houseBroker/edit";

    }

    // 更新房东
    @RequestMapping("/update")
    public String update(HseHouseUser houseUser){
        // 根据经纪人的id查询经纪人的信息
        houseUserService.updateById(houseUser);
        return "common/successPage";

    }

    // 删除
    @RequestMapping("/delete/{houseId}/{houseUserId}")
    public String delete(@PathVariable("houseId")Long houseId,@PathVariable("houseUserId")Long houseUserId){
        // 调用删除方法
        houseUserService.delete(houseUserId);
        // 重定向到查询房源详情的方法
        return "redirect:/house/"+houseId;
    }

}
