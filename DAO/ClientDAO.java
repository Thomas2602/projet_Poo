package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Client;

public class ClientDAO {

	public class ClientsDAO {
	    private Connection connection;

	    public ClientsDAO(Connection connect) {
	        this.connection = connection;
	    }

	    public void ajouterClient(Client client) throws SQLException {
	        String sql = "INSERT INTO clients (nom, prénom, email, téléphone, adresse, date_inscription) VALUES (?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, client.getNom());
	            statement.setString(2, client.getPrenom());
	            statement.setString(3, client.getEmail());
	            statement.setString(4, client.getTelephone());
	            statement.setString(5, client.getAdresse());
	            statement.setDate(6, Date.valueOf(client.getDateInscription()));
	            statement.executeUpdate();
	        }
	    }

	    public Client obtenirClient(int id) throws SQLException {
	        String sql = "SELECT * FROM clients WHERE id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, id);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                return new Client(
	                    resultSet.getId("id"),
	                    resultSet.getNom("nom"),
	                    resultSet.getString("prénom"),
	                    resultSet.getString("email"),
	                    resultSet.getString("téléphone"),
	                    resultSet.getString("adresse"),
	                    resultSet.getDate("date_inscription").toLocalDate()
	                );
	            }
	        }
	        return null;
	    }

	    public List<Client> obtenirTousLesClients() throws SQLException {
	        List<Client> clientsList = new ArrayList<>();
	        String sql = "SELECT * FROM Client";
	        try (Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(sql)) {
	            while (resultSet.next()) {
	                Client client = new Client(
	                    resultSet.getInt("id"),
	                    resultSet.getString("nom"),
	                    resultSet.getString("prénom"),
	                    resultSet.getString("email"),
	                    resultSet.getString("téléphone"),
	                    resultSet.getString("adresse"),
	                    resultSet.getDate("date_inscription").toLocalDate()
	                );
	                clientsList.add(client);
	            }
	        }
	        return clientsList;
	    }

	    public void mettreAJourClient(Client client) throws SQLException {
	        String sql = "UPDATE clients SET nom = ?, prénom = ?, email = ?, téléphone = ?, adresse = ? WHERE id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, client.getNom());
	            statement.setString(2, client.getPrenom());
	            statement.setString(3, client.getEmail());
	            statement.setString(4, client.getTelephone());
	            statement.setString(5, client.getAdresse());
	            statement.setInt(6, client.getId());
	            statement.executeUpdate();
	        }
	    }

	    public void supprimerClient(int id) throws SQLException {
	        String sql = "DELETE FROM clients WHERE id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, id);
	            statement.executeUpdate();
	        }
	    }
	}
}



