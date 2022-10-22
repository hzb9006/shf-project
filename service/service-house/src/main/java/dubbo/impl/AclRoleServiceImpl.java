package dubbo.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dubbo.mapper.AclRoleMapper;
import dubbo.service.AclRoleService;
import model.AclRole;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import util.CastUtil;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;
import java.util.Map;

/**
 * @author 大饼干
 * @description 针对表【acl_role(角色)】的数据库操作Service实现
 * @createDate 2022-10-18 16:32:14
 */
@DubboService
public class AclRoleServiceImpl extends ServiceImpl<AclRoleMapper, AclRole>
        implements AclRoleService {

    @Resource
    private AclRoleMapper aclRoleMapper;

    @Override
    public List<AclRole> finAll() {
        LambdaQueryWrapper<AclRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AclRole::getIsDeleted, 0);
        return aclRoleMapper.selectList(queryWrapper);

    }

    @Override
    public void saveEmp(AclRole aclRole) {

        this.save(aclRole);
    }

    @Override
    public void deleteEmp(Integer id) {
        LambdaQueryWrapper<AclRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AclRole::getId, id);
        AclRole aclRole = this.getOne(queryWrapper);
        aclRole.setIsDeleted(1);
        this.updateById(aclRole);

    }


    @Override
    public void updateEmp(ModelMap model, Integer id) {
        // 1.根据id查询员工数据
        LambdaQueryWrapper<AclRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AclRole::getId, id);
        AclRole aclRole = this.getOne(queryWrapper);
        model.addAttribute("role", aclRole);
    }

    @Override
    public void updateSaveEmp(AclRole aclRole) {
        // 2.把前端修改后的员工数据进行保存
        this.updateById(aclRole);
    }

    @Override
    public PageInfo<AclRole> pageEmp(Map<String, Object> filters) {
        // 获取filter中对应的值
        Object pageNumObject = filters.get("pageNum");
        Object pageSizeObject = filters.get("pageSize");
        Object roleName = filters.get("roleName");

        // 使用工具类转化类型
        int pageNum = CastUtil.castInt(pageNumObject);
        int pageSize = CastUtil.castInt(pageSizeObject);
        String name = CastUtil.castString(roleName);

        // 1. 开启分页插件
        // todo:此处使用的是pagehelper插件，多学习一下，功能比较强大，后续可以考虑怎么使用mybatis的插件（实现分页导航条）
        Page<AclRole> objects = PageHelper.startPage(pageNum, pageSize);

        // 2. 紧跟的查询就是一个分页查询-必须紧跟，这样才能保证安全分页, PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象
        LambdaQueryWrapper<AclRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name), AclRole::getRoleName, name);
        List<AclRole> list = this.list(queryWrapper);

        // 3. 使用PageInfo包装查询后的结果,3是连续显示的条数
        return new PageInfo<>(list, 3);

        // 这是pagehelper的使用注解
        /* pagehelper的使用注解
     * pageInfo对象中属性含义
     * private int pageNum;//当前页码
     * private int pageSize;//设置每页多少条数据
     * private int size;//当前页有多少条数据
     * private int startRow;//当前页码第一条数据的
     * private int endRow;//当前页码的开始条
     * private int pages;//当前页码结束条
     * private int prePage;//上一页（页面链接使用）
     * private int nextPage;//下一页（页面链接使用）
     * private boolean isFirstPage;//是否为第一页
     * private boolean isLastPage;//是否为最后一页
     * private boolean hasPreviousPage;//是否有前一页
     * private boolean hasNextPage;//是否有下一页
     * private int navigatePages;//导航页码数(就是总共有多少页)
     * private int[] navigatePageNums;//导航页码数(就是总共有多少页),可以用来遍历
     * private int navigateFirstPage;//首页号
     * private int navigateLastPage;//尾页号

        @Test
        void test() {
            int pageNum = 1;
            int pageSize = 3;
            //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
            Page<ApArticle> page = PageHelper.startPage(pageNum, pageSize);
            //2.紧跟的查询就是一个分页查询-必须紧跟，这样才能保证安全分页, PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象
            List<ApArticle> articleList = apArticleService.list();
            //3.使用PageInfo包装查询后的结果,3是连续显示的条数
            PageInfo pageInfo = new PageInfo(articleList ,pageSize);
            System.out.println("总记录数：" + pageInfo.getTotal());
            System.out.println("总页数：" + pageInfo.getPages());
            System.out.println("一页的大小：" + pageInfo.getSize());
            System.out.println("是否有前一页：" + pageInfo.isHasPreviousPage());
        }

         */

    }
}




