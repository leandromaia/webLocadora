
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="model.bean.Modelo,model.dao.ModeloDAO"%>
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
Modelo modelo;
%>
<%
modelo = (Modelo) request.getAttribute("modelo");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>

        <center>
            <h3>Alterar Modelos</h3>
            <form name="frmAltModelo" method='post'>                
                <input type='hidden' name='table' value='Modelo'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=modelo.getCodModelo()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codmodelo' value='<%=modelo.getCodModelo()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Descrição:
                        </td>
                        <td>
                            <input type='text' name='descricao' value='<%=modelo.getDescricao()%>'>
                        </td>
                    </tr>
                    <tr>
                       <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltModelo);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltModelo.cod.value,document.frmAltModelo)'>    
                            <a href='/inserirmodelo.jsp'>Inserir Modelo</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    
    </body>
</html>
