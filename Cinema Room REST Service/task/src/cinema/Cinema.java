//package cinema;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Cinema {
//    private int total_rows;
//    private int total_columns;
//    private List<Seat> available_seats;
//    @JsonIgnore
//    private List<SelectedSeat> SelectedSeats;
//
//    public Cinema(int total_rows, int total_columns, List<Seat> available_seats) {
//        this.total_rows = total_rows;
//        this.total_columns = total_columns;
//        this.available_seats = available_seats;
//        this.SelectedSeats = new ArrayList<>();
//    }
//
//    public static Cinema getAllSeats(int rows, int columns) {
//        List<Seat> seats = new ArrayList<>();
//        for (int row = 1; row <= rows; row++) {
//            for (int column = 1; column <= columns; column++) {
//                seats.add(new Seat(row, column));
//            }
//        }
//        return new Cinema(rows, columns, seats);
//    }
//
//
//    public int getTotal_rows() {
//        return total_rows;
//    }
//
//    public void setTotal_rows(int total_rows) {
//        this.total_rows = total_rows;
//    }
//
//    public int getTotal_columns() {
//        return total_columns;
//    }
//
//    public void setTotal_columns(int total_columns) {
//        this.total_columns = total_columns;
//    }
//
//    public List<Seat> getAvailable_seats() {
//        return available_seats;
//    }
//
//    public void setAvailable_seats(List<Seat> available_seats) {
//        this.available_seats = available_seats;
//    }
//
//    public List<SelectedSeat> getSelectedSeats() {
//        return SelectedSeats;
//    }
//
//    public void setSelectedSeats(List<SelectedSeat> SelectedSeats) {
//        this.SelectedSeats = SelectedSeats;
//    }
//
//    public List<Seat> getAvailableSeats() {
//        return available_seats;
//    }
//}
package cinema;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import java.util.ArrayList;
        import java.util.List;

//public class Cinema {

//    @JsonProperty("total_rows")
//    private int totalRows;
//    @JsonProperty("total_columns")
//    private int totalColumns;
//    @JsonProperty("available_seats")
//    private List<Seat> availableSeats;
//    public Cinema(int totalRows, int totalColumns) {
//        this.totalRows = totalRows;
//        this.totalColumns = totalColumns;
//        this.availableSeats = fillSeats();
//    }
    public class Cinema {
    private int total_rows;
    private int total_columns;
    private List<Seat> available_seats;
    @JsonIgnore
    private List<SelectedSeat> SelectedSeats;
        public Cinema(int total_rows, int total_columns, List<Seat> available_seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = available_seats;
        this.SelectedSeats = new ArrayList<>();
    }
    public static Cinema getAllSeats(int rows, int columns) {
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                seats.add(new Seat(row, column));
            }
        }
        return new Cinema(rows, columns, seats);
    }

    // getters and setters


    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }

    public void setSelectedSeats(List<SelectedSeat> selectedSeats) {
        SelectedSeats = selectedSeats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public List<SelectedSeat> getSelectedSeats() {
        return SelectedSeats;
    }
}