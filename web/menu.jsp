<%-- 
    Document   : menu
    Created on : 25/03/2008, 15:28:43
    Author     : everton
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="controller.vo.Usuario,controller.Login"%>

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
        <title>Locadora xxx</title>
    </head>
    <body>
        <h2>Menu</h2>
         <a href='/locadora/servletweb?acao=ListarEstados'>Cadastro de Estados</a><br>
         <a href='/locadora/servletweb?acao=ListarCidade'>Cadastro de Cidades</a><br>
         <a href='/locadora/servletweb?acao=ListarCliente'>Cadastro de Clientes</a><br>
         <a href='/locadora/servletweb?acao=ListarVeiculo'>Cadastro de Veiculos</a><br>
         <a href='/locadora/servletweb?acao=ListarCategoria'>Cadastro de Categorias</a><br>
         <a href='/locadora/servletweb?acao=ListarVeiculoCliente'>Cadastro de Veiculos Clientes</a><br>
         <a href='/locadora/servletweb?acao=ListarUsuario'>Cadastro de Usuarios</a><br>
         <a href='/locadora/servletweb?acao=ListarMarca'>Cadastro de Marcas</a><br>
         <a href='/locadora/servletweb?acao=ListarModelo'>Cadastro de Modelos</a><br>    
    </body>
</html>
