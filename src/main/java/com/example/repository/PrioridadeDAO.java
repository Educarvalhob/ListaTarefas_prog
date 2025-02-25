package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.management.Notification;

import com.example.model.Prioridade;

public class PrioridadeDAO {
    
    public boolean inserir(Prioridade prioridade) {
		
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			
			String insert = "INSERT INTO prioridade (descricao)" + "values" + "(?)";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
			preparedStatement1.setString(1, prioridade.getDescricao());
			
			int resultado = preparedStatement1.executeUpdate();
			if (resultado > 0) {
				return true;
			}else {
				return false;
			}
		} catch(Exception e) {
			System.out.print(e.getMessage());
            Notification notification = new Notification(
                    "Erro ao salvar. Por favor, verifique a mensagem à seguir: " + e.getMessage());
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            notification.open();
			return false;
		}
	}

    public boolean alterar (Prioridade prioridade) {
	
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String alterar = "UPDATE prioridade SET descricao = ? where id = ?";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(alterar);
			
			preparedStatement1.setString(1, prioridade.getDescricao());
			preparedStatement1.setInt(2, prioridade.getId());
			
			int resultado = preparedStatement1.executeUpdate();
			if (resultado > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}

    public boolean excluir (Prioridade prioridade) {
	
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String excluir = "DELETE FROM prioridade WHERE id = ?";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(excluir);
			preparedStatement1.setInt(1, prioridade.getId());
			int resultado = preparedStatement1.executeUpdate();
			if (resultado > 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
	}

    public Prioridade pesquisar (int id) {
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String busca = "SELECT * FROM prioridade WHERE id = ?";
			
			Prioridade prioridade = new Prioridade();
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(busca);
			preparedStatement1.setInt(1, id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				prioridade.setId(resultSet.getInt("id"));
				prioridade.setDescricao(resultSet.getString("nome"));
			}
			
			return prioridade;
			
		}catch(Exception e) {
			return null;
		}
	}
}
