package com.company.repository;

import com.company.classes.Info;
import com.company.classes.Masina;
import com.company.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MasinaRepository {
    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS masina " +
                "(masinaId int PRIMARY KEY AUTO_INCREMENT, " +
                "producator varchar(30), "+
                "model varchar(30), " +
                "capacitateCilindrica int, " +
                "pret int, " +
                "anFabricatie int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String dropTableSql = "DROP TABLE masina";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createMasina(Masina masina){
        String insertInfoSql = "INSERT INTO masina(producator, model, capacitateCilindrica, pret , anFabricatie) VALUES("
                + "\'" + masina.getProducator() +"\'" + ","
                + "\'" + masina.getModel() + "\'" + ","
                +masina.getCapacitateCilindrica() + ","
                +masina.getPret()+","
                +masina.getAnFabricatie()+ ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(insertInfoSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePretMasina(int pret, int id){
        String updatePretMasinaSql = "UPDATE masina SET pret=? WHERE masinaId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updatePretMasinaSql)) {
            preparedStatement.setInt(1, pret);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteMasinaById(int id){
        String deleteMasinaByIdSql ="DELETE FROM masina WHERE masinaId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteMasinaByIdSql)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

