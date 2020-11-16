package ee.bcs.valiit.tasks.BankController2.exceptions;

public class ErrorResponse {
    private String message;

    public ErrorResponse(String error) {
        this.message = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
