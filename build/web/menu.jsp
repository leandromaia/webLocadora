
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="model.bean.Usuario,controller.Login"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%!
String codUsuario=""; 
%>
<%
 Login.validarSessao(request, response);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Locadora Senac</title>
    </head>
    <body>
        <h2>Menu</h2>
         <a href='/servletweb?acao=ListarEstados'>Cadastro de Estados</a><br>
         <a href='/servletweb?acao=ListarCidade'>Cadastro de Cidades</a><br>
         <a href='/servletweb?acao=ListarCliente'>Cadastro de Clientes</a><br>
         <a href='/servletweb?acao=ListarVeiculo'>Cadastro de Veiculos</a><br>
         <a href='/servletweb?acao=ListarCategoria'>Cadastro de Categorias</a><br>
         <a href='/servletweb?acao=ListarVeiculoCliente'>Cadastro de Veiculos Clientes</a><br>
         <a href='/servletweb?acao=ListarUsuario'>Cadastro de Usuarios</a><br>
         <a href='/servletweb?acao=ListarMarca'>Cadastro de Marcas</a><br>
         <a href='/servletweb?acao=ListarModelo'>Cadastro de Modelos</a><br>    
    </body>
</html>
