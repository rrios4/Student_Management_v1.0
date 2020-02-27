package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;




public class Controller implements Initializable {

    @FXML
    JFXButton createDB;
    @FXML
    JFXButton deletetablebutton;
    @FXML
    JFXButton loaddatabutton;
    @FXML
    JFXButton filterAge;
    @FXML
    JFXButton filterMajor;
    @FXML
    JFXButton filterGPA;
    @FXML
    TextField sId;
    @FXML
    TextField sName;
    @FXML
    TextField sAge;
    @FXML
    TextField sGPA;
    @FXML
    TextField sMajor;

    @FXML
    JFXListView<Student> studentListView;

    final String hostname = "employee-db.cak03hrenxrh.us-east-1.rds.amazonaws.com";
    final String dbName = "testdb";
    final String port = "3306";
    final String username = "admin";
    final String password = "password";
    final String AWS_URL = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + username + "&password=" + password;
    final String DB_URL = "jdbc:derby:EmployeeDB;create=true";

/* This is based from the class code and just changed it to fit my server connections and insert my data need for this HW. I was trying to figure out how to create a loop but ended up being more complex to achive when dealing with the sql staments.
    so I ended up adding the students one by one on the code. Unless there was a way to bulk insert from a csv file but instead just manually created it in the createDb function.
    Also ran into a bug where every time I created the database and clicked it again right after it says the table already exist but still filled the same data into it.
    What I ended up doing was putting the INSERT statements into the try block instead of having it run right after the catch block and it fixed that bug. */
    private void createDB(String url)
    {
        try{

            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            try
            {
                stmt.execute("CREATE TABLE Student (" +
                        "Id VARCHAR(36), " +
                        "Name CHAR(25), " +
                        "Age CHAR(10), " +
                        "Major CHAR(30)," +
                        "GPA char(20))");

                System.out.println("TABLE CREATED");

                UUID id = UUID.randomUUID();
                String idString = id.toString();
                String  Name = url.equals(AWS_URL) ? "Osman Quintero" : "";
                String Age = url.equals(AWS_URL) ? "21" : "20";
                String Major = url.equals(AWS_URL) ? "Mathematic" : "";
                String GPA = url.equals(AWS_URL) ? "4.0" : "";

                String sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name + "', '" + Age + "', '" + Major+"', '" + GPA+"')";

                stmt.executeUpdate(sql);

                id = UUID.randomUUID();
                idString = id.toString();
                String  Name2 = url.equals(AWS_URL) ? "Brian Bolton" : " ";
                String Age2 = url.equals(AWS_URL) ? "20" : "";
                String Major2 = url.equals(AWS_URL) ? "Business Management" : "";
                String GPA2 = url.equals(AWS_URL) ?  "3.0" :"";

                sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name2 + "', '" + Age2 + "', '" + Major2+"', '" + GPA2+"')";
                stmt.executeUpdate(sql);

                id = UUID.randomUUID();
                idString = id.toString();
                String  Name3 = url.equals(AWS_URL) ? "Juan Cerda" : " ";
                String Age3 = url.equals(AWS_URL) ? "21" : "";
                String Major3 = url.equals(AWS_URL) ? "Chemistry" : "";
                String GPA3 = url.equals(AWS_URL) ?  "4.0" :"";

                sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name3 + "', '" + Age3 + "', '" + Major3+"', '" + GPA3+"')";
                stmt.executeUpdate(sql);

                id = UUID.randomUUID();
                idString = id.toString();
                String  Name4 = url.equals(AWS_URL) ? "Jose Gasca" : " ";
                String Age4 = url.equals(AWS_URL) ? "21" : "";
                String Major4 = url.equals(AWS_URL) ? "Computer Science" : "";
                String GPA4 = url.equals(AWS_URL) ?  "2.8" :"";

                sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name4 + "', '" + Age4 + "', '" + Major4+"', '" + GPA4+"')";
                stmt.executeUpdate(sql);

                id = UUID.randomUUID();
                idString = id.toString();
                String  Name5 = url.equals(AWS_URL) ? "Maria Almaguer" : " ";
                String Age5 = url.equals(AWS_URL) ? "20" : "";
                String Major5 = url.equals(AWS_URL) ? "Economics" : "";
                String GPA5 = url.equals(AWS_URL) ?  "3.8" :"";

                sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name5 + "', '" + Age5 + "', '" + Major5+"', '" + GPA5+"')";
                stmt.executeUpdate(sql);

                id = UUID.randomUUID();
                idString = id.toString();
                String  Name6 = url.equals(AWS_URL) ? "Robert Rios" : " ";
                String Age6 = url.equals(AWS_URL) ? "19" : "";
                String Major6 = url.equals(AWS_URL) ? "Computer Science" : "";
                String GPA6 = url.equals(AWS_URL) ?  "2.9" :"";

                sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name6 + "', '" + Age6 + "', '" + Major6+"', '" + GPA6+"')";
                stmt.executeUpdate(sql);

                id = UUID.randomUUID();
                idString = id.toString();
                String  Name7 = url.equals(AWS_URL) ? "Bettsy Delapaz" : " ";
                String Age7 = url.equals(AWS_URL) ? "21" : "";
                String Major7 = url.equals(AWS_URL) ? "Architecture" : "";
                String GPA7 = url.equals(AWS_URL) ?  "3.4" :"";

                sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name7 + "', '" + Age7 + "', '" + Major7+"', '" + GPA7+"')";
                stmt.executeUpdate(sql);

                id = UUID.randomUUID();
                idString = id.toString();
                String  Name8 = url.equals(AWS_URL) ? "Hector Escudero" : " ";
                String Age8 = url.equals(AWS_URL) ? "21" : "";
                String Major8 = url.equals(AWS_URL) ? "Biology" : "";
                String GPA8 = url.equals(AWS_URL) ?  "3.0" :"";

                sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name8 + "', '" + Age8 + "', '" + Major8+"', '" + GPA8+"')";
                stmt.executeUpdate(sql);

                id = UUID.randomUUID();
                idString = id.toString();
                String  Name9 = url.equals(AWS_URL) ? "Chris Hernandez" : " ";
                String Age9 = url.equals(AWS_URL) ? "21" : "";
                String Major9 = url.equals(AWS_URL) ? "Computer Science" : "";
                String GPA9 = url.equals(AWS_URL) ?  "3.2" :"";

                sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name9 + "', '" + Age9 + "', '" + Major9+"', '" + GPA9+"')";
                stmt.executeUpdate(sql);

                id = UUID.randomUUID();
                idString = id.toString();
                String  Name10 = url.equals(AWS_URL) ? "Adrian Perez" : " ";
                String Age10 = url.equals(AWS_URL) ? "21" : "";
                String Major10 = url.equals(AWS_URL) ? "Computer Science" : "";
                String GPA10 = url.equals(AWS_URL) ?  "3.1" :"";

                sql = "INSERT INTO Student VALUES" +
                        "('" + idString + "', '" + Name10 + "', '" + Age10 + "', '" + Major10+"', '" + GPA10+"')";
                stmt.executeUpdate(sql);

                System.out.println("TABLE FILLED");
            }
            catch (Exception ex)
            {
                System.out.println("TABLE ALREADY EXISTS, NOT CREATED");
            }

            stmt.close();
            conn.close();

        }
        catch (Exception ex)
        {
            String msg = ex.getMessage();
            System.out.println(msg);
        }
    }
    // This delete function was just like the one from the in-class project except I changed the table to be dropped to Student instead of Employee
    private void deleteTable(String url)
    {
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute("DROP TABLE Student");
            stmt.close();
            conn.close();
            System.out.println("TABLE DROPPED");
        }
        catch (Exception ex)
        {
            String msg = ex.getMessage();
            System.out.println("TABLE NOT DROPPED");
            System.out.println(msg);
        }
    }
    /*For loading the data it took me a while to understand because I was trying to figure out how to make a list from a SELECT script and show up in the text field when selected
    * From the in-class code I can see that we created an employee object and called the values according to from the employee class to store the data from the SQL statement into
    * the variables named in the Employee class. All I did was replace the values from employee to student that applied to the student class I made and it worked and was able
    * to make it add into the dbStudentList */
    private void loadData(String url)
    {
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sqlStatement = "SELECT Id, Name, Age, Major, GPA FROM Student";
            ResultSet result = stmt.executeQuery(sqlStatement);



            ObservableList<Student> dbStudentList = FXCollections.observableArrayList();
            while (result.next())
            {
                Student student = new Student();
                student.studentID = UUID.fromString(result.getString("Id"));
                student.studentName = result.getString("Name");
                student.studentAge = result.getInt("Age");
                student.studentMajor = result.getString("Major");
                student.studentGPA = result.getDouble("GPA");
                dbStudentList.add(student);

                /* I was having problems trying to have this selected observable value to work and I found out all I had to do was to call the Student class on the fxlist created from the sample.fxml file
                  at the top of the controller and it worked. :)
                 The problem was that every time I called the student list view on line 264 it was calling it as a object while it was expecting Student for it.*/
                studentListView.getSelectionModel().selectedItemProperty().addListener((
                        ObservableValue<? extends School> ov, School old_val, School new_val) ->
                {
                    School selectedItem = studentListView.getSelectionModel().getSelectedItem();
                    sId.setText(String.valueOf(((Student)selectedItem).studentID));
                    sName.setText(((Student)selectedItem).studentName);
                    sAge.setText(String.valueOf(((Student) selectedItem).studentAge));
                    sMajor.setText(String.valueOf(((Student) selectedItem).studentMajor));
                    sGPA.setText(String.valueOf(((Student)selectedItem).studentGPA));

                });
            }
            if(url.equals(AWS_URL))
                studentListView.setItems(dbStudentList);
            else
                studentListView.setItems(dbStudentList);

            System.out.println("DATA LOADED");
            stmt.close();
            conn.close();
        }
        catch (Exception ex)
        {
            String msg = ex.getMessage();
            System.out.println("DATA NOT LOADED");
            System.out.println(msg);
        }
    }
    /*Once I understood how the load button loads the data into a list my mindset was I can probably use the same code as the load button but change the SQL statement
    * to satisfy my filter need. And change the dbStudentList by a different number just in case it caused conflicting errors with the first list created in the load
    * button so I played it safe here. Once that was finished all I did was change System.out.println to FILTER WORKED if no exceptions where caught if and exception
    * was caught then ERROR AT FILTERING.*/
    public void filterAge(String url)
    {
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sqlStatement = "SELECT Id, Name, Age, Major, GPA FROM Student WHERE Age = 20";
            ResultSet result = stmt.executeQuery(sqlStatement);

            ObservableList<Student> dbStudentList2 = FXCollections.observableArrayList();
            while (result.next())
            {
                Student student = new Student();
                student.studentID = UUID.fromString(result.getString("Id"));
                student.studentName = result.getString("Name");
                student.studentAge = result.getInt("Age");
                student.studentMajor = result.getString("Major");
                student.studentGPA = result.getDouble("GPA");
                dbStudentList2.add(student);

                studentListView.getSelectionModel().selectedItemProperty().addListener((
                        ObservableValue<? extends School> ov, School old_val, School new_val) ->
                {
                    School selectedItem = studentListView.getSelectionModel().getSelectedItem();
                    sId.setText(String.valueOf(((Student)selectedItem).studentID));
                    sName.setText(((Student)selectedItem).studentName);
                    sAge.setText(String.valueOf(((Student) selectedItem).studentAge));
                    sMajor.setText(String.valueOf(((Student) selectedItem).studentMajor));
                    sGPA.setText(String.valueOf(((Student)selectedItem).studentGPA));
                });
            }
            if(url.equals(AWS_URL))
                studentListView.setItems(dbStudentList2);
            else
                studentListView.setItems(dbStudentList2);

            System.out.println("FILTER WORKS!");
            stmt.close();
            conn.close();
        }
        catch (Exception ex)
        {
            String msg = ex.getMessage();
            System.out.println("ERROR AT FILTERING");
        }
    }
    //Once I understood how my filtering will be done it just boiled down to copying my code into a new function and just changing the SQL statement to get what I wanted
    public void filterMajor(String url)
    {
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sqlStatement = "SELECT Id, Name, Age, Major, GPA FROM Student WHERE Major = 'Computer Science'";
            ResultSet result = stmt.executeQuery(sqlStatement);

            ObservableList<Student> dbStudentList3 = FXCollections.observableArrayList();
            while (result.next())
            {
                Student student = new Student();
                student.studentID = UUID.fromString(result.getString("Id"));
                student.studentName = result.getString("Name");
                student.studentAge = result.getInt("Age");
                student.studentMajor = result.getString("Major");
                student.studentGPA = result.getDouble("GPA");
                dbStudentList3.add(student);

                studentListView.getSelectionModel().selectedItemProperty().addListener((
                        ObservableValue<? extends School> ov, School old_val, School new_val) ->
                {
                    School selectedItem = studentListView.getSelectionModel().getSelectedItem();
                    sId.setText(String.valueOf(((Student)selectedItem).studentID));
                    sName.setText(((Student)selectedItem).studentName);
                    sAge.setText(String.valueOf(((Student) selectedItem).studentAge));
                    sMajor.setText(String.valueOf(((Student) selectedItem).studentMajor));
                    sGPA.setText(String.valueOf(((Student)selectedItem).studentGPA));
                });
            }
            if(url.equals(AWS_URL))
                studentListView.setItems(dbStudentList3);
            else
                studentListView.setItems(dbStudentList3);

            System.out.println("FILTER WORKS!");
            stmt.close();
            conn.close();
        }
        catch (Exception ex)
        {
            String msg = ex.getMessage();
            System.out.println("ERROR AT FILTERING");
        }
    }
    //Same applies to this too
    public void filterGPA(String url)
    {
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sqlStatement = "SELECT Id, Name, Age, Major, GPA FROM Student WHERE GPA <= 3.3";
            ResultSet result = stmt.executeQuery(sqlStatement);

            ObservableList<Student> dbStudentList4 = FXCollections.observableArrayList();
            while (result.next())
            {
                Student student = new Student();
                student.studentID = UUID.fromString(result.getString("Id"));
                student.studentName = result.getString("Name");
                student.studentAge = result.getInt("Age");
                student.studentMajor = result.getString("Major");
                student.studentGPA = result.getDouble("GPA");
                dbStudentList4.add(student);

                studentListView.getSelectionModel().selectedItemProperty().addListener((
                        ObservableValue<? extends School> ov, School old_val, School new_val) ->
                {
                    School selectedItem = studentListView.getSelectionModel().getSelectedItem();
                    sId.setText(String.valueOf(((Student)selectedItem).studentID));
                    sName.setText(((Student)selectedItem).studentName);
                    sAge.setText(String.valueOf(((Student) selectedItem).studentAge));
                    sMajor.setText(String.valueOf(((Student) selectedItem).studentMajor));
                    sGPA.setText(String.valueOf(((Student)selectedItem).studentGPA));
                });
            }
            if(url.equals(AWS_URL))
                studentListView.setItems(dbStudentList4);
            else
                studentListView.setItems(dbStudentList4);

            System.out.println("FILTER WORKS!");
            stmt.close();
            conn.close();
        }
        catch (Exception ex)
        {
            String msg = ex.getMessage();
            System.out.println("ERROR AT FILTERING");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //This is just like the in-class code just changed with the name of my buttons and functions. Oh also only using the AWS_URL for that extra credit ;)
        createDB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                createDB(AWS_URL);
            }
        });

        deletetablebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                deleteTable(AWS_URL);
            }
        });

        loaddatabutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                loadData(AWS_URL);
            }
        });

        filterAge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                filterAge(AWS_URL);
            }
        });

        filterMajor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                filterMajor(AWS_URL);
            }
        });

        filterGPA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                filterGPA(AWS_URL);
            }
        });
        //Tried to style my button but could not figure out how it works :(
        filterGPA.getStyleClass().add("filterGPA1");















    }
}
