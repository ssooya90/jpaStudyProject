package ssooya.jpashop.exception;

/**
 * Created by ssooya90@naver.com on 2020-02-14
 * Github : http://github.com/ssooya90
 */

@SuppressWarnings("serial")
public class NotEnoughStockException extends RuntimeException{

	public NotEnoughStockException() {
	}

	public NotEnoughStockException(String message) {
		super(message);
	}

	public NotEnoughStockException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotEnoughStockException(Throwable cause) {
		super(cause);
	}
}
