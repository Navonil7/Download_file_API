package com.infrrd.FileAssignment.storage;

public class StorageException extends RuntimeException{
	
	private static final long serialVersionUID = 1774243717132507470L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
