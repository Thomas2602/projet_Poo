package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ObjetDAO<T> {
    protected Connection connection;

    public ObjetDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void ajouter(T obj) throws SQLException;

    public abstract T obtenir(int id) throws SQLException;

    public abstract List<T> obtenirTous() throws SQLException;

    public abstract void mettreAJour(T obj) throws SQLException;

    public abstract void supprimer(int id) throws SQLException;
}


/* Exemples de méthodes à implémenter
Chaque sous-classe de ObjetDAO devra implémenter ces méthodes pour gérer les objets spécifiques, comme ClientsDAO :

1. *ajouter* : Pour ajouter un objet à la base de données.
2. *obtenir* : Pour récupérer un objet par son ID.
3. *obtenirTous* : Pour récupérer tous les objets.
4. *mettreAJour* : Pour mettre à jour un objet existant.
5. *supprimer* : Pour supprimer un objet par son ID.

*/