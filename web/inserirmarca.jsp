<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>

        <center>
            <h3>Inserir Marcas</h3>
             <form name="frmInserirMarca" method='post'>
                <input type='hidden' name='table' value='Marca'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Descrição:
                        </td>
                        <td>
                            <input type='text' name='descricao' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirMarca)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/servletweb?acao=ListarMarca'>Listar Marcas</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    
    </body>
</html>
