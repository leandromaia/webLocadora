
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="controller.vo.Categoria,java.util.ArrayList"%>
<%@ include file="/menu.jsp" %>
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
ArrayList<Categoria> listCategoria = null;
%>
<%
listCategoria = (ArrayList<Categoria>) request.getAttribute("listCategoria");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Locadora xxx</title>
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
    </head>
    <body>
        <center>
            <h3>Lista de Categorias</h3>
            <a href='/locadora/inserircategoria.jsp'>Nova Categoria</a>
            <form name="frmCategoria" method='post' action='/locadora/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Categoria'>
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
                    for (int i = 0; i < listCategoria.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <a href="/locadora/servletweb?acao=AlterarCategoria&CodCategoria=<%=listCategoria.get(i).getCodCategoria()%>"><%=listCategoria.get(i).getCodCategoria()%></a>
                        </td>
                        <td>
                            <a href="/locadora/servletweb?acao=AlterarCategoria&CodCategoria=<%=listCategoria.get(i).getCodCategoria()%>"><%=listCategoria.get(i).getDescricao()%></a>
                        </td>
                        <td>
                            <input type='button' value='Excluir' onclick='Excluir(<%=listCategoria.get(i).getCodCategoria()%>,document.frmCategoria)'>
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
