
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="java.util.ArrayList,model.bean.Cidade,model.dao.CidadeDAO,model.dao.ClienteDAO,model.bean.Cliente"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!
Cliente cliente;
ArrayList<Cidade> listCidade;
%>
<%
cliente = (Cliente) request.getAttribute("cliente");
listCidade = CidadeDAO.getAll();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>
         <center>
            <h3>Alterar Cliente</h3>
            <form name="frmAltCliente" method='post'>                
                <input type='hidden' name='table' value='Cliente'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=cliente.getCodCliente()%>'>
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='codcliente' value='<%=cliente.getCodCliente()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome Cliente:
                        </td>
                        <td>
                            <input type='text' name='nome' value='<%=cliente.getNome()%>'>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            Cidade:
                        </td>
                        <td>
                            <select name='codcidade'>                                
                                <%
                                String selected="";
                                
                                for (int i = 0; i < listCidade.size(); i++) {
                                    if(listCidade.get(i).getCodCidade() == cliente.getCidade().getCodCidade()) 
                                        selected = "selected"; 
                                    else
                                        selected = ""; 
                                    
                                %>
                                <option value='<%=listCidade.get(i).getCodCidade()%>' <%=selected%>><%=listCidade.get(i).getNome()%></option>
                                <% 
                                }
                                %>
                            </select>
                        </td>                        
                    </tr>
                     <tr>
                        <td>
                            Bairro:
                        </td>
                        <td>
                            <input type='text' name='bairro' value='<%=cliente.getBairro()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            cpf:
                        </td>
                        <td>
                            <input type='text' name='cpf' value='<%=cliente.getCpf()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Data de Nascimento:
                        </td>
                        <td>
                            <input type='text' name='dataNasc' value='<%=cliente.getDataNasc()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input type='text' name='email' value='<%=cliente.getEmail()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Endereço:
                        </td>
                        <td>
                            <input type='text' name='endereco' value='<%=cliente.getEndereco()%>'>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Telefone:
                        </td>
                        <td>
                            <input type='text' name='fone' value='<%=cliente.getFone()%>'>
                        </td>
                    </tr>                    
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltCliente);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltCliente.cod.value,document.frmAltCliente)'>    
                            <a href='/servletweb?acao=InserirCliente'>Inserir Cliente</a>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
