package tech.ada.exception;

public class TitleNotExistsException extends RuntimeException {
    public TitleNotExistsException(String mensagem) {
        super(mensagem);
    }
}
