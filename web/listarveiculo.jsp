
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="model.bean.Veiculo,java.util.ArrayList"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%!
ArrayList<Veiculo> listVeiculo = null;
%>
<%
listVeiculo = (ArrayList<Veiculo>) request.getAttribute("listVeiculo");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>locadora Senac</title>
    </head>
    <body>
       <center>
            <h3>Lista de Veiculos</h3>
            <a href='/servletweb?acao=InserirVeiculo'>Novo Veiculo</a>
            <form name="frmVeiculo" method='post' action='/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Veiculo'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Descrição
                        </td>
                        <td>
                            Modelo
                        </td>
                        <td>
                            Marca
                        </td>
                        <td>
                            Categoria
                        </td>
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                    for (int i = 0; i < listVeiculo.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <a href="/servletweb?acao=AlterarVeiculo&Placa=<%=listVeiculo.get(i).getPlaca()%>"><%=listVeiculo.get(i).getPlaca()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarVeiculo&Placa=<%=listVeiculo.get(i).getPlaca()%>"><%=listVeiculo.get(i).getDescricao()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarVeiculo&Placa=<%=listVeiculo.get(i).getPlaca()%>"><%=listVeiculo.get(i).getModelo().getDescricao()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarVeiculo&Placa=<%=listVeiculo.get(i).getPlaca()%>"><%=listVeiculo.get(i).getMarca().getDescricao()%></a>
                        </td>
                        <td>
                            <a href="/servletweb?acao=AlterarVeiculo&Placa=<%=listVeiculo.get(i).getPlaca()%>"><%=listVeiculo.get(i).getCategoria().getDescricao()%></a>
                        </td>
                        <td>                            
                            <input type='button' value='Excluir' onclick='Excluir("<%=listVeiculo.get(i).getPlaca()%>",document.frmVeiculo)'>
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
