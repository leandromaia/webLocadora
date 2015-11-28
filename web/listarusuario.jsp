
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="model.bean.Usuario,java.util.ArrayList"%>
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
ArrayList<Usuario> listUsuario = null;
%>
<%
listUsuario = (ArrayList<Usuario>) request.getAttribute("listUsuario");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Locadora Senac</title>
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
    </head>
    <body>
        <center>
            <h3>Lista de Usuarios</h3>
            <a href='/inserirusuario.jsp'>Novo Usuario</a>
            <form name="frmUsuario" method='post' action='/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Usuario'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Nome
                        </td>
                        <td>
                            Nome Completo
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Senha
                        </td>
                        
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                    for (int i = 0; i < listUsuario.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <a href="/servletweb?acao=AlterarUsuario&CodUsuario=<%=listUsuario.get(i).getCodUsuario()%>"><%=listUsuario.get(i).getCodUsuario()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarUsuario&CodUsuario=<%=listUsuario.get(i).getCodUsuario()%>"><%=listUsuario.get(i).getNome()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarUsuario&CodUsuario=<%=listUsuario.get(i).getCodUsuario()%>"><%=listUsuario.get(i).getNomeCompleto()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarUsuario&CodUsuario=<%=listUsuario.get(i).getCodUsuario()%>"><%=listUsuario.get(i).getEmail()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarUsuario&CodUsuario=<%=listUsuario.get(i).getCodUsuario()%>"><%=listUsuario.get(i).getSenha()%></a>
                        </td>
                        <td>
                            <input type='button' value='Excluir' onclick='Excluir(<%=listUsuario.get(i).getCodUsuario()%>,document.frmUsuario)'>
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
