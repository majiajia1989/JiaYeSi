package com.e1858.wuye.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.pojo.SubscriberInfo;

/**
 * User对象Dao
 */
@Repository("subscriberDao")
public class SubscriberDao extends BaseDao<Subscriber>
{
	private final String QUERY_BY_OPENID = HQL_FROM + " u where u.openid = ?";
	//private final String UPDATE_USERINFO = " update Subscriber u set u.carNumber=?,u.mobilePhone=?,u.gender=?,u.telePhone=? where u.openid = ?";

	public Subscriber querySubscriberByOpenId(String openId)
	{
		return get(QUERY_BY_OPENID, openId);
	}

	public SubscriberInfo querySubscriberInfoByopenId(String openid)
	{
		SubscriberInfo result = new SubscriberInfo();
		StringBuilder sql = new StringBuilder();
		sql.append(" select a.openid,a.corp,(select name from t_SysCorp where id=a.corp) as corpName,");
		sql.append(" a.community,(select name from t_Community where id=a.community) as communityName,");
		sql.append(" b.house,(select name from t_House where id=b.house) as houseName,");
		sql.append(" b.houseUnit,(select name from t_HouseUnit where id=b.houseUnit) as houseUnitName,");
		sql.append(" b.houseFloor,(select name from t_HouseFloor where id=b.houseFloor) as houseFloorName,");
		sql.append(" b.houseRoom,(select name from t_HouseRoom where id=b.houseRoom) as houseRoomName");
		sql.append(" from t_Subscriber a inner join t_SubscriberHouse b on a.openid=b.openid ");
		sql.append(" where a.openid=?");
		
		ArrayList<Object> params = new ArrayList<Object>();

		params.add(openid);

		for (Map map : (List<Map>) createSqlQuery(sql.toString(), params).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list())
		{
			result.setOpenid(map.get("openid").toString());
			result.setCorp(Long.parseLong(map.get("corp").toString()));
			result.setCorpName(map.get("corpName").toString());
			result.setCommunity(Long.parseLong(map.get("community").toString()));
			result.setCommunityName(map.get("communityName").toString());
			result.setHouse(Long.parseLong(map.get("house").toString()));
			result.setHouseName(map.get("houseName").toString());
			result.setHouseUnit(Long.parseLong(map.get("houseUnit").toString()));
			result.setHouseUnitName(map.get("houseUnitName").toString());
			result.setHouseFloor(Long.parseLong(map.get("houseFloor").toString()));
			result.setHouseFloorName(map.get("houseFloorName").toString());
			result.setHouseRoom(Long.parseLong(map.get("houseRoom").toString()));
			result.setHouseRoomName(map.get("houseRoomName").toString());
		}
		return result;
	}
}
