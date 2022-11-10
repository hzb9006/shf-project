package model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 房源表
 * @TableName hse_house
 */
@TableName(value ="hse_house")
@Data
public class HseHouse implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 小区id
     */
    private Long communityId;

    /**
     * 房源名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 总价：万元
     */
    private BigDecimal totalPrice;

    /**
     * 单位价格
     */
    private BigDecimal unitPrice;

    /**
     * 建筑面积
     */
    private BigDecimal buildArea;

    /**
     * 套内面积
     */
    private BigDecimal insideArea;

    /**
     * 户型：（字典id）
     */
    private Long houseTypeId;

    /**
     * 楼层（字典id）
     */
    private Long floorId;

    /**
     * 建筑结构：（字典id）
     */
    private Long buildStructureId;

    /**
     * 朝向：（字典id）
     */
    private Long directionId;

    /**
     * 装修情况：（字典id）
     */
    private Long decorationId;

    /**
     * 房屋用途：（字典id）
     */
    private Long houseUseId;

    /**
     * 电梯比例
     */
    private String elevatorRatio;

    /**
     * 挂牌日期
     */
    private Date listingDate;

    /**
     * 上次交易日期
     */
    private Date lastTradeDate;

    /**
     * 默认图片
     */
    private String defaultImageUrl;

    /**
     * 状态
     */
    private Integer status;

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
        HseHouse other = (HseHouse) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getUnitPrice() == null ? other.getUnitPrice() == null : this.getUnitPrice().equals(other.getUnitPrice()))
            && (this.getBuildArea() == null ? other.getBuildArea() == null : this.getBuildArea().equals(other.getBuildArea()))
            && (this.getInsideArea() == null ? other.getInsideArea() == null : this.getInsideArea().equals(other.getInsideArea()))
            && (this.getHouseTypeId() == null ? other.getHouseTypeId() == null : this.getHouseTypeId().equals(other.getHouseTypeId()))
            && (this.getFloorId() == null ? other.getFloorId() == null : this.getFloorId().equals(other.getFloorId()))
            && (this.getBuildStructureId() == null ? other.getBuildStructureId() == null : this.getBuildStructureId().equals(other.getBuildStructureId()))
            && (this.getDirectionId() == null ? other.getDirectionId() == null : this.getDirectionId().equals(other.getDirectionId()))
            && (this.getDecorationId() == null ? other.getDecorationId() == null : this.getDecorationId().equals(other.getDecorationId()))
            && (this.getHouseUseId() == null ? other.getHouseUseId() == null : this.getHouseUseId().equals(other.getHouseUseId()))
            && (this.getElevatorRatio() == null ? other.getElevatorRatio() == null : this.getElevatorRatio().equals(other.getElevatorRatio()))
            && (this.getListingDate() == null ? other.getListingDate() == null : this.getListingDate().equals(other.getListingDate()))
            && (this.getLastTradeDate() == null ? other.getLastTradeDate() == null : this.getLastTradeDate().equals(other.getLastTradeDate()))
            && (this.getDefaultImageUrl() == null ? other.getDefaultImageUrl() == null : this.getDefaultImageUrl().equals(other.getDefaultImageUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getUnitPrice() == null) ? 0 : getUnitPrice().hashCode());
        result = prime * result + ((getBuildArea() == null) ? 0 : getBuildArea().hashCode());
        result = prime * result + ((getInsideArea() == null) ? 0 : getInsideArea().hashCode());
        result = prime * result + ((getHouseTypeId() == null) ? 0 : getHouseTypeId().hashCode());
        result = prime * result + ((getFloorId() == null) ? 0 : getFloorId().hashCode());
        result = prime * result + ((getBuildStructureId() == null) ? 0 : getBuildStructureId().hashCode());
        result = prime * result + ((getDirectionId() == null) ? 0 : getDirectionId().hashCode());
        result = prime * result + ((getDecorationId() == null) ? 0 : getDecorationId().hashCode());
        result = prime * result + ((getHouseUseId() == null) ? 0 : getHouseUseId().hashCode());
        result = prime * result + ((getElevatorRatio() == null) ? 0 : getElevatorRatio().hashCode());
        result = prime * result + ((getListingDate() == null) ? 0 : getListingDate().hashCode());
        result = prime * result + ((getLastTradeDate() == null) ? 0 : getLastTradeDate().hashCode());
        result = prime * result + ((getDefaultImageUrl() == null) ? 0 : getDefaultImageUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", communityId=").append(communityId);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", buildArea=").append(buildArea);
        sb.append(", insideArea=").append(insideArea);
        sb.append(", houseTypeId=").append(houseTypeId);
        sb.append(", floorId=").append(floorId);
        sb.append(", buildStructureId=").append(buildStructureId);
        sb.append(", directionId=").append(directionId);
        sb.append(", decorationId=").append(decorationId);
        sb.append(", houseUseId=").append(houseUseId);
        sb.append(", elevatorRatio=").append(elevatorRatio);
        sb.append(", listingDate=").append(listingDate);
        sb.append(", lastTradeDate=").append(lastTradeDate);
        sb.append(", defaultImageUrl=").append(defaultImageUrl);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}