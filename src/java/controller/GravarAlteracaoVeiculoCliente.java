/*
 * GravarAlteracaoVeiculo.java
 *
 * Created on 31 de Março de 2008, 20:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Everton Barros
 */
import model.bean.VeiculoCliente;
import javax.servlet.http.HttpServletRequest;
import model.dao.ClienteDAO;
import model.dao.VeiculoDAO;
import model.dao.VeiculoClienteDAO;

public class GravarAlteracaoVeiculoCliente {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            
            String codVeiculoCliente = request.getParameter("codveiculocliente");
            String codCliente = request.getParameter("codcliente");
            String placa = request.getParameter("placa");            
            
            VeiculoCliente veiculoCliente = new VeiculoCliente();
            
            veiculoCliente.setCliente(ClienteDAO.getById(Integer.parseInt(codCliente)));
            veiculoCliente.setVeiculo(VeiculoDAO.getById(placa));
            veiculoCliente.setCodVeiculoCliente(Integer.parseInt(codVeiculoCliente));
            
            Boolean delete = VeiculoClienteDAO.update(veiculoCliente);
            if(delete!=false)
                jsp = ListarVeiculoCliente.execute(request);
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
