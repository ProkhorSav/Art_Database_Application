package com.artclient.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.geometry.Insets;

import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;

public class ClientApp extends Application {

    private TableView<Author> table = new TableView<>();

    @id86240433 (@Override)
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Система управления коллекцией искусства");

        TableColumn<Author, String> firstNameCol = new TableColumn<>("Имя");
        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());

        TableColumn<Author, String> lastNameCol = new TableColumn<>("Фамилия");
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        table.getColumns().addAll(firstNameCol, lastNameCol);
        VBox vbox = new VBox(table);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        loadAuthors();
    }

    private void loadAuthors() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/api/authors"))
            .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(this::parseAuthors)
            .exceptionally(e -> {
                System.out.println("Ошибка при загрузке авторов: " + e.getMessage());
                return null;
            });
    }

    private void parseAuthors(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Author> authors = mapper.readValue(json, new TypeReference<List<Author»() {});
            ObservableList<Author> data = FXCollections.observableArrayList(authors);
            table.setItems(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
