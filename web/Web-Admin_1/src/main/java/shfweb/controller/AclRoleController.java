package shfweb.controller;


import com.github.pagehelper.PageInfo;
import dubbo.service.AclRoleService;
import model.AclRole;
import org.apache.dubbo.config.annotation.DubboReference;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/role")
@EnableDubbo
public class AclRoleController {
    // 这是一个常量
    public static final String SUCCESS_PAGE="/common/successPage";
    @DubboReference// 由于api的实现类是在service,也就是dubbo的提供者，所以需要使用dubboreference
    AclRoleService aclRoleService;



//    // 查询所有员工并且渲染在页面上--只查询isdelete值为0的数据
//    @GetMapping
//    public String index(ModelMap model){
//        // 1. 调用roleservice中获取所有角色的方法
//        List<AclRole> aclRoles = aclRoleService.finAll();
//
//        model.addAttribute("list",aclRoles);
//        return "/role/index";
//    }

    // 分页及带条件查询
    // todo: 这里有个细节点， @RequestMapping只要请求网站对上就可以执行，不管是什么请求方式，此项目第一页是get方法请求，第二页是post方法请求，所以这里只能执行 @RequestMapping
    @RequestMapping
    public String indexPage(ModelMap model, HttpServletRequest request){
        // 获取请求的参数
        // todo: 仔细查看这个方法以及对应的前端页面,学习pagehelp插件
        Map<String, Object> filters = getFilters(request);
        // 返回page对象,filters包含了请求参数
        PageInfo<AclRole> page = aclRoleService.pageEmp(filters);

        // 将filters放到request域中--前端可以通过filters来获取对应的参数
        model.addAttribute("filters",filters);
        model.addAttribute("page",page);
        return "role/index-copy";



    }



    // 新增员工
    @GetMapping("/create")
    public String create(){
        return   "role/create";
    }


    // 保存新增的员工
    // 这里前端发送的是表单数据而不是json数据，所有不能用@RequestBody注解
    // todo:后续优化业务逻辑，返回统一结果类等,可以学习一下瑞吉外卖的公共字段自动填充
    @PostMapping("/save")
    public String save(AclRole aclRole){
        aclRoleService.saveEmp(aclRole);
        return SUCCESS_PAGE;
    }

    // 删除员工--逻辑删除，isdelete属性设置为1
    @GetMapping( "/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        aclRoleService.deleteEmp(id);
        // 重定向到查询页
        return "redirect:/role";
    }

    // 修改员工数据第一步，根据id查询员工数据
    @GetMapping( "/edit/{id}")
    public String updateEmp(@PathVariable("id") Integer id,ModelMap model){
        aclRoleService.updateEmp(model,id);
        // 重定向到查询页
        return "role/edit";
    }

    // 修改员工第二步，更新保存到数据库
    @PostMapping("/update")
    public String updateSaveEmp(AclRole aclRole){
        aclRoleService.updateSaveEmp(aclRole);
        return SUCCESS_PAGE;
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
