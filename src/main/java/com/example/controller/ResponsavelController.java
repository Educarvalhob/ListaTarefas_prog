package com.example.controller;

import com.example.repository.ResponsavelDAO;
import com.example.model.Responsavel;

public class ResponsavelController {
    ResponsavelDAO dao = new ResponsavelDAO();

    public boolean inserir(Responsavel responsavel){
        return dao.inserir(responsavel);
    }

    public boolean alterar(Responsavel responsavel){
        return dao.alterar(responsavel);
    }

    public boolean excluir(Responsavel responsavel){
        return dao.excluir(responsavel);
    }

    public boolean pesquisar(Responsavel responsavel){
        return dao.pesquisar(responsavel);
    }
}
