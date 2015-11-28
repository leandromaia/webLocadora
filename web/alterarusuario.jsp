
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="model.bean.Usuario,model.dao.UsuarioDAO"%>
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
Usuario usuario;
%>
<%
usuario = (Usuario) request.getAttribute("usuario");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>

        <center>
            <h3>Alterar Usuarios</h3>
            <form name="frmAltUsuario" method='post'>                
                <input type='hidden' name='table' value='Usuario'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=usuario.getCodUsuario()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codusuario' value='<%=usuario.getCodUsuario()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type='text' name='nome' value='<%=usuario.getNome()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome Completo:
                        </td>
                        <td>
                            <input type='text' name='nomecompleto' value='<%=usuario.getNomeCompleto()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input type='text' name='email' value='<%=usuario.getEmail()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Senha:
                        </td>
                        <td>
                            <input type='password' name='senha' value='<%=usuario.getSenha()%>'>
                        </td>
                    </tr>
                    <tr>
                       <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltUsuario);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltUsuario.cod.value,document.frmAltUsuario)'>    
                            <a href='/inserirusuario.jsp'>Inserir Usuario</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    
    </body>
</html>
