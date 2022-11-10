package model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 继承 HseHouse 实体类
 * 扩展了属性，为了房源详细信息查询的时候返回一系列数据
 */
@Data
public class HseHouseDto extends HseHouse{
    public String houseTypeName;
    public String floorName;
    public String buildStructureName;
    public String directionName;
    public String decorationName;
    public String houseUseName;








}
