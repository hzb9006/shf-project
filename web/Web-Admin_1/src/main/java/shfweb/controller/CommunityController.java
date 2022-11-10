package shfweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dubbo.service.HseCommunityService;
import dubbo.service.HseDictService;
import lombok.extern.slf4j.Slf4j;
import model.HseCommunity;
import model.HseCommunityDto;
import model.HseDict;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@Slf4j
@RequestMapping("/community")
public class CommunityController {
    @DubboReference
    HseCommunityService communityService;

    @DubboReference
    HseDictService dictService;

    // 1. 分页带条件查询
     @RequestMapping
    public String index(ModelMap modelMap, HttpServletRequest request){
         // 1 .获取请求的参数
         Map<String, Object> filters = getFilters(request);

         // 2 .将filter放到请求域中
         modelMap.addAttribute("filters",filters);

         // 3. 分页查询
         PageInfo<HseCommunityDto> pageinfo=communityService.getAllBypage(filters);
         // 4. 把pageinfo放到request域中
         modelMap.addAttribute("page",pageinfo);

         // 5. 根据编码获取北京所有的区域
         List<HseDict> areaList = dictService.findDictByDictCode("beijing");
         modelMap.addAttribute("areaList",areaList);

         return "community/index";

     }

// 去新增的页面
    @GetMapping("/create")
    public String goAddpage(Map map){
        // 5. 根据编码获取北京所有的区域
        List<HseDict> areaList = dictService.findDictByDictCode("beijing");
        map.put("areaList",areaList);
        return "community/create";

    }

//    添加小区
    @PostMapping("/save")
    public String save(HseCommunity community){
         // 调用service
        communityService.save(community);
        return "common/successPage";

    }

//    去修改小区的页面
    @GetMapping("/edit/{id}")
    public String goEditPage(@PathVariable("id")Long id, Map map){
        // 根据编码获取北京所有的区域
        List<HseDict> areaList = dictService.findDictByDictCode("beijing");
        map.put("areaList",areaList);

        // 调用communityservice中的查询方法
        HseCommunity community = communityService.getById(id);
        map.put("community",community);
        return "community/edit";

    }

//    更新小区
@PostMapping("/update")
public String updateCommunity(HseCommunity community){
    // 调用service
    communityService.updateById(community);
    return "common/successPage";

}

// 删除小区--isdelete改为1
    @RequestMapping("delete/{id}")
    public String deleteCommunity(@PathVariable("id") Long id){
        HseCommunity byId = communityService.getById(id);
        byId.setIsDeleted(1);
        communityService.updateById(byId);
        return "redirect:/community";

    }






    /**
     * 封装页面提交的分页参数及搜索条件
     * @param request
     * @return
     */
    private Map<String, Object> getFilters(HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();
        Map<String, Object> filters = new TreeMap();
        while(paramNames != null && paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            String[] values = request.getParameterValues(paramName);
            if (values != null && values.length != 0) {
                if (values.length > 1) {
                    filters.put(paramName, values);
                } else {
                    filters.put(paramName, values[0]);
                }
            }
        }
        if(!filters.containsKey("pageNum")) {
            filters.put("pageNum", 1);
        }
        if(!filters.containsKey("pageSize")) {
            filters.put("pageSize", 3);
        }

        return filters;
    }
}
