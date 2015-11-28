<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ page import="java.util.ArrayList,model.bean.Estado"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<%!
ArrayList<Estado> listEstado;
%>
<%
listEstado = (ArrayList<Estado>) request.getAttribute("listEstado");
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>
        <center>
            <h3>Inserir Cidades</h3>
            <form name="frmInserirCidade" method='post'>
                <input type='hidden' name='table' value='Cidade'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Nome Cidade:
                        </td>
                        <td>
                            <input type='text' name='nome' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Estado:
                        </td>
                        <td>
                            <select name='sigla'>
                                <%
                                for (int i = 0; i < listEstado.size(); i++) {
                                %>
                                <option                                     
                                    value='<%=listEstado.get(i).getSigla()%>'><%=listEstado.get(i).getNome()%>
                                </option>
                                <% 
                                }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirCidade)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/servletweb?acao=ListarCidade'>Listar Cidades</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
