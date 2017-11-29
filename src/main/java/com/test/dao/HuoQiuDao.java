package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.test.entity.huoqiu;

public interface HuoQiuDao {
	
	@Select(value= {"Select project_period,"
			+ "application_time,"
			+ "grant_time,"
			+ "format(principal_apply,2) as principal_apply,"
			+ "format(principal_actual,2) as principal_actual,"
			+ "principal_number,"
			+ "refuse_number,"
			+ "actual_number,"
			+ "term,"
			+ "rate,"
			+ "interest_date,"
			+ "over_interest_date,"
			+ "return_data,"
			+ "format(estimate_principal,2) as estimate_principal,"
			+ "format(actual_principal,2) as actual_principal,"
			+ "format(bond,2) as bond,"
			+ "format(actual_bond,2) as actual_bond,"
			+ "format(service_charge,2) as service_charge,"
			+ "format(interest,2)as interest,"
			+ "format(total,2) as total,"
			+ "format(actual_total_interest,2) as actual_total_interest,"
			+ "format(actual_total_all,2) as actual_total_all,"
			+ "actual_return_date,"
			+ "format(actual_return_amount,2) as actual_return_amount "
			+ "from huoqiu order by application_time asc limit #{page},#{limit} ;"})
	public List<huoqiu> findall(@Param(value = "page")Integer page,@Param(value = "limit")Integer limit);
	
	@Select(value= {"select count(*) from huoqiu;"})
	public int findtotal();
}
