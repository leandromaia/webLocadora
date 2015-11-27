<%-- 
    Document   : listarcidade
    Created on : 28/03/2008, 14:14:04
    Author     : ebarros
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="controller.vo.Cidade,java.util.ArrayList"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%!
ArrayList<Cidade> listCidade = null;
%>
<%
listCidade = (ArrayList<Cidade>) request.getAttribute("listCidade");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>locadora xxx</title>
    </head>
    <body>
       <center>
            <h3>Lista de Cidades</h3>
            <a href='/locadora/servletweb?acao=InserirCidade'>Nova Cidade</a>
            <form name="frmCidade" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Cidade'>
                <table>
                    <tr>
                        <td>
                            C�digo
                        </td>
                        <td>
                            Nome
                        </td>
                        <td>
                            Estado
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                    for (int i = 0; i < listCidade.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <a href="/locadora/servletweb?acao=AlterarCidade&CodCidade=<%=listCidade.get(i).getCodCidade()%>"><%=listCidade.get(i).getCodCidade()%></a>
                        </td>
                        <td>
                            <a href="/locadora/servletweb?acao=AlterarCidade&CodCidade=<%=listCidade.get(i).getCodCidade()%>"><%=listCidade.get(i).getNome()%></a>
                        </td>
                        <td>
                            <a href="/locadora/servletweb?acao=AlterarCidade&CodCidade=<%=listCidade.get(i).getCodCidade()%>"><%=listCidade.get(i).getEstado().getNome()%></a>
                        </td>
                        <td>                            
                            <input type='button' value='Excluir' onclick='Excluir(<%=listCidade.get(i).getCodCidade()%>,document.frmCidade)'>
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
