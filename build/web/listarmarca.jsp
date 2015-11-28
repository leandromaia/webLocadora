
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="model.bean.Marca,java.util.ArrayList"%>
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
ArrayList<Marca> listMarca = null;
%>
<%
listMarca = (ArrayList<Marca>) request.getAttribute("listMarca");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Locadora Senac</title>
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
    </head>
    <body>
        <center>
            <h3>Lista de Marcas</h3>
            <a href='/inserirmarca.jsp'>Nova Marca</a>
            <form name="frmMarca" method='post' action='/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Marca'>
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
                    for (int i = 0; i < listMarca.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <a href="/servletweb?acao=AlterarMarca&CodMarca=<%=listMarca.get(i).getCodMarca()%>"><%=listMarca.get(i).getCodMarca()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarMarca&CodMarca=<%=listMarca.get(i).getCodMarca()%>"><%=listMarca.get(i).getDescricao()%></a>
                        </td>
                        <td>
                            <input type='button' value='Excluir' onclick='Excluir(<%=listMarca.get(i).getCodMarca()%>,document.frmMarca)'>
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
