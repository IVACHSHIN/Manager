package sample.javaController;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import sample.BL.Person;

public class MainController implements Initializable {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfYear;

    @FXML
    private TextField tfDok;

    @FXML
    private TextField tfTel;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfTariff;

    @FXML
    private TextField tfPrice;

    @FXML
    private TableView<Person> tvPerson;

    @FXML
    private TableColumn<Person, Integer> colId;

    @FXML
    private TableColumn<Person, String> colName;

    @FXML
    private TableColumn<Person, String> colLastName;

    @FXML
    private TableColumn<Person, Integer> colYear;

    @FXML
    private TableColumn<Person, Integer> colDok;
    @FXML
    private TableColumn<Person, Integer> colTel;

    @FXML
    private TableColumn<Person, String> colEmail;

    @FXML
    private TableColumn<Person, String> colTariff;

    @FXML
    private TableColumn<Person, Integer> colPrice;


    @FXML
    private VBox tfBoxPerson;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField filterField;

    @FXML
    private Button handlePrintInvoice;

    public MainController() {

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {


        if (event.getSource() == btnInsert) {
            insertRecord();
        } else if
        (event.getSource() == btnUpdate) {
            updateRecord();
        } else if (event.getSource() == btnDelete) {
            deleteButton();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        showPerson();
        search_user();
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            return conn;
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return null;
        }
    }
    public ObservableList<Person> getPersonList () {
        ObservableList<Person> userList = FXCollections.observableArrayList();
        ObservableList<Person> dataList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM person";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Person person;
            while (rs.next()) {
                person = new Person(
                        rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getInt("year"),
                        rs.getInt("dok"),
                        rs.getInt("tel"),
                        rs.getString("email"),
                        rs.getString("tariff"),
                        rs.getInt("price"));
                userList.add(person);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    public void showPerson() {
        ObservableList<Person> list = getPersonList();
        colId.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        colYear.setCellValueFactory(new PropertyValueFactory<Person, Integer>("year"));
        colDok.setCellValueFactory(new PropertyValueFactory<Person, Integer>("dok"));
        colTel.setCellValueFactory(new PropertyValueFactory<Person, Integer>("tel"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        colTariff.setCellValueFactory(new PropertyValueFactory<Person, String>("tariff"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Person, Integer>("price"));
        tvPerson.setItems(list);
    }

    private void insertRecord() {

        String query = "INSERT INTO person VALUES ("
                + tfId.getText() + ",'"
                + tfName.getText() + "','"
                + tfLastName.getText() + "','"
                + tfYear.getText() + "','"
                + tfDok.getText() + "','"
                + tfTel.getText() + "','"
                + tfEmail.getText() + "','"
                + tfTariff.getText() + "',"
                + tfPrice.getText() + ")";
        executeQuery(query);
        showPerson();
        search_user();
    }

    private void updateRecord() {
        String query = "UPDATE person SET " +
                "name = '" + tfName.getText() +
                "', lastname = '" + tfLastName.getText() +
                "', year = '" + tfYear.getText() +
                "', dok = '" + tfDok.getText() +
                "', tel = '" + tfTel.getText() +
                "', email = '" + tfEmail.getText() +
                "', tariff ='" + tfTariff.getText() +
                "', price = "  + tfPrice.getText() +
                " WHERE id = " + tfId.getText() + "";
        executeQuery(query);
        showPerson();
        search_user();
    }

    private void deleteButton() {
        String query = "DELETE FROM person WHERE id = "
                + tfId.getText() + "";
        executeQuery(query);
        showPerson();
        search_user();
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      }

    @FXML
    private void handleMouseAction(javafx.scene.input.MouseEvent mouseEvent) {
        Person user = tvPerson.getSelectionModel().getSelectedItem();
        tfId.setText("" + user.getId());
        tfName.setText("" + user.getName());
        tfLastName.setText("" + user.getLastname());
        tfYear.setText("" + user.getYear());
        tfDok.setText("" + user.getDok());
        tfTel.setText("" + user.getTel());
        tfEmail.setText("" + user.getEmail());
        tfTariff.setText("" + user.getTariff());
        tfPrice.setText("" + user.getPrice());
    }

    public ObservableList<Person> getDataList () {
        ObservableList<Person> datalist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM person";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Person person;
            while (rs.next()) {
                person = new Person(
                        rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getInt("year"),
                        rs.getInt("dok"),
                        rs.getInt("tel"),
                        rs.getString("email"),
                        rs.getString("tariff"),
                        rs.getInt("price"));
                datalist.add(person);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return datalist;
    }

    @FXML
    private void search_user() {
        ObservableList<Person> datalist = getPersonList();
        colId.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        colYear.setCellValueFactory(new PropertyValueFactory<Person, Integer>("year"));
        colDok.setCellValueFactory(new PropertyValueFactory<Person, Integer>("dok"));
        colTel.setCellValueFactory(new PropertyValueFactory<Person, Integer>("tel"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        colTariff.setCellValueFactory(new PropertyValueFactory<Person, String>("tariff"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Person, Integer>("price"));

        datalist = getPersonList();
        tvPerson.setItems(datalist);
        FilteredList<Person> filteredData = new FilteredList<>(datalist, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (Person.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Person.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Person.getTariff().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;
            });
            });
        SortedList<Person> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvPerson.comparatorProperty());
        tvPerson.setItems(sortedData);
    }
}