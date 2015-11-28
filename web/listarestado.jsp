
<%@page import="model.bean.Estado,java.util.ArrayList"%>
<%@include file="/menu.jsp"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!
ArrayList<Estado> listEstado = null;
%>
<%
listEstado = (ArrayList<Estado>) request.getAttribute("listEstado");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Locadora Senac</title>
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
    </head>
    <body>
        <center>
            <h3>Lista de Estados</h3>
            <a href='/inserirestado.jsp'>Novo Estado</a>
            <form name="frmEstado" method='post' action='/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Estado'>
                <table>
                    <tr>
                        <td>
                            Sigla
                        </td>
                        <td>
                            Nome
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                    for (int i = 0; i < listEstado.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <a href="/servletweb?acao=AlterarEstado&Sigla=<%=listEstado.get(i).getSigla()%>"><%=listEstado.get(i).getSigla()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarEstado&Sigla=<%=listEstado.get(i).getSigla()%>"><%=listEstado.get(i).getNome()%></a>
                        </td>
                        <td>
                            <input type='button' value='Excluir' onclick='Excluir("<%=listEstado.get(i).getSigla()%>",document.frmEstado)'>
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
