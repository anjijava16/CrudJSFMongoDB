package core;

import dao.core.UsuarioDAO;
import java.util.HashMap;
import java.util.Map;
import javax.faces.view.facelets.FaceletContext;
import org.junit.Test;

/**
 *
 * @author samuelcatalano
 */
public class UsuarioTest {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Test
    public void saveUsuario( ) {
        Endereco e = new Endereco("Rua Alagoas", 515, "Higienopolis", "Ap. 36");
        Usuario usuario = new Usuario("Samuel", "Catalano", "321.296.368.96", "masculino", e);
        
        usuarioDAO.save(usuario);
        
    }
    
    @Test
    public void updateUsuario( ) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nome", "Samuel");
        
        Usuario oldUser = usuarioDAO.findUsuario(map);
        
        Endereco e = new Endereco("Rua XPTO", 666, "Higienopolis", "Ap. 606");
        Usuario newUser = new Usuario("Samuel", "Catalano", "321.296.368.96", "masculino", e);
        
        usuarioDAO.update(oldUser, newUser);
    }
    
    @Test
    public void deleteUsuario( ) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nome", "Samuel");
        
        Usuario usuario = usuarioDAO.findUsuario(map);
        
        usuarioDAO.delete(usuario);
    }
}