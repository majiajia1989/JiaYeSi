package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.SysCorp;
/**
 * SysCorp对象Dao
 * @author hnhx
 *
 */
@Repository("CorpDao")
public class CorpDao extends BaseDao<SysCorp>{
	private final String GET_CORPS = "from SysCorp";
	public List<SysCorp> queryCorps(){
		return (List<SysCorp>)find(GET_CORPS);
	}
}
