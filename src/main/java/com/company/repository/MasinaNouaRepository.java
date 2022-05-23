package com.company.repository;

import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class MasinaNouaRepository {
    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS masina_noua " +
                "(masinaId int PRIMARY KEY AUTO_INCREMENT, " +
                "reducereRabla int, "+
                "timpAsteptare int, "+
                "CONSTRAINT FKMasinaNoua FOREIGN KEY (masinaId) REFERENCES masina(masinaId) ON DELETE CASCADE"+
                ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String dropTableSql = "DROP TABLE masina_noua";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSql);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void selectAllMasinaNoua(){
        String selectAllMasinaNouaSql = "select * from masina m, masina_noua n where m.masinaId = n.masinaId;";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(selectAllMasinaNouaSql);
            while (resultSet.next()) {
                System.out.println("Masina Id:" + resultSet.getInt(1));
                System.out.println("Producator:" + resultSet.getString(2));
                System.out.println("Model:" + resultSet.getString(3));
                System.out.println("Capacitate Cilindrica:" + resultSet.getInt(4));
                System.out.println("Pret:" + resultSet.getInt(5));
                System.out.println("An Fabricatie:" + resultSet.getInt(6));
                System.out.println("Reducere:" + resultSet.getInt(8));
                System.out.println("Timp Asteptare:" + resultSet.getInt(9));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void selectMasinaNouaById(int id){
        String selectAllMasinaNouaSql = "SELECT * FROM masina m, masina_noua n WHERE m.masinaId = n.masinaId AND m.masinaId="+id+";";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(selectAllMasinaNouaSql);
            while (resultSet.next()) {
                System.out.println("Masina Id:" + resultSet.getInt(1));
                System.out.println("Producator:" + resultSet.getString(2));
                System.out.println("Model:" + resultSet.getString(3));
                System.out.println("Capacitate Cilindrica:" + resultSet.getInt(4));
                System.out.println("Pret:" + resultSet.getInt(5));
                System.out.println("An Fabricatie:" + resultSet.getInt(6));
                System.out.println("Reducere:" + resultSet.getInt(8));
                System.out.println("Timp Asteptare:" + resultSet.getInt(9));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createMasinaNoua(int masinaId, int reducereRabla, int timpAsteptare) {
        String createMasinaNouaSql = "INSERT INTO masina_noua(masinaId, reducereRabla, timpAsteptare) VALUES("+ masinaId + "," + reducereRabla + "," + timpAsteptare + ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createMasinaNouaSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTimpAsteptareMasinaNoua(int timpAsteptare, int id){
        String updateTimpAsteptareMasinaNouaSql = "UPDATE masina_noua SET timpAsteptare=? WHERE masinaId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateTimpAsteptareMasinaNouaSql)) {
            preparedStatement.setInt(1, timpAsteptare);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
