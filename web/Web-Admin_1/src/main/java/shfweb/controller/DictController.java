package shfweb.controller;

import dubbo.service.HseDictService;
import lombok.extern.slf4j.Slf4j;
import model.HseDict;
import org.apache.dubbo.config.annotation.DubboReference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import result.Result;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dict")
@Slf4j
public class DictController {

    @DubboReference
    HseDictService dictService;
    private final static String PAGE_INDEX = "dict/index";

    // 去展示数据字典的页面
    @GetMapping
    public String index(){
        return "dict/index";
    }
    @ResponseBody// 后台返回给前端是json格式的
    @GetMapping("/findZnodes")
    public Result findZnodes(@RequestParam(value = "id",defaultValue = "0") Long id){
        log.info("前端返回的id是："+id);

        // 调用HseDictService根据id查询子节点
        List<Map<String, Object>> serviceZnodes = dictService.findZnodes(id);
        System.out.println("查询到的结果是"+serviceZnodes);
        return Result.ok(serviceZnodes);

    }
    // 根据父id获取所有子节点，回显到小区管理
    @ResponseBody
    @RequestMapping("/findListByParentId/{areaId}")
    public Result findListByParentId(@PathVariable("areaId") Long areaId){
        // 调用dictService中根据父id查询所有子节点的方法
        List<HseDict> listByParentId = dictService.findListByParentIds(areaId);
        return Result.ok(listByParentId);
    }


}
