package dubbo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import model.UserFollow;
import org.apache.ibatis.annotations.Param;
import vo.UserFollowVo;

import java.util.List;

/**
* @author 大饼干
* @description 针对表【user_follow(用户关注表)】的数据库操作Mapper
* @createDate 2022-10-18 16:32:13
* @Entity generator.model.UserFollow
*/
public interface UserFollowMapper extends BaseMapper<UserFollow> {

    Integer getcountByuserIdAndHouseId(@Param("userId") Long id, @Param("houseId") long id1);

    Page<UserFollowVo> findPageList(@Param("userId") Long userId);
}




