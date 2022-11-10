package shfweb.controller;

import dubbo.service.HseHouseImageService;
import lombok.extern.slf4j.Slf4j;
import model.HseHouseImage;
import org.apache.dubbo.config.annotation.DubboReference;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import result.Result;
import util.QiniuUtil;

import java.io.IOException;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/houseImage")
public class HouseImageController {
    @DubboReference
    HseHouseImageService houseImageService;

    // 去上传图片的页面
    @RequestMapping("/uploadShow/{houseId}/{type}")
    public String goUploadPage(@PathVariable("houseId")Long houseId,@PathVariable("type") Long type,ModelMap map){
        // 将房源id和图片类型放到request域中
        map.addAttribute("houseId",houseId);
        map.addAttribute("type",type);
        return "house/upload";
    }

    // 上传图片
    // todo:回顾一下mvc的文件上传和下载
    @RequestMapping("/upload/{houseId}/{type}")
    @ResponseBody // 此处不跳转页面，而是直接返回数据给前端，所以需要此注解
    public Result upload(@PathVariable("houseId")Long houseId, @PathVariable("type") Long type, ModelMap map, @RequestParam("file")MultipartFile[] files){
        try {
        if (files!=null && files.length>0){
             for (MultipartFile file : files) {
                 // 获取字节数组
                 byte[] bytes=file.getBytes();
                 // 获取图片的名字
                 String originalFilename = file.getOriginalFilename();
                 // 通过uuid随机生成字符串作为图片名字
                 String newfilename = UUID.randomUUID().toString();
                 // 通过Qiniuutil工具类上传图片
                 QiniuUtil.upload2Qiniu(bytes,newfilename);

                 // 创建HouseImage对象，往数据库插入图片的数据
                 HseHouseImage hseHouseImage = new HseHouseImage();
                 hseHouseImage.setHouseId(houseId);
                 hseHouseImage.setType(Math.toIntExact(type));
                 hseHouseImage.setImageName(originalFilename);
                 // 设置图片的路径，路径=七牛云的域名+随机生成的图片名字
                 hseHouseImage.setImageUrl("http://rkzg3t7gf.hn-bkt.clouddn.com/"+newfilename);
                 // 调用services保存到数据库
                 houseImageService.save(hseHouseImage);



             } }}
        catch (IOException e) {
                     throw new RuntimeException(e);
                 }






        return Result.ok();

    }

    // 删除房源或者房产图片
    @RequestMapping("/delete/{houseId}/{id}")
    public String delete(@PathVariable("houseId") Long houseId,@PathVariable("id")Long id){
        // 调用serbice中删除的方法
        houseImageService.delete(id);
        return "redirect:/house/"+houseId;
    }
}
