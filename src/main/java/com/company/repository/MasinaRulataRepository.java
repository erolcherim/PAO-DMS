package com.company.repository;

import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class MasinaRulataRepository {
    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS masina_rulata " +
                "(masinaId int PRIMARY KEY AUTO_INCREMENT, " +
                "rulaj int, "+
                "CONSTRAINT FKMasinaRulata FOREIGN KEY (masinaId) REFERENCES masina(masinaId) ON DELETE CASCADE"+
                ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String dropTableSql = "DROP TABLE masina_rulata";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createMasinaRulata(int masinaId, int rulaj) {
        String createMasinaRulataSql = "INSERT INTO masina_rulata(masinaId, rulaj) VALUES("+ masinaId + "," + rulaj +  ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createMasinaRulataSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAllMasinaRulata(){
        String selectAllMasinaNouaSql = "select * from masina m, masina_rulata r where m.masinaId = r.masinaId;";

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
                System.out.println("Rulaj:" + resultSet.getInt(8));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void selectMasinaRulataById(int id){
        String selectAllMasinaNouaSql = "select * from masina m, masina_rulata r where m.masinaId = r.masinaId AND m.masinaId="+id+";";

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
                System.out.println("Rulaj:" + resultSet.getInt(8));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateRulajMasinaRulata(int rulaj, int id){
        String updateRulajMasinaRulataSql = "UPDATE masina_rulata SET rulaj=? WHERE masinaId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateRulajMasinaRulataSql)) {
            preparedStatement.setInt(1, rulaj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
