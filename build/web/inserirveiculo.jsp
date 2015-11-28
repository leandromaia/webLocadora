
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ page import="java.util.ArrayList,model.bean.Modelo,model.bean.Marca,model.bean.Categoria"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<%!
ArrayList<Modelo> listModelo;
ArrayList<Marca> listMarca;
ArrayList<Categoria> listCategoria;
%>
<%
listModelo = (ArrayList<Modelo>) request.getAttribute("listModelo");
listMarca = (ArrayList<Marca>) request.getAttribute("listMarca");
listCategoria = (ArrayList<Categoria>) request.getAttribute("listCategoria");
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>
        <center>
            <h3>Inserir Veiculos</h3>
            <form name="frmInserirVeiculo" method='post'>
                <input type='hidden' name='table' value='Veiculo'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Placa:
                        </td>
                        <td>
                            <input type='text' name='placa' maxlength="8" size="8" value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Modelo:
                        </td>
                        <td>
                            <select name='codmodelo'>
                                <%
                                for (int i = 0; i < listModelo.size(); i++) {
                                %>
                                <option                                     
                                    value='<%=listModelo.get(i).getCodModelo()%>'><%=listModelo.get(i).getDescricao()%>
                                </option>
                                <% 
                                }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Marca:
                        </td>
                        <td>
                            <select name='codmarca'>
                                <%
                                for (int i = 0; i < listMarca.size(); i++) {
                                %>
                                <option                                     
                                    value='<%=listMarca.get(i).getCodMarca()%>'><%=listMarca.get(i).getDescricao()%>
                                </option>
                                <% 
                                }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Categoria:
                        </td>
                        <td>
                            <select name='codcategoria'>
                                <%
                                for (int i = 0; i < listCategoria.size(); i++) {
                                %>
                                <option                                     
                                    value='<%=listCategoria.get(i).getCodCategoria()%>'><%=listCategoria.get(i).getDescricao()%>
                                </option>
                                <% 
                                }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmInserirVeiculo)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/servletweb?acao=ListarVeiculo'>Listar Veiculos</a><br>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
