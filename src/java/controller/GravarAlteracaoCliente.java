/*
 * GravarAlteracaoCliente.java
 *
 * Created on 31 de Março de 2008, 18:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Everton Barros
 */
import model.bean.Cliente;
import javax.servlet.http.HttpServletRequest;
import model.dao.ClienteDAO;
import model.dao.CidadeDAO;

public class GravarAlteracaoCliente {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // 
            String codCliente = request.getParameter("codcliente");
            // lendo o NomeCliente que se deseja alterar
            String nome = request.getParameter("nome");
            // lendo o CodDepartamento que se deseja alterar
            String codCidade = request.getParameter("codcidade");
            
            String bairro = request.getParameter("bairro");
            String cpf = request.getParameter("cpf");
            String dataNasc = request.getParameter("dataNasc");
            String email = request.getParameter("email");
            String endereco = request.getParameter("endereco");
            String fone = request.getParameter("fone");
            
            Cliente cliente = new Cliente();
            cliente.setCodCliente(Integer.parseInt(codCliente));
            cliente.setNome(nome);
            cliente.setCidade(CidadeDAO.getById(Integer.parseInt(codCidade)));
            cliente.setBairro(bairro);
            cliente.setCpf(cpf);
            cliente.setDataNasc(dataNasc);
            cliente.setEmail(email);
            cliente.setEndereco(endereco);
            cliente.setFone(fone);
            
            Boolean delete = ClienteDAO.update(cliente);
            if(delete!=false)
                jsp = ListarCliente.execute(request);
            else{
                String erro = "Não foi possível gravar a alteração desse registro";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}