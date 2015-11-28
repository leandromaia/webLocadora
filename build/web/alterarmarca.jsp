
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="model.bean.Marca,model.dao.MarcaDAO"%>
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
Marca marca;
%>
<%
marca = (Marca) request.getAttribute("marca");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>

        <center>
            <h3>Alterar Marcas</h3>
            <form name="frmAltMarca" method='post'>                
                <input type='hidden' name='table' value='Marca'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=marca.getCodMarca()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codmarca' value='<%=marca.getCodMarca()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Descrição:
                        </td>
                        <td>
                            <input type='text' name='descricao' value='<%=marca.getDescricao()%>'>
                        </td>
                    </tr>
                    <tr>
                       <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltMarca);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltMarca.cod.value,document.frmAltMarca)'>    
                            <a href='/inserirmarca.jsp'>Inserir Marca</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    
    </body>
</html>
