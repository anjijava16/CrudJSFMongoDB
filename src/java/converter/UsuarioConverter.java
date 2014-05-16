/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import com.mongodb.DBObject;
import core.Usuario;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author samuelcatalano
 */
public class UsuarioConverter {

    /**
     * @param usuario
     * @return mapUsuario
     */
    public Map<String, Object> converterToMap(Usuario usuario) {
        Map<String, Object> mapUsuario = new HashMap<String, Object>();
        mapUsuario.put("nome", usuario.getNome());
        mapUsuario.put("sobrenome", usuario.getSobrenome());
        mapUsuario.put("cpf", usuario.getCpf());
        mapUsuario.put("sexo", usuario.getSexo());
        mapUsuario.put("endereco", new EnderecoConverter().converterToMap(usuario.getEndereco()));

        return mapUsuario;
    }

    /**
     * @param dbo
     * @return usuario
     */
    public Usuario converterToUsuario(DBObject dbo) {
        Usuario usuario = new Usuario( );
        usuario.setId(dbo.get("_id").toString());
        usuario.setNome((String) dbo.get("nome"));
        usuario.setSobrenome((String) dbo.get("sobrenome"));
        usuario.setCpf((String) dbo.get("cpf"));
        usuario.setSexo((String) dbo.get("sexo"));
        usuario.setEndereco(new EnderecoConverter().converterToPhone((HashMap<String, Object>) dbo.get("endereco")));

        return usuario;
    }

}
