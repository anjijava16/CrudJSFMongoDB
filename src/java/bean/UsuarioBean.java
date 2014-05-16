/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import core.Endereco;
import core.Usuario;
import dao.core.UsuarioDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author samuelcatalano
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuarioBase;
    
    private String busca;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String sexo;
    private String rua;
    private int numero;
    private String bairro;
    private String complemento;
    private Endereco endereco;
    private DataModel usuarios;
    private Integer activTab;
    boolean edit = false;

    /**
     * @return
     */
    public Integer getActivTab() {
        return activTab;
    }

    /**
     * @param activTab
     */
    public void setActivTab(Integer activTab) {
        this.activTab = activTab;
    }

    /**
     * @return
     */
    public DataModel getUsuarios() {
        Map<String, Object> mapUsuario = new HashMap<String, Object>();
        usuarios = null;
        List<Usuario> lista;

        if (this.busca == null || this.busca.equals("")) {
            lista = usuarioDAO.findUsuarios();
        }
        else {
            mapUsuario.put("nome", this.busca);
            lista = usuarioDAO.findUsuarios(mapUsuario);
        }
        usuarios = new ListDataModel(lista);
        return usuarios;
    }

    /**
     * Salva o usuario no banco de dados
     */
    public void salvarUsuario() {
        endereco = new Endereco(this.rua, this.numero, this.bairro, this.complemento);
        Usuario usuario = new Usuario(this.nome, this.sobrenome, this.cpf, this.sexo, endereco);

        if (isEdit()) {
            usuarioDAO.update(usuarioBase, usuario);
            setEdit(false);
            FacesContext.getCurrentInstance( ).addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuário alterado!"));
        }
        else {
            usuarioDAO.save(usuario);
            FacesContext.getCurrentInstance( ).addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuário incluido!"));
        }
        
        this.cleanUpFields();
        
    }

    /**
     * Pequisar o usuario
     */
    public void pesquisarUsuario() {
        FacesContext.getCurrentInstance( ).addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Busca realizada!"));
    }

    /**
     * Deletar o usuario
     *
     * @return ""
     */
    public String deletarUsuario() {
        Usuario u = (Usuario) usuarios.getRowData();
        usuarioDAO.delete(u);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario deletado!"));
        return "";
    }

    /**
     * Edita o usuario.
     */
    public void editarUsuario() {
        Usuario u = (Usuario) usuarios.getRowData();
        usuarioBase = u; // mantem o usuario anterior //TODO melhorar isso

        this.nome = u.getNome();
        this.sobrenome = u.getSobrenome();
        this.cpf = u.getCpf();
        this.sexo = u.getSexo();
        this.rua = u.getEndereco().getRua();
        this.numero = u.getEndereco().getNumero();
        this.bairro = u.getEndereco().getBairro();
        this.complemento = u.getEndereco().getComplemento();
        
        setEdit(true);
        setActivTab(0);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Limpa os campos
     */
    public void cleanUpFields() {
        this.nome = "";
        this.sobrenome = "";
        this.cpf = "";
        this.sexo = "";
        this.rua = "";
        this.numero = 0;
        this.bairro = "";
        this.complemento = "";
    }

    /**
     * @return the busca
     */
    public String getBusca() {
        return busca;
    }

    /**
     * @param busca the busca to set
     */
    public void setBusca(String busca) {
        this.busca = busca;
    }

    /**
     * @return the edit
     */
    public boolean isEdit() {
        return edit;
    }

    /**
     * @param edit the edit to set
     */
    public void setEdit(boolean edit) {
        this.edit = edit;
    }
}
