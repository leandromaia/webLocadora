/*
 * ServletWeb.java
 *
 * Created on 4 de Março de 2008, 20:22
 */

package controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Everton Barros
 * @version
 */

import model.dao.Conexao;

public class ServletWeb extends HttpServlet {
    private ServletContext sc;
    private String jsp = "";
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        sc = config.getServletContext();
        Conexao.conectar(sc.getInitParameter("url"), sc.getInitParameter("usuario"),
                sc.getInitParameter("senha"), sc.getInitParameter("driver"));
    }
    
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String acao = request.getParameter("acao");
        
        if(acao.equals("Logar"))            
            jsp = Login.execute(request);
        else if (acao.equals("ListarEstados"))
            jsp = ListarEstados.execute(request);
        else if (acao.equals("AlterarEstado"))
            jsp = AlterarEstado.execute(request);
        else if (acao.equals("GravarAlteracaoEstado"))
            jsp = GravarAlteracaoEstado.execute(request);
        else if (acao.equals("GravarInsercaoEstado"))
            jsp = GravarInsercaoEstado.execute(request);
        else if (acao.equals("ExcluirEstado"))
            jsp = ExcluirEstado.execute(request);
        else if (acao.equals("ListarCidade"))
            jsp = ListarCidade.execute(request);
        else if (acao.equals("InserirCidade"))
            jsp = InserirCidade.execute(request);
        else if (acao.equals("AlterarCidade"))
            jsp = AlterarCidade.execute(request);
        else if (acao.equals("GravarAlteracaoCidade"))
            jsp = GravarAlteracaoCidade.execute(request);
        else if (acao.equals("GravarInsercaoCidade"))
            jsp = GravarInsercaoCidade.execute(request);
        else if (acao.equals("ExcluirCidade"))
            jsp = ExcluirCidade.execute(request);
        else if (acao.equals("ListarCliente"))
            jsp = ListarCliente.execute(request);
        else if (acao.equals("InserirCliente"))
            jsp = InserirCliente.execute(request);
        else if (acao.equals("AlterarCliente"))
            jsp = AlterarCliente.execute(request);
        else if (acao.equals("GravarAlteracaoCliente"))
            jsp = GravarAlteracaoCliente.execute(request);
        else if (acao.equals("GravarInsercaoCliente"))
            jsp = GravarInsercaoCliente.execute(request);
        else if (acao.equals("ExcluirCliente"))
            jsp = ExcluirCliente.execute(request);
        else if (acao.equals("ListarVeiculo"))
            jsp = ListarVeiculo.execute(request);
        else if (acao.equals("InserirVeiculo"))
            jsp = InserirVeiculo.execute(request);
        else if (acao.equals("AlterarVeiculo"))
            jsp = AlterarVeiculo.execute(request);
        else if (acao.equals("GravarAlteracaoVeiculo"))
            jsp = GravarAlteracaoVeiculo.execute(request);
        else if (acao.equals("GravarInsercaoVeiculo"))
            jsp = GravarInsercaoVeiculo.execute(request);
        else if (acao.equals("ExcluirVeiculo"))
            jsp = ExcluirVeiculo.execute(request);
        else if (acao.equals("ListarModelo"))
            jsp = ListarModelo.execute(request);
        else if (acao.equals("AlterarModelo"))
            jsp = AlterarModelo.execute(request);
        else if (acao.equals("GravarAlteracaoModelo"))
            jsp = GravarAlteracaoModelo.execute(request);
        else if (acao.equals("GravarInsercaoModelo"))
            jsp = GravarInsercaoModelo.execute(request);
        else if (acao.equals("ExcluirModelo"))
            jsp = ExcluirModelo.execute(request);
        else if (acao.equals("ListarMarca"))
            jsp = ListarMarca.execute(request);
        else if (acao.equals("AlterarMarca"))
            jsp = AlterarMarca.execute(request);
        else if (acao.equals("GravarAlteracaoMarca"))
            jsp = GravarAlteracaoMarca.execute(request);
        else if (acao.equals("GravarInsercaoMarca"))
            jsp = GravarInsercaoMarca.execute(request);
        else if (acao.equals("ExcluirMarca"))
            jsp = ExcluirMarca.execute(request);
        else if (acao.equals("ListarCategoria"))
            jsp = ListarCategoria.execute(request);
        else if (acao.equals("AlterarCategoria"))
            jsp = AlterarCategoria.execute(request);
        else if (acao.equals("GravarAlteracaoCategoria"))
            jsp = GravarAlteracaoCategoria.execute(request);
        else if (acao.equals("GravarInsercaoCategoria"))
            jsp = GravarInsercaoCategoria.execute(request);
        else if (acao.equals("ExcluirCategoria"))
            jsp = ExcluirCategoria.execute(request);
        else if (acao.equals("ListarUsuario"))
            jsp = ListarUsuario.execute(request);
        else if (acao.equals("AlterarUsuario"))
            jsp = AlterarUsuario.execute(request);
        else if (acao.equals("GravarAlteracaoUsuario"))
            jsp = GravarAlteracaoUsuario.execute(request);
        else if (acao.equals("GravarInsercaoUsuario"))
            jsp = GravarInsercaoUsuario.execute(request);
        else if (acao.equals("ExcluirUsuario"))
            jsp = ExcluirUsuario.execute(request);
        else if (acao.equals("ListarVeiculoCliente"))
            jsp = ListarVeiculoCliente.execute(request);
        else if (acao.equals("InserirVeiculoCliente"))
            jsp = InserirVeiculoCliente.execute(request);
        else if (acao.equals("AlterarVeiculoCliente"))
            jsp = AlterarVeiculoCliente.execute(request);
        else if (acao.equals("GravarAlteracaoVeiculoCliente"))
            jsp = GravarAlteracaoVeiculoCliente.execute(request);
        else if (acao.equals("GravarInsercaoVeiculoCliente"))
            jsp = GravarInsercaoVeiculoCliente.execute(request);
        else if (acao.equals("ExcluirVeiculoCliente"))
            jsp = ExcluirVeiculoCliente.execute(request);
        //
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
    
    public void destroy() {
        Conexao.destroy();
    }
}
