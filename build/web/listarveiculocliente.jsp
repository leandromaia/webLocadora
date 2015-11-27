<%-- 
    Document   : listarcidade
    Created on : 28/03/2008, 14:14:04
    Author     : ebarros
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="controller.vo.VeiculoCliente,java.util.ArrayList"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%!
ArrayList<VeiculoCliente> listVeiculoCliente = null;
%>
<%
listVeiculoCliente = (ArrayList<VeiculoCliente>) request.getAttribute("listVeiculoCliente");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>locadora xxx</title>
    </head>
    <body>
       <center>
            <h3>Lista de VeiculoClientes</h3>
            <a href='/locadora/servletweb?acao=InserirVeiculoCliente'>Novo VeiculoCliente</a>
            <form name="frmVeiculoCliente" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='VeiculoCliente'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Cliente
                        </td>
                        <td>
                            Veiculo
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                    for (int i = 0; i < listVeiculoCliente.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <a href="/locadora/servletweb?acao=AlterarVeiculoCliente&CodVeiculoCliente=<%=listVeiculoCliente.get(i).getCodVeiculoCliente()%>"><%=listVeiculoCliente.get(i).getCodVeiculoCliente()%></a>
                        </td>
                        <td>
                            <a href="/locadora/servletweb?acao=AlterarVeiculoCliente&CodVeiculoCliente=<%=listVeiculoCliente.get(i).getCodVeiculoCliente()%>"><%=listVeiculoCliente.get(i).getCliente().getNome()%></a>
                        </td>
                        <td>
                            <a href="/locadora/servletweb?acao=AlterarVeiculoCliente&CodVeiculoCliente=<%=listVeiculoCliente.get(i).getCodVeiculoCliente()%>"><%=listVeiculoCliente.get(i).getVeiculo().getDescricao()%></a>
                        </td>
                        <td>                            
                            <input type='button' value='Excluir' onclick='Excluir(<%=listVeiculoCliente.get(i).getCodVeiculoCliente()%>,document.frmVeiculoCliente)'>
                        </td>
                    </tr>
                    <%
                    } 
                    %>
                </table>
            </form>
        </center> 
    </body>
</html>
