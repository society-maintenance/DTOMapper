package com.minerav.dto.exception;

public class DTOMapperException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7731144583783580929L;

	public DTOMapperException() {
		super();
	}
	
	public DTOMapperException(String message) {
		super(message);
	}
	
    public DTOMapperException(String message, Throwable cause) {
        super(message, cause);
    }


    public DTOMapperException(Throwable cause) {
        super(cause);
    }

    protected DTOMapperException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
