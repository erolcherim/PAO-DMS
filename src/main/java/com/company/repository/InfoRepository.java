package com.company.repository;

import java.sql.*;

import com.company.classes.Info;
import com.company.config.DatabaseConfiguration;

public class InfoRepository {

    static InfoRepository infoRepo = new InfoRepository();

    private InfoRepository(){};

    public static InfoRepository getInstance(){
        return infoRepo;
    }
    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS info " +
                "(infoId int PRIMARY KEY AUTO_INCREMENT, " +
                "nume varchar(30), " +
                "prenume varchar(30), " +
                "dataNasterii date, " +
                "numarTelefon varchar(10), " +
                "adresa varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String dropTableSql = "DROP TABLE info";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSql);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void createInfo(Info info){
        String insertInfoSql = "INSERT INTO info(nume, prenume, dataNasterii, numarTelefon , adresa) VALUES("
                    + "\'" + info.getNume() +"\'" + ","
                    + "\'" + info.getPrenume() + "\'" + ","
                    +"\'"+info.getdataNasterii()+"\'" + ","
                    +"\'"+info.getnumarTelefon()+"\'" +","
                    +"\'"+info.getAdresa()+"\')";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(insertInfoSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAllInfo() {
        String selectInfoSql = "SELECT * FROM info";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectInfoSql);
            while (resultSet.next()) {
                System.out.println("InfoId:" + resultSet.getString(1));
                System.out.println("Nume:" + resultSet.getString(2));
                System.out.println("Preunme:" + resultSet.getString(3));
                System.out.println("Data Nasterii:" + resultSet.getDate(4));
                System.out.println("Numar Telefon:" + resultSet.getString(5));
                System.out.println("Adresa:" + resultSet.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Info selectInfoById(int id) {
        String selectInfoSql = "SELECT * FROM info WHERE infoId = "+id;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectInfoSql);
            while (resultSet.next()) {
                System.out.println("InfoId:" + resultSet.getString(1));
                System.out.println("Nume:" + resultSet.getString(2));
                System.out.println("Preunme:" + resultSet.getString(3));
                System.out.println("Data Nasterii:" + resultSet.getDate(4));
                System.out.println("Numar Telefon:" + resultSet.getString(5));
                System.out.println("Adresa:" + resultSet.getString(6));
            }
            return mapToInfo(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void updateInfoNumePrenume(String nume, String prenume, int id){
        String updateInfoNumePrenumeSql = "UPDATE info SET nume=?, prenume=? WHERE infoId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateInfoNumePrenumeSql)) {
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, prenume);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Info mapToInfo(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Info(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3).toString(), resultSet.getString(4), resultSet.getString(5));
        }
        return null;
    }

    public void deleteInfoById(int id){
        String deleteInfoById = "DELETE FROM info WHERE infoId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteInfoById)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
