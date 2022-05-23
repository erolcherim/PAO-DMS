package com.company.repository;

import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class AgentVanzariRepository {

    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS agenti " +
                "(agentId int PRIMARY KEY AUTO_INCREMENT, " +
                "salariu int, "+
                "aniExperienta int, " +
                "comision double, " +
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
        String dropTableSql = "DROP TABLE agenti";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSql);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void createAgentVanzari(int salariu, int aniExperienta, double comision, int infoId) {
        String createAgentVanzariSql = "INSERT INTO agenti(salariu, aniExperienta, comision, infoId) VALUES("
                + salariu + "," +
                + aniExperienta + "," +
                + comision + "," +
                + infoId +
                ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createAgentVanzariSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAllAgents() {
        String selectAllAgents = "SELECT * FROM info i, agenti a WHERE i.infoId = a.infoId";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectAllAgents);
            while (resultSet.next()) {
                System.out.println("Agent Id:" + resultSet.getInt(7));
                System.out.println("Nume:" + resultSet.getString(2));
                System.out.println("Preunme:" + resultSet.getString(3));
                System.out.println("Data Nasterii:" + resultSet.getDate(4));
                System.out.println("Numar Telefon:" + resultSet.getString(5));
                System.out.println("Adresa:" + resultSet.getString(6));
                System.out.println("Info Id:" + resultSet.getInt(1));
                System.out.println("Salariu:" + resultSet.getInt(8));
                System.out.println("Comision:" + resultSet.getDouble(10));
                System.out.println("Ani Experienta:" + resultSet.getInt(9));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAgentById(int id) {
        String selectAgentByIdSql = "SELECT * FROM info i, agenti a WHERE i.infoId = a.infoId AND agentId= "+id;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(selectAgentByIdSql);
            while (resultSet.next()) {
                System.out.println("Agent Id:" + resultSet.getInt(7));
                System.out.println("Nume:" + resultSet.getString(2));
                System.out.println("Preunme:" + resultSet.getString(3));
                System.out.println("Data Nasterii:" + resultSet.getDate(4));
                System.out.println("Numar Telefon:" + resultSet.getString(5));
                System.out.println("Adresa:" + resultSet.getString(6));
                System.out.println("Info Id:" + resultSet.getInt(1));
                System.out.println("Salariu:" + resultSet.getInt(8));
                System.out.println("Comision:" + resultSet.getDouble(10));
                System.out.println("Ani Experienta:" + resultSet.getInt(9));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int selectInfoIdOfAgent(int id) {
        String selectInfoIdOfAgentSql = "SELECT infoId FROM agenti WHERE agentId= "+id;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        int result=0;
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(selectInfoIdOfAgentSql);
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateSalariuOfAgent(int salariu, int id){
        String updateSalariuOfAgentSql = "UPDATE info i, agenti a  SET salariu=? where i.infoId = a.infoId AND agentId=?;";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSalariuOfAgentSql)) {
            preparedStatement.setInt(1, salariu);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAgentById(int id){
        String deleteAgentByIdSql ="DELETE FROM agenti WHERE agentId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteAgentByIdSql)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
