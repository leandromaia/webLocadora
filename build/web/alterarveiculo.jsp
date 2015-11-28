
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="java.util.ArrayList,model.bean.Veiculo,model.dao.VeiculoDAO,model.dao.MarcaDAO, model.dao.CategoriaDAO,
               model.ModeloDAO,controller.vo.Modelo,controller.vo.Marca,controller.vo.Categoria"%>
<%@ include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!
Veiculo veiculo;
ArrayList<Modelo> listModelo;
ArrayList<Marca> listMarca;
ArrayList<Categoria> listCategoria;
%>
<%
veiculo = (Veiculo) request.getAttribute("veiculo");
listModelo = ModeloDAO.getAll();
listMarca = MarcaDAO.getAll();
listCategoria = CategoriaDAO.getAll();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>Locadora Senac</title>
    </head>
    <body>
         <center>
            <h3>Alterar Veículo</h3>
            <form name="frmAltVeiculo" method='post'>                
                <input type='hidden' name='table' value='Veiculo'>
                <input type='hidden' name='acao' value='alterar'>
                <input type='hidden' name='cod' value='<%=veiculo.getPlaca()%>'>    
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type='text' name='placa' value='<%=veiculo.getPlaca()%>' readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Descricao:
                        </td>
                        <td>
                            <input type='text' name='descricao' value='<%=veiculo.getDescricao()%>'>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            Modelo
                        </td>
                        <td>
                            <select name='codmodelo'>                                
                                <%
                                String selected="";
                                
                                for (int i = 0; i < listModelo.size(); i++) {
                                    if(listModelo.get(i).getCodModelo() == veiculo.getModelo().getCodModelo())
                                        selected = "selected"; 
                                    else
                                        selected = ""; 
                                    
                                %>
                                <option value='<%=listModelo.get(i).getCodModelo()%>' <%=selected%>><%=listModelo.get(i).getDescricao()%></option>
                                <% 
                                }
                                %>
                            </select>
                        </td>                        
                    </tr>
                     <tr>
                        <td>
                            Marca
                        </td>
                        <td>
                            <select name='codmarca'>                                
                                <%
                                String select="";
                                
                                for (int i = 0; i < listMarca.size(); i++) {
                                    if(listMarca.get(i).getCodMarca() == veiculo.getMarca().getCodMarca())
                                        select = "selected"; 
                                    else
                                        select = ""; 
                                    
                                %>
                                <option value='<%=listMarca.get(i).getCodMarca()%>' <%=select%>><%=listMarca.get(i).getDescricao()%></option>                                <% 
                                }
                                %>
                            </select>
                        </td>                        
                    </tr>
                     <tr>
                        <td>
                            Categoria
                        </td>
                        <td>
                            <select name='codcategoria'>                                
                                <%
                                String sel="";
                                
                                for (int i = 0; i < listCategoria.size(); i++) {
                                    if(listCategoria.get(i).getCodCategoria() == veiculo.getCategoria().getCodCategoria())
                                        sel = "selected"; 
                                    else
                                        sel = ""; 
                                    
                                %>
                                <option value='<%=listCategoria.get(i).getCodCategoria()%>' <%=sel%>><%=listCategoria.get(i).getDescricao()%></option>
                                <% 
                                }
                                %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.frmAltVeiculo);" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <input type='button' value='Excluir' onclick='Excluir(document.frmAltVeiculo.cod.value,document.frmAltVeiculo)'>    
                            <a href='/servletweb?acao=InserirVeiculo'>Inserir Veiculo</a>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
    </body>
</html>
