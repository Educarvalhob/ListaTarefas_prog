package com.example.controller;

import com.example.repository.ListaTarefasDAO;
import com.example.model.ListaTarefas;

public class ListaTarefasController {
    ListaTarefasDAO dao = new ListaTarefasDAO();

    public boolean inserir(ListaTarefas listaTarefas){
        return dao.inserir(listaTarefas);
    }

    public boolean alterar(ListaTarefas listaTarefas){
        return dao.alterar(listaTarefas);
    }

    public boolean excluir(ListaTarefas listaTarefas){
        return dao.excluir(listaTarefas);
    }

    public boolean pesquisar(ListaTarefas listaTarefas){
        return dao.pesquisar(listaTarefas);
    }
}
