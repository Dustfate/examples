package org.examples.spring.util;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;

/**
 * @Title: SqlUtil.java
 * @Package org.examples.spring.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年3月25日 上午11:48:35
 */
public class SqlUtil {

    public static final String DATABSE_TYPE_MYSQL ="mysql";
    public static final String DATABSE_TYPE_ORACLE ="oracle";
    public static final String DATABSE_TYPE_SQLSERVER ="sqlserver";

    /**
     * 分页SQL
     */
    public static final String MYSQL_SQL = "select * from ( {0}) sel_tab00 limit {1},{2}";         //mysql
    public static final String POSTGRE_SQL = "select * from ( {0}) sel_tab00 limit {2} offset {1}";//postgresql
    public static final String ORACLE_SQL = "select * from (select row_.*,rownum rownum_ from ({0}) row_ where rownum <= {1}) where rownum_>{2}"; //oracle
    public static final String SQLSERVER_SQL = "select * from ( select row_number() over(order by tempColumn) tempRowNumber, * from (select top {1} tempColumn = 0, {0}) t ) tt where tempRowNumber > {2}"; //sqlserver

    //add-begin--Author:luobaoli  Date:20150620 for：增加各个数据库获取表的SQL和获取指定表列的SQL
    /**
     * 获取所有表的SQL
     */
    public static final String MYSQL_ALLTABLES_SQL = "select distinct table_name from information_schema.columns where table_schema = {0}";         
    public static final String POSTGRE__ALLTABLES_SQL = "SELECT distinct c.relname AS  table_name FROM pg_class c";
    public static final String ORACLE__ALLTABLES_SQL = "select distinct colstable.table_name as  table_name from user_tab_cols colstable"; 
    public static final String SQLSERVER__ALLTABLES_SQL= "select distinct c.name as  table_name from sys.objects c";
    
    /**
     * 获取指定表的所有列名
     */
    public static final String MYSQL_ALLCOLUMNS_SQL = "select column_name from information_schema.columns where table_name = {0} and table_schema = {1}";
    public static final String POSTGRE_ALLCOLUMNS_SQL = "select table_name from information_schema.columns where table_name = {0}";
    public static final String ORACLE_ALLCOLUMNS_SQL = "select column_name from all_tab_columns where table_name ={0}";
    public static final String SQLSERVER_ALLCOLUMNS_SQL = "select name from syscolumns where id={0}";
    //add-end--Author:luobaoli  Date:20150620 for：增加各个数据库获取表的SQL和获取指定表列的SQL
    /**
     * 获取全sql
     * @param sql
     * @param params
     * @return
     */
    public static String getFullSql(String sql,Map params){
        StringBuilder sqlB =  new StringBuilder();
        sqlB.append("SELECT t.* FROM ( ");
        sqlB.append(sql+" ");
        sqlB.append(") t ");
        if (params!=null&&params.size() >= 1) {
            sqlB.append("WHERE 1=1  ");
            Iterator it = params.keySet().iterator();
            while (it.hasNext()) {
                String key = String.valueOf(it.next());
                String value = String.valueOf(params.get(key));
                if (!StringUtil.isEmpty(value) && !"null".equals(value)) {
                    sqlB.append(" AND ");
                    sqlB.append(" " + key +  value );
                }
            }
        }
        return sqlB.toString();
    }

    /**
     * 获取求数量sql
     * @param sql
     * @param params
     * @return
     */
    public static String getCountSql(String sql, Map params) {
        String querySql = getFullSql(sql,params);
        querySql = "SELECT COUNT(*) FROM ("+querySql+") t2";
        return querySql;
    }

    
    
    private static int getAfterSelectInsertPoint(String sql) {
        int selectIndex = sql.toLowerCase().indexOf("select");
        int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
        return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
    }
    
    //add-begin--Author:luobaoli  Date:20150620 for：增加各个数据库获取表的SQL和获取指定表列的SQL
    public static String getAllTableSql(String dbType,String ... param){
    	if(StringUtil.isNotEmpty(dbType)){
	    	if(dbType.equals(DATABSE_TYPE_MYSQL)){
	    		return MessageFormat.format(MYSQL_ALLTABLES_SQL, param);
	    	}else if(dbType.equals(DATABSE_TYPE_ORACLE)){
	    		return ORACLE__ALLTABLES_SQL;
	    	}else if(dbType.equals(DATABSE_TYPE_SQLSERVER)){
	    		return SQLSERVER__ALLTABLES_SQL;
	    	}
    	}
    	return null;
    }
    
    public static String getAllCloumnSql(String dbType,String ... param){
    	if(StringUtil.isNotEmpty(dbType)){
	    	if(dbType.equals(DATABSE_TYPE_MYSQL)){
	    		return MessageFormat.format(MYSQL_ALLCOLUMNS_SQL, param);
	    	}else if(dbType.equals(DATABSE_TYPE_ORACLE)){
	    		return MessageFormat.format(ORACLE_ALLCOLUMNS_SQL, param);
	    	}else if(dbType.equals(DATABSE_TYPE_SQLSERVER)){
	    		return MessageFormat.format(SQLSERVER_ALLCOLUMNS_SQL, param);
	    	}
    	}
    	return null;
    }
    //add-end--Author:luobaoli  Date:20150620 for：增加各个数据库获取表的SQL和获取指定表列的SQL
}
