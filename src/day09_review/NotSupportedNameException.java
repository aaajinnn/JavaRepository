package day09_review;

// Ex01
public class NotSupportedNameException extends Exception {

	public NotSupportedNameException() {
		super("NotSupportedNameException"); // 예외 메세지로 등록된다.
	}

	public NotSupportedNameException(String msg) {
		super(msg);
	}

}
