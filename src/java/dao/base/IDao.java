/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.base;

import com.mongodb.DBObject;
import java.util.List;
import java.util.Map;

/**
 *  Interface para todos os DAOs
 * @author samuelcatalano
 */
public interface IDao {

    void save(Map<String, Object> mapEntity);

    void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity);

    void delete(Map<String, Object> mapEntity);

    DBObject findOne(Map<String, Object> mapEntity);

    List<DBObject> findAll();

    List<DBObject> findKeyValue(Map<String, Object> keyValue);
}