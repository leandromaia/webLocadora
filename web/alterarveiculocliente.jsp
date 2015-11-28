
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="java.util.ArrayList,model.bean.VeiculoCliente,model.dao.VeiculoClienteDAO,
               model.dao.ClienteDAO,model.bean.Cliente,model.dao.VeiculoDAO,model.bean.Veiculo"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!
VeiculoCliente veiculoCliente;
ArrayList<Cliente> listCliente;
ArrayList<Veiculo> listVeiculo;
%>
<%
veiculoCliente = (VeiculoCliente) request.getAttribute("veiculoCliente");
listCliente= ClienteDAO.getAll();
listVeiculo= VeiculoDAO.getAll();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>
         <center>
            <h3>Alterar Veiculos - Clientes</h3>
            <form name="frmAltVeiculoCliente" method='post'>                
                <input type='hidden' name='table' value='VeiculoCliente'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=veiculoCliente.getCodVeiculoCliente()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codveiculocliente' value='<%=veiculoCliente.getCodVeiculoCliente()%>' readonly>
                        </td>
                    </tr>                    
                    <tr>
                        <td>
                            Cliente:
                        </td>
                        <td>
                            <select name='codcliente'>                                
                                <%
                                String selected="";
                                
                                for (int i = 0; i < listCliente.size(); i++) {
                                    if(listCliente.get(i).getCodCliente()== veiculoCliente.getCliente().getCodCliente()) 
                                        selected = "selected"; 
                                    else
                                        selected = ""; 
                                    
                                %>
                                <option value='<%=listCliente.get(i).getCodCliente()%>' <%=selected%>><%=listCliente.get(i).getNome()%></option>
                                <% 
                                }
                                %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td>
                            Veiculo:
                        </td>
                        <td>
                            <select name='placa'>                                
                                <%
                                String select="";
                                
                                for (int i = 0; i < listVeiculo.size(); i++) {
                                    if(listVeiculo.get(i).getPlaca().equals(veiculoCliente.getVeiculo().getPlaca())) 
                                        select = "selected"; 
                                    else
                                        select = ""; 
                                    
                                %>
                                <option value='<%=listVeiculo.get(i).getPlaca()%>' <%=select%>><%=listVeiculo.get(i).getDescricao()%></option>
                                <% 
                                }
                                %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltVeiculoCliente);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltVeiculoCliente.cod.value,document.frmAltVeiculoCliente)'>    
                            <a href='/servletweb?acao=InserirVeiculoCliente'>Inserir VeiculoCliente</a>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
