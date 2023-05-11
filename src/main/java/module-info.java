module com.t12ejercicio9tresenraya {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.t12ejercicio9tresenraya to javafx.fxml;
    exports com.t12ejercicio9tresenraya;
}