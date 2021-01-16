public class ErrorTreatment extends Exception {
    private String message;
    private String cause;
    private String description;

    ErrorTreatment(String message, String cause, String description) {
        this.cause = cause;
        this.message = message;
        this.description = description;
    }

    ErrorTreatment(String message, String cause) {
        this.cause = cause;
        this.message = message;
    }

    ErrorTreatment(String message) {
        this.message = message;
    }

    public void printException(int line){
        System.out.println("\n*****");
        System.out.println("Linha: "+line);
        System.out.print("Erro: "+this.message);
        if(this.cause != null)
            System.out.print(": "+this.cause);
        System.out.println();
        if(this.description != null)
            System.out.println("Descrição: "+this.description);
        System.out.println("*****");
    }
}

