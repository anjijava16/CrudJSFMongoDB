/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import core.Endereco;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author samuelcatalano
 */
class EnderecoConverter {

    public EnderecoConverter() {
        
    }
    
    /**
     * @param endereco
     * @return mapEndereco
     */
    public Map<String, Object> converterToMap(Endereco endereco) {
        Map<String, Object> mapEndereco = new HashMap<String, Object>( );
        mapEndereco.put("rua", endereco.getRua());
        mapEndereco.put("numero", endereco.getNumero());
        mapEndereco.put("bairro", endereco.getBairro());
        mapEndereco.put("complemento", endereco.getComplemento());
 
        return mapEndereco;
    }
 
    /**
     * @param hashMap
     * @return 
     */
    public Endereco converterToPhone(HashMap<String, Object> hashMap) {
        Endereco endereco = new Endereco();
        endereco.setRua((String) hashMap.get("rua"));
        endereco.setNumero((Integer) hashMap.get("numero"));
        endereco.setBairro((String) hashMap.get("bairro"));
        endereco.setComplemento((String) hashMap.get("complemento"));
 
        return endereco;
    }
}