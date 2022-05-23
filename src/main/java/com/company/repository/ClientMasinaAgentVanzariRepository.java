package com.company.repository;

import com.company.classes.Masina;
import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class ClientMasinaAgentVanzariRepository {
    //singleton
    static ClientMasinaAgentVanzariRepository clientMasinaAgentVanzariRepo = new ClientMasinaAgentVanzariRepository();

    private ClientMasinaAgentVanzariRepository(){};

    public static ClientMasinaAgentVanzariRepository getInstance(){
        return clientMasinaAgentVanzariRepo;
    }
    //DDL + CRUD
    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS vanzari " +
                "(vanzareId int PRIMARY KEY AUTO_INCREMENT," +
                "clientId int NOT NULL, " +
                "masinaId int NOT NULL, "+
                "agentId int NOT NULL, " +
                "FOREIGN KEY (clientId) REFERENCES clienti(clientId) ON DELETE RESTRICT ON UPDATE CASCADE, " +
                "FOREIGN KEY (masinaId) REFERENCES masina(masinaId) ON DELETE RESTRICT ON UPDATE CASCADE, " +
                "FOREIGN KEY (agentId) REFERENCES agenti(agentId) ON DELETE RESTRICT ON UPDATE CASCADE " +
                ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String dropTableSql = "DROP TABLE vanzari";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createVanzare(int idClient, int idMasina, int idAgent){
        String createVanzareSql = "INSERT INTO vanzari(clientId, masinaId, agentId) VALUES("
                + idClient + ","
                + idMasina + ","
                + idAgent + ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createVanzareSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAllVanzare(){
        String selectAllVanzareSql = "select * from vanzari v, clienti c, masina m, agenti a where v.clientId=c.clientId AND v.masinaId = m.masinaId AND v.agentId = a.agentId;";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(selectAllVanzareSql);
            while (resultSet.next()) {
                System.out.println("Vanzare Id:" + resultSet.getInt(1));
                System.out.println("Client Id:" + resultSet.getString(2));
                System.out.println("Masina Id:" + resultSet.getString(3));
                System.out.println("Agent Id:" + resultSet.getInt(4));
                System.out.println("Pret:" + resultSet.getInt(11));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectVanzareById(int id){
        String selectVanzareByIdSql = "select * from vanzari v, clienti c, masina m, agenti a where v.clientId=c.clientId AND v.masinaId = m.masinaId AND v.agentId = a.agentId AND v.vanzareId="+id;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(selectVanzareByIdSql);
            while (resultSet.next()) {
                System.out.println("Vanzare Id:" + resultSet.getInt(1));
                System.out.println("Client Id:" + resultSet.getString(2));
                System.out.println("Masina Id:" + resultSet.getString(3));
                System.out.println("Agent Id:" + resultSet.getInt(4));
                System.out.println("Pret:" + resultSet.getInt(11));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVanzareById(int id){
        String deleteVanzareByIdSql ="DELETE FROM vanzari WHERE vanzareId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteVanzareByIdSql)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
