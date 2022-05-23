package com.company.repository;

import com.company.classes.Client;
import com.company.classes.Info;
import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class ClientRepository {
    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS clienti " +
                "(clientId int PRIMARY KEY AUTO_INCREMENT, " +
                "infoId int UNIQUE, " +
                "FOREIGN KEY(infoId) REFERENCES info(infoId));";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void dropTable() {
        String dropTableSql = "DROP TABLE clienti";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSql);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void createClient(int infoId) {
        String createClientSql = "INSERT INTO clienti(infoId) VALUES(" + infoId + ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createClientSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAllClients() {
        String selectInfoSql = "SELECT * FROM info i, clienti c WHERE i.infoId = c.infoId";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectInfoSql);
            while (resultSet.next()) {
                System.out.println("Client Id:" + resultSet.getInt(7));
                System.out.println("Nume:" + resultSet.getString(2));
                System.out.println("Preunme:" + resultSet.getString(3));
                System.out.println("Data Nasterii:" + resultSet.getDate(4));
                System.out.println("Numar Telefon:" + resultSet.getString(5));
                System.out.println("Adresa:" + resultSet.getString(6));
                System.out.println("Info Id:" + resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectClientById(int id) {
        String selectClientByIdSql = "SELECT * FROM info i, clienti c WHERE i.infoId = c.infoId AND clientId= "+id;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectClientByIdSql);
            while (resultSet.next()) {
                System.out.println("Client Id:" + resultSet.getInt(7));
                System.out.println("Nume:" + resultSet.getString(2));
                System.out.println("Preunme:" + resultSet.getString(3));
                System.out.println("Data Nasterii:" + resultSet.getDate(4));
                System.out.println("Numar Telefon:" + resultSet.getString(5));
                System.out.println("Adresa:" + resultSet.getString(6));
                System.out.println("Info Id:" + resultSet.getInt(1));
            }
            //return mapToClient(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return null;
    }

    public int selectInfoIdOfClient(int id) {
        String selectInfoIdOfClientSql = "SELECT infoId FROM clienti WHERE clientId= "+id;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        int result=0;
        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectInfoIdOfClientSql);
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateClient(String nume, String prenume, int id){
        String updateClientSql = "UPDATE info i, clienti c  SET nume=?, prenume=? where i.infoId = c.infoId AND clientId=?;";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateClientSql)) {
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, prenume);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClientById(int id){
        String deleteClientByIdSql ="DELETE FROM clienti WHERE clientId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteClientByIdSql)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//    private Client mapToClient(ResultSet resultSet) throws SQLException {
//        if (resultSet.next()) {
//            return new Client(resultSet.getObject(1);
//        }
//        return null;
//    }
}
