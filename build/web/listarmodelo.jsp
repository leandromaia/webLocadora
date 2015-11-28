
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="model.bean.Modelo,java.util.ArrayList"%>
<%@include file="/menu.jsp"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%!
ArrayList<Modelo> listModelo = null;
%>
<%
listModelo = (ArrayList<Modelo>) request.getAttribute("listModelo");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Locadora Senac</title>
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
    </head>
    <body>
        <center>
            <h3>Lista de Modelos</h3>
            <a href='/inserirmodelo.jsp'>Novo Modelo</a>
            <form name="frmModelo" method='post' action='/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Modelo'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Descrição
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                    for (int i = 0; i < listModelo.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <a href="/servletweb?acao=AlterarModelo&CodModelo=<%=listModelo.get(i).getCodModelo()%>"><%=listModelo.get(i).getCodModelo()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarModelo&CodModelo=<%=listModelo.get(i).getCodModelo()%>"><%=listModelo.get(i).getDescricao()%></a>
                        </td>
                        <td>
                            <input type='button' value='Excluir' onclick='Excluir(<%=listModelo.get(i).getCodModelo()%>,document.frmModelo)'>
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
