/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.core;

import com.mongodb.DBObject;
import converter.UsuarioConverter;
import dao.base.EntityDAO;
import core.Usuario;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samuelcatalano
 */
public class UsuarioDAO extends EntityDAO<Usuario> {

    /**
     * Construtor.
     */
    public UsuarioDAO() {
        super(Usuario.class);
    }
    
    /**
     * Save
     * @param usuario 
     */
    public void save(Usuario usuario) {
        Map<String, Object> mapUsuario = new UsuarioConverter().converterToMap(usuario);
        
        save(mapUsuario);
    }   
    
    /**
     * Update
     * @param oldUsuario
     * @param newUsuario 
     */
    public void update(Usuario oldUsuario, Usuario newUsuario) {
        Map<String, Object> query = new UsuarioConverter().converterToMap(oldUsuario);
        Map<String, Object> map = new UsuarioConverter().converterToMap(newUsuario);
 
        update(query, map);
    }
 
    /**
     * Delete
     * @param usuario 
     */
     public void delete(Usuario usuario) {
        Map<String, Object> map = new UsuarioConverter().converterToMap(usuario);
 
        delete(map);
    }
     
     /**
      * Busca um usuario
      * @param mapKeyValue
      * @return usuario
      */
     public Usuario findUsuario(Map<String, Object> mapKeyValue) {
        DBObject dbObject = findOne(mapKeyValue);
        Usuario usuario = new UsuarioConverter().converterToUsuario(dbObject);
 
        return usuario;
    }
     
     /**
      * Busca todos os usuarios
      * @return usuarios
      */
     public List<Usuario> findUsuarios() {
        List<DBObject> dbObject = findAll( );
        List<Usuario> usuarios = new ArrayList<Usuario>();
 
        for (DBObject dbo : dbObject) {
            Usuario usuario = new UsuarioConverter().converterToUsuario(dbo);
            usuarios.add(usuario);
        }
        
        return usuarios;
    }
     
     /**
      * @param mapKeyValue
      * @return usuarios
      */
     public List<Usuario> findUsuarios(Map<String, Object> mapKeyValue) {
        List<DBObject> dbObject = findKeyValue(mapKeyValue);
 
        List<Usuario> usuarios = new ArrayList<Usuario>();
 
        for (DBObject dbo : dbObject) {
            Usuario usuario = new UsuarioConverter().converterToUsuario(dbo);
            usuarios.add(usuario);
        }
 
        return usuarios;
    }
}