package org.datayoo.moql;
/*
 *@ClassName  MoqlException
 *@description    TODO
 *@author     Whoami
 *@date   2020/5/9
 *@version 1.0
 */

public class MoqlException extends Exception {
    private static final long serialVersionUID = 1L;
    private String exceptionCode;

    /**
     * @param message exception description
     * @param cause   the original exception
     */
    public MoqlException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
        if (cause instanceof MoqlException) {
            exceptionCode = ((MoqlException) cause).exceptionCode;
        }
    }

    /**
     * @param message exception description
     */
    public MoqlException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause the original exception
     */
    public MoqlException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
        if (cause instanceof MoqlException) {
            exceptionCode = ((MoqlException) cause).exceptionCode;
        }
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}