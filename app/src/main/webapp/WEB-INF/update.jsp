<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Atualizar Jogo</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body>
        <div class="container">
            <h1>Atualizar Jogo</h1>
            <a href="/jogo" class="btn btn-primary">Voltar</a>
            <form action="/update" method="post">
                <input type="hidden" name="id" value="${jogo.id}" />
                <input type="hidden" name="id" value="${jogo.ano}" />
                <div class="form-group">
                    <label for="titulo">Jogo</label>
                    <input type="text" name="titulo" class="form-control" value="${jogo}" />
                    <label for="titulo">ano</label>
                    <input type="text" name="ano" class="form-control" value="${ano}" />
                </div>
                <br />
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>