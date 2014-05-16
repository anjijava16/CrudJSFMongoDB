/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.base;

import com.mongodb.DB;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuelcatalano
 */
public final class MongoConnection {

    private static MongoConnection instance;
    private Mongo mongo;
    private DB db;
    
    /**
     * Singleton
     */
    private MongoConnection() {
        // privado
    }

    /**
     * @return instance
     */
    public static MongoConnection getInstance() {
        if (instance == null) {
            instance = new MongoConnection();
        }
        return instance;
    }

    /**
     * @return db
     */
    public DB getDB( ) {
        if (mongo == null) {
            try {
                mongo = new Mongo("localhost", 27017);
                db = mongo.getDB("crudbasico");
            } catch (UnknownHostException e) {
                Logger.getLogger(MongoConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return db;
    }
}