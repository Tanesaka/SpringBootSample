package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//DB操作を表すリポジトリに、@Repositoryをつける
@Repository
public class HelloRepository {
	
//	DI（Depency Injection依存性の注入）を行うためのアノテーション@Autowired
//	JdbcTemplateクラスを使えばJDBCを使ってSQLを実行可能
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object>findById(String id) {
		
//		SELECT文(結果をMapへ入れる)
		String query = "SELECT *"
				+" FROM employee"
				+" WHERE id=?";
		
//		検索実行
		Map<String, Object>employee=jdbcTemplate.queryForMap(query, id);
		
		return employee;
	}

}
