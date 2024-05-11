package co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data;

public final class Message {

	private MessageCode _code;
	private String _content;
	
	public Message( final MessageCode code, final String content)
	{
		setCode(code);
		setContent(content);
	}

	public final MessageCode getCode() {
		return this._code;
	}

	public void setCode(MessageCode code) {
		this._code = code;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		this._content = content;
	}
	
	public final String getIdentifier()
	{
		return this.getCode().getIdentifier();
	}
	
	public boolean isBase()
	{
		return this._code.getIsBase();
	}
}
