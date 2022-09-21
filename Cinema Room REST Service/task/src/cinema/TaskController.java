package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static cinema.Cinema.getAllSeats;

@RestController
public class TaskController {
    private final Cinema cinema;

    //private final List<SelectedSeat> ticketList = new ArrayList<SelectedSeat>();

    public TaskController() {
        this.cinema = getAllSeats(9, 9);
    }

    @GetMapping("/seats")
    public Map<String, ?> getSeats() {
        return Map.of(
                "total_rows", cinema.getTotal_rows(),
                "total_columns", cinema.getTotal_columns(),
                "available_seats", cinema.getAvailable_seats()
        );
    }


    @PostMapping("/purchase")
        public ResponseEntity<?> purchase(@RequestBody Seat seat) {
        int row = seat.getRow();
        int column = seat.getColumn();

        List<Seat> availableSeats = cinema.getAvailable_seats();
        Seat selectedSeat = new Seat(row, column);

        if (row > 9 || row < 1 || column > 9 || column < 1) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }
//        for (int i = 0; i < cinema.getAvailable_seats().size(); i++) {
//            Seat s = cinema.getAvailable_seats().get(i);
            if (availableSeats.contains(selectedSeat)) {
                SelectedSeat SelectedSeat = new SelectedSeat(UUID.randomUUID(), selectedSeat);
                cinema.getSelectedSeats().add(SelectedSeat);
                cinema.getAvailable_seats().remove(seat);
                return new ResponseEntity<>(SelectedSeat, HttpStatus.OK);
            }
        //}
        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
    }
@PostMapping("/return")
public ResponseEntity<?> returnTicket(@RequestBody Token token){
    List<SelectedSeat> selectedSeats = cinema.getSelectedSeats();
    for (SelectedSeat selectedSeat : selectedSeats) {
        if (selectedSeat.getToken().equals(token.getToken())) {
            selectedSeats.remove(selectedSeat);
            cinema.getAvailable_seats().add(selectedSeat.getTicket());
            return new ResponseEntity<>(Map.of("returned_ticket", selectedSeat.getTicket()), HttpStatus.OK);
        }
    }
    return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
}
    @PostMapping("/stats")
    public ResponseEntity<?> stats(@RequestParam(required = false) String password) {
        if (password != null && password.equals("super_secret")) {
            Map<String, Integer> statistic = new HashMap<>();
            int currentIncome = 0;
            for (SelectedSeat SelectedSeat : cinema.getSelectedSeats()) {
                currentIncome += SelectedSeat.getTicket().getPrice();
            }
            int numberOfAvailableSeats = cinema.getAvailable_seats().size();
            int numberOfPurchasedTickets = cinema.getSelectedSeats().size();
            statistic.put("current_income", currentIncome);
            statistic.put("number_of_available_seats", numberOfAvailableSeats);
            statistic.put("number_of_purchased_tickets", numberOfPurchasedTickets);
            return new ResponseEntity<>(statistic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.valueOf(401));
        }
    }
}


        class InvalidSeatException extends RuntimeException {
            public InvalidSeatException(String message) {
                super(message);
            }
        }

