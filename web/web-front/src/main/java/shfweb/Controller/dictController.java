package shfweb.Controller;

import dubbo.service.HseDictService;
import model.HseDict;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;

import java.util.List;

@RestController
@RequestMapping("/dict")
public class dictController{
    @DubboReference
    HseDictService dictService;

    // 根据编码获取所有子节点
    @RequestMapping("/findListByDictCode/{dictCode}")
    public Result findListByDictCode(@PathVariable("dictCode") String dictCode){
        List<HseDict> dictByDictCode = dictService.findDictByDictCode(dictCode);
        return Result.ok(dictByDictCode);
    }


}
