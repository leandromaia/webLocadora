

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="model.bean.Cliente,java.util.ArrayList"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%!
ArrayList<Cliente> listCliente = null;
%>
<%
listCliente = (ArrayList<Cliente>) request.getAttribute("listCliente");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>locadora Senac</title>
    </head>
    <body>
       <center>
            <h3>Lista de Clientes</h3>
            <a href='/servletweb?acao=InserirCliente'>Novo Cliente</a>
            <form name="frmCliente" method='post' action='/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Cliente'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Nome
                        </td>
                        <td>
                            Cidade
                        </td>
                        <td>
                            Bairro
                        </td>
                        <td>
                            cpf
                        </td>
                        <td>
                            Data de Nascimento
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Endereço
                        </td>
                        <td>
                            Telefone
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                    for (int i = 0; i < listCliente.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <a href="/servletweb?acao=AlterarCliente&CodCliente=<%=listCliente.get(i).getCodCliente()%>"><%=listCliente.get(i).getCodCliente()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarCliente&CodCliente=<%=listCliente.get(i).getCodCliente()%>"><%=listCliente.get(i).getNome()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarCliente&CodCliente=<%=listCliente.get(i).getCodCliente()%>"><%=listCliente.get(i).getCidade().getNome()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarCliente&CodCliente=<%=listCliente.get(i).getCodCliente()%>"><%=listCliente.get(i).getBairro()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarCliente&CodCliente=<%=listCliente.get(i).getCodCliente()%>"><%=listCliente.get(i).getCpf()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarCliente&CodCliente=<%=listCliente.get(i).getCodCliente()%>"><%=listCliente.get(i).getDataNasc()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarCliente&CodCliente=<%=listCliente.get(i).getCodCliente()%>"><%=listCliente.get(i).getEmail()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarCliente&CodCliente=<%=listCliente.get(i).getCodCliente()%>"><%=listCliente.get(i).getEndereco()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarCliente&CodCliente=<%=listCliente.get(i).getCodCliente()%>"><%=listCliente.get(i).getFone()%></a>
                        </td>
                        <td>                            
                            <input type='button' value='Excluir' onclick='Excluir(<%=listCliente.get(i).getCodCliente()%>,document.frmCliente)'>
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
