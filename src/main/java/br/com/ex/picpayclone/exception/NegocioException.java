package br.com.ex.picpayclone.exception;

public class NegocioException extends RuntimeException {

    public NegocioException(String messagem) {
        super(messagem);
    }

    public NegocioException(String messagem, Exception exception) {
        super(messagem, exception);
    }

}
