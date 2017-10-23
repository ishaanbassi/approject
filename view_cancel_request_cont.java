package application;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;




public class view_cancel_request_cont implements javafx.fxml.Initializable {

	@FXML
	TableView<record> requests;
	@FXML
	TableColumn<record,Integer> sno;
	@FXML
	TableColumn<record,String> room;
	@FXML
	TableColumn<record,String> from;
	@FXML
	TableColumn<record,String> to;
	@FXML
	TableColumn<record,String> date;
	@FXML
	TableColumn<record,String> reason;
	@FXML
	TableColumn<record,String> status;
	@FXML
	TableColumn<record,Boolean> select;
	@FXML
	CheckBox c;
	@FXML
	Button back;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				try {
					Main.student_login();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		record s =new record();
		int count=0;
		count++;
		ObservableList<record> data= FXCollections.observableArrayList();
		s.setSno(count);
		s.setDate("a");
		s.setReason("a");
		s.setTo("a");
		s.setFrom("a");
		s.setRoom("a");
		s.setStatus("a");
		//s.setChoice(true);
		sno.setCellValueFactory(new PropertyValueFactory<record,Integer>("sno"));
		room.setCellValueFactory(new PropertyValueFactory<record,String>("room"));
		from.setCellValueFactory(new PropertyValueFactory<record,String>("from"));
		to.setCellValueFactory(new PropertyValueFactory<record,String>("to"));
		date.setCellValueFactory(new PropertyValueFactory<record,String>("date"));
		reason.setCellValueFactory(new PropertyValueFactory<record,String>("reason"));
		status.setCellValueFactory(new PropertyValueFactory<record,String>("status"));
		select.setCellValueFactory(new PropertyValueFactory<record,Boolean>("check"));
		select.setCellFactory(column -> new CheckBoxTableCell()); 
//		select.setCellFactory(CheckBoxTableCell.forTableColumn(new Callback<Integer, ObservableValue<Boolean>>() {
//
//		    @Override
//		    public ObservableValue<Boolean> call(Integer param) {
//		        //System.out.println("Cours "+items.get(param).getCours()+" changed value to " +items.get(param).isChecked());
//		        return data.get(param).getChoice();
//		    }
//		}));
		
		select.setCellValueFactory(
				new Callback<CellDataFeatures<record,Boolean>,ObservableValue<Boolean>>()
				{
				    //This callback tell the cell how to bind the data model 'Registered' property to
				    //the cell, itself.
				    @Override
				    public ObservableValue<Boolean> call(CellDataFeatures<record, Boolean> param)
				    {   
				        return param.getValue().getChoiceprop();
				    }   
				});
//		
		
		//ObservableList<record> data= FXCollections.observableArrayList();//new Callback<select, Observable[]>() {
//
//		    @Override
//		    public Observable[] call(select param) {
//		        return new Observable[] {param.checkedProperty()};
//		    }
//		});
		data.add(s);
		data.addListener(new ListChangeListener<record>() {

		    @Override
		    public void onChanged(ListChangeListener.Change<? extends record> c) {
		        while (c.next()) {
		            if (c.wasUpdated()) {
		            	System.out.println("yes");
		                //System.out.println("Cours "+data.get(c.getFrom()).getCours()+" changed value to " +items.get(c.getFrom()).isChecked());
		            }
		          }
		    }
		});
	
		requests.setItems(data); // assign the data to the table
		requests.setRowFactory(tv -> {
		    TableRow<record> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
		            record  rowData = row.getItem();

//		            System.out.println(rowData.getChoice());
//		            rowData.setChoice(true);
		        
		            //requests.getItems().set(0, rowData);
		            
		            System.out.println(rowData.getchoice());
		        }
		    });
		    return row ;
		});
		
		
		
	}
	
	
}
