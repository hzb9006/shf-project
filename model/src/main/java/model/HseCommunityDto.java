
package model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 小区信息
 * @TableName hse_community
 */

@Data
@Component // todo：为何dto要注入为bean，其他的实体类不需要？
public class HseCommunityDto  extends HseCommunity implements Serializable{
    /**
     * id
     */

    private Long id;

    /**
     * 小区名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 省id：（字典id） 预留字段
     */
    private Long provinceId;

    /**
     * 城市id：（字典id）预留字段
     */
    private Long cityId;

    /**
     * 区域id：（字典id）
     */
    private Long areaId;

    /**
     * 板块id：（字典id）
     */
    private Long plateId;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 经度（预留字段）
     */
    private BigDecimal longitude;

    /**
     * 纬度（预留字段）
     */
    private BigDecimal latitude;

    /**
     * 建筑年代
     */
    private String buildYears;

    /**
     * 物业价格
     */
    private String propertyPrice;

    /**
     * 物业公司
     */
    private String propertyCompany;

    /**
     * 开发商
     */
    private String developer;

    /**
     * 楼栋数
     */
    private Integer buildNum;

    /**
     * 房屋数
     */
    private Integer houseNum;

    /**
     * 均价
     */
    private BigDecimal averagePrice;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记（0:不可用 1:可用）
     */
    private Integer isDeleted;

    // 区域名字--数据库中没有的
    private String areaName;

    // 板块名字--区域中没有的
    private String plateName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HseCommunity other = (HseCommunity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getProvinceId() == null ? other.getProvinceId() == null : this.getProvinceId().equals(other.getProvinceId()))
                && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
                && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
                && (this.getPlateId() == null ? other.getPlateId() == null : this.getPlateId().equals(other.getPlateId()))
                && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
                && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
                && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
                && (this.getBuildYears() == null ? other.getBuildYears() == null : this.getBuildYears().equals(other.getBuildYears()))
                && (this.getPropertyPrice() == null ? other.getPropertyPrice() == null : this.getPropertyPrice().equals(other.getPropertyPrice()))
                && (this.getPropertyCompany() == null ? other.getPropertyCompany() == null : this.getPropertyCompany().equals(other.getPropertyCompany()))
                && (this.getDeveloper() == null ? other.getDeveloper() == null : this.getDeveloper().equals(other.getDeveloper()))
                && (this.getBuildNum() == null ? other.getBuildNum() == null : this.getBuildNum().equals(other.getBuildNum()))
                && (this.getHouseNum() == null ? other.getHouseNum() == null : this.getHouseNum().equals(other.getHouseNum()))
                && (this.getAveragePrice() == null ? other.getAveragePrice() == null : this.getAveragePrice().equals(other.getAveragePrice()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getPlateId() == null) ? 0 : getPlateId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getBuildYears() == null) ? 0 : getBuildYears().hashCode());
        result = prime * result + ((getPropertyPrice() == null) ? 0 : getPropertyPrice().hashCode());
        result = prime * result + ((getPropertyCompany() == null) ? 0 : getPropertyCompany().hashCode());
        result = prime * result + ((getDeveloper() == null) ? 0 : getDeveloper().hashCode());
        result = prime * result + ((getBuildNum() == null) ? 0 : getBuildNum().hashCode());
        result = prime * result + ((getHouseNum() == null) ? 0 : getHouseNum().hashCode());
        result = prime * result + ((getAveragePrice() == null) ? 0 : getAveragePrice().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", areaId=").append(areaId);
        sb.append(", plateId=").append(plateId);
        sb.append(", address=").append(address);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", buildYears=").append(buildYears);
        sb.append(", propertyPrice=").append(propertyPrice);
        sb.append(", propertyCompany=").append(propertyCompany);
        sb.append(", developer=").append(developer);
        sb.append(", buildNum=").append(buildNum);
        sb.append(", houseNum=").append(houseNum);
        sb.append(", averagePrice=").append(averagePrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}