
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="model.bean.Categoria,model.dao.CategoriaDAO"%>
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
Categoria categoria;
%>
<%
categoria = (Categoria) request.getAttribute("categoria");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>

        <center>
            <h3>Alterar Categorias</h3>
            <form name="frmAltCategoria" method='post'>                
                <input type='hidden' name='table' value='Categoria'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=categoria.getCodCategoria()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codcategoria' value='<%=categoria.getCodCategoria()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Descrição:
                        </td>
                        <td>
                            <input type='text' name='descricao' value='<%=categoria.getDescricao()%>'>
                        </td>
                    </tr>
                    <tr>
                       <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltCategoria);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltCategoria.cod.value,document.frmAltCategoria)'>    
                            <a href='/inserircategoria.jsp'>Inserir Categoria</a>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    
    </body>
</html>
