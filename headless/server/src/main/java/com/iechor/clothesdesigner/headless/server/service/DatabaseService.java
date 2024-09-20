package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.DBColumn;
import com.iechor.clothesdesigner.headless.api.pojo.request.DatabaseReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.SqlExecuteReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.DatabaseResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.SemanticQueryResp;
import com.iechor.clothesdesigner.headless.server.pojo.DatabaseParameter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DatabaseService {
    SemanticQueryResp executeSql(String sql, DatabaseResp databaseResp);

    SemanticQueryResp executeSql(SqlExecuteReq sqlExecuteReq, Long id, User user);

    DatabaseResp getDatabase(Long id, User user);

    DatabaseResp getDatabase(Long id);

    Map<String, List<DatabaseParameter>> getDatabaseParameters();

    boolean testConnect(DatabaseReq databaseReq, User user);

    DatabaseResp createOrUpdateDatabase(DatabaseReq databaseReq, User user);

    List<DatabaseResp> getDatabaseList(User user);

    void deleteDatabase(Long databaseId);

    List<String> getDbNames(Long id) throws SQLException;

    List<String> getTables(Long id, String db) throws SQLException;

    List<DBColumn> getColumns(Long id, String db, String table) throws SQLException;

    List<DBColumn> getColumns(Long id, String sql) throws SQLException;
}
