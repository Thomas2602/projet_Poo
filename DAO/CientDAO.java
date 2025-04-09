package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private Connection connection;

    public ClientsDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterClient(Clients client) throws SQLException {
        String sql = "INSERT INTO clients (nom, prénom, email, téléphone, adresse, date_inscription) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrénom());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getTéléphone());
            statement.setString(5, client.getAdresse());
            statement.setDate(6, Date.valueOf(client.getDateInscription()));
            statement.executeUpdate();
        }
    }

    public Clients obtenirClient(int id) throws SQLException {
        String sql = "SELECT * FROM clients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Clients(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
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

    public List<Clients> obtenirTousLesClients() throws SQLException {
        List<Clients> clientsList = new ArrayList<>();
        String sql = "SELECT * FROM clients";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Clients client = new Clients(
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

    public void mettreAJourClient(Clients client) throws SQLException {
        String sql = "UPDATE clients SET nom = ?, prénom = ?, email = ?, téléphone = ?, adresse = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrénom());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getTéléphone());
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


d supprimer(int id) thr…