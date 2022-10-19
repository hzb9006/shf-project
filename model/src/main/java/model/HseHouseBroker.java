package model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 房源经纪人
 * @TableName hse_house_broker
 */
@TableName(value ="hse_house_broker")
@Data
public class HseHouseBroker implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 房源id
     */
    private Long houseId;

    /**
     * 经纪人id
     */
    private Long brokerId;

    /**
     * 经纪人名称
     */
    private String brokerName;

    /**
     * 经纪人头像
     */
    private String brokerHeadUrl;

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
        HseHouseBroker other = (HseHouseBroker) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getBrokerId() == null ? other.getBrokerId() == null : this.getBrokerId().equals(other.getBrokerId()))
            && (this.getBrokerName() == null ? other.getBrokerName() == null : this.getBrokerName().equals(other.getBrokerName()))
            && (this.getBrokerHeadUrl() == null ? other.getBrokerHeadUrl() == null : this.getBrokerHeadUrl().equals(other.getBrokerHeadUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getBrokerId() == null) ? 0 : getBrokerId().hashCode());
        result = prime * result + ((getBrokerName() == null) ? 0 : getBrokerName().hashCode());
        result = prime * result + ((getBrokerHeadUrl() == null) ? 0 : getBrokerHeadUrl().hashCode());
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
        sb.append(", houseId=").append(houseId);
        sb.append(", brokerId=").append(brokerId);
        sb.append(", brokerName=").append(brokerName);
        sb.append(", brokerHeadUrl=").append(brokerHeadUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}