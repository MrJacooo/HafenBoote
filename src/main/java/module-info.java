module ch.bbw.pr.hafenboote {
	requires transitive javafx.base;
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
	requires transitive javafx.fxml;

    opens ch.bbw.pr.hafenboote to javafx.fxml;
    exports ch.bbw.pr.hafenboote;
    opens ch.bbw.pr.hafenboote.view to javafx.fxml;
    exports ch.bbw.pr.hafenboote.view;
}