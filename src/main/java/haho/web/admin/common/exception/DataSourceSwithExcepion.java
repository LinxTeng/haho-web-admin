package haho.web.admin.common.exception;

public class DataSourceSwithExcepion extends Exception {
    private static final long serialVersionUID = 1L;

    public DataSourceSwithExcepion() {
        super();
    }

    public DataSourceSwithExcepion(String msg) {
        super(msg);
    }

    public DataSourceSwithExcepion(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataSourceSwithExcepion(Throwable cause) {
        super(cause);
    }
}
