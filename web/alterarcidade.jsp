<%-- 
    Document   : alterarcidade
    Created on : 28/03/2008, 15:27:53
    Author     : ebarros
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="java.util.ArrayList,model.bean.Cidade,model.dao.CidadeDAO,model.dao.EstadoDAO,model.bean.Estado"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!
Cidade cidade;
ArrayList<Estado> listEstado;
%>
<%
cidade = (Cidade) request.getAttribute("cidade");
listEstado = EstadoDAO.getAll();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>
         <center>
            <h3>Alterar Projetos</h3>
            <form name="frmAltCidade" method='post'>                
                <input type='hidden' name='table' value='Cidade'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=cidade.getCodCidade()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codCidade' value='<%=cidade.getCodCidade()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome Cidade:
                        </td>
                        <td>
                            <input type='text' name='nome' value='<%=cidade.getNome()%>'>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            Estado:
                        </td>
                        <td>
                            <select name='sigla'>                                
                                <%
                                String selected="";
                                
                                for (int i = 0; i < listEstado.size(); i++) {
                                    if(listEstado.get(i).getSigla().equals(cidade.getEstado().getSigla())) 
                                        selected = "selected"; 
                                    else
                                        selected = ""; 
                                    
                                %>
                                <option value='<%=listEstado.get(i).getSigla()%>' <%=selected%>><%=listEstado.get(i).getNome()%></option>
                                <% 
                                }
                                %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltCidade);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltCidade.cod.value,document.frmAltCidade)'>    
                            <a href='/servletweb?acao=InserirCidade'>Inserir Cidade</a>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
