<%-- 
    Document   : inserircidade
    Created on : 28/03/2008, 14:46:25
    Author     : ebarros
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ page import="java.util.ArrayList,model.bean.Cliente,model.bean.Veiculo"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<%!
ArrayList<Cliente> listCliente;
ArrayList<Veiculo> listVeiculo;
%>
<%
listCliente = (ArrayList<Cliente>) request.getAttribute("listCliente");
listVeiculo = (ArrayList<Veiculo>) request.getAttribute("listVeiculo");

%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>
        <center>
            <h3>Inserir VeiculosClientes</h3>
            <form name="frmInserirVeiculoCliente" method='post'>
                <input type='hidden' name='table' value='VeiculoCliente'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Modelo:
                        </td>
                        <td>
                            <select name='codcliente'>
                                <%
                                for (int i = 0; i < listCliente.size(); i++) {
                                %>
                                <option                                     
                                    value='<%=listCliente.get(i).getCodCliente()%>'><%=listCliente.get(i).getNome()%>
                                </option>
                                <% 
                                }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Marca:
                        </td>
                        <td>
                            <select name='placa'>
                                <%
                                for (int i = 0; i < listVeiculo.size(); i++) {
                                %>
                                <option                                     
                                    value='<%=listVeiculo.get(i).getPlaca()%>'><%=listVeiculo.get(i).getDescricao()%>
                                </option>
                                <% 
                                }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirVeiculoCliente)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/servletweb?acao=ListarVeiculoCliente'>Listar Veiculos Clientes</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
